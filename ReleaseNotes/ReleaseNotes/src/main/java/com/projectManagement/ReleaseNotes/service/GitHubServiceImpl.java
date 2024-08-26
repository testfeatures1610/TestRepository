package com.projectManagement.ReleaseNotes.service;

import lombok.SneakyThrows;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;

public class GitHubServiceImpl implements GithubService {

    private final GitHub gitHub;

    public GitHubServiceImpl(@Value("${github.token}") String token) throws IOException {
        this.gitHub = GitHub.connectUsingOAuth(token);
    }

    @SneakyThrows
    public List<GHCommit> getCommits(String owner, String repo) {
        return gitHub.getRepository(owner + "/" + repo).listCommits().toList();
    }

    @SneakyThrows
    public List<GHPullRequest> getPullRequests(String owner, String repo) {
        return gitHub.getRepository(owner + "/" + repo).getPullRequests(GHIssueState.ALL);
    }
}
