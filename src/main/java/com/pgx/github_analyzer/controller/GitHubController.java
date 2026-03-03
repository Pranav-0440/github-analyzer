package com.pgx.github_analyzer.controller;

import org.springframework.web.bind.annotation.*;

import com.pgx.github_analyzer.model.GitHubAnalytics;
import com.pgx.github_analyzer.service.GitHubService;

@RestController
@RequestMapping("/api/github")
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    // Basic user info endpoint (optional - keep if you want)
    @GetMapping("/{username}")
    public Object getUser(@PathVariable String username) {
        return gitHubService.getUser(username);
    }

    // Analytics endpoint
    @GetMapping("/analytics/{username}")
    public GitHubAnalytics getAnalytics(@PathVariable String username) {
        return gitHubService.getUserAnalytics(username);
    }
}