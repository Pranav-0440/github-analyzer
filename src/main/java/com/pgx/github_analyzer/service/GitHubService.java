package com.pgx.github_analyzer.service;

import com.pgx.github_analyzer.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GitHubService {

    private final String BASE_URL = "https://api.github.com/users/";

    @Value("${github.token}")
    private String githubToken;

    private final RestTemplate restTemplate = new RestTemplate();

    // Basic user info
    public GitHubUser getUser(String username) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + githubToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<GitHubUser> response =
                restTemplate.exchange(
                        BASE_URL + username,
                        HttpMethod.GET,
                        entity,
                        GitHubUser.class
                );

        return response.getBody();
    }

    // Analytics logic
    public GitHubAnalytics getUserAnalytics(String username) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + githubToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<GitHubRepo[]> response =
                restTemplate.exchange(
                        BASE_URL + username + "/repos",
                        HttpMethod.GET,
                        entity,
                        GitHubRepo[].class
                );

        GitHubRepo[] repos = response.getBody();

        if (repos == null) {
            throw new RuntimeException("User not found or no repositories");
        }

        int totalStars = 0;
        int totalForks = 0;
        Map<String, Integer> languageCount = new HashMap<>();

        for (GitHubRepo repo : repos) {

            totalStars += repo.getStargazers_count();
            totalForks += repo.getForks_count();

            if (repo.getLanguage() != null) {
                languageCount.put(
                        repo.getLanguage(),
                        languageCount.getOrDefault(repo.getLanguage(), 0) + 1
                );
            }
        }

        String mostUsedLanguage = languageCount.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");

        GitHubAnalytics analytics = new GitHubAnalytics();
        analytics.setUsername(username);
        analytics.setTotalRepos(repos.length);
        analytics.setTotalStars(totalStars);
        analytics.setTotalForks(totalForks);
        analytics.setMostUsedLanguage(mostUsedLanguage);

        return analytics;
    }
}