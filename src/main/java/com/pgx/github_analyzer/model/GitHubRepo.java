package com.pgx.github_analyzer.model;

public class GitHubRepo {

    private String name;
    private int stargazers_count;
    private int forks_count;
    private String language;

    public String getName() { return name; }
    public int getStargazers_count() { return stargazers_count; }
    public int getForks_count() { return forks_count; }
    public String getLanguage() { return language; }

    public void setName(String name) { this.name = name; }
    public void setStargazers_count(int stargazers_count) { this.stargazers_count = stargazers_count; }
    public void setForks_count(int forks_count) { this.forks_count = forks_count; }
    public void setLanguage(String language) { this.language = language; }
}