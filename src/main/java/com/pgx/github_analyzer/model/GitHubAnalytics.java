package com.pgx.github_analyzer.model;

public class GitHubAnalytics {

    private String username;
    private int totalRepos;
    private int totalStars;
    private int totalForks;
    private String mostUsedLanguage;

    // Getters
    public String getUsername() { return username; }
    public int getTotalRepos() { return totalRepos; }
    public int getTotalStars() { return totalStars; }
    public int getTotalForks() { return totalForks; }
    public String getMostUsedLanguage() { return mostUsedLanguage; }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setTotalRepos(int totalRepos) { this.totalRepos = totalRepos; }
    public void setTotalStars(int totalStars) { this.totalStars = totalStars; }
    public void setTotalForks(int totalForks) { this.totalForks = totalForks; }
    public void setMostUsedLanguage(String mostUsedLanguage) { this.mostUsedLanguage = mostUsedLanguage; }
}