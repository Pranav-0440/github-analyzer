package com.pgx.github_analyzer.model;

import lombok.Data;

@Data
public class GitHubUser {
    private String login;
    private int public_repos;
    private int followers;
    private int following;
}