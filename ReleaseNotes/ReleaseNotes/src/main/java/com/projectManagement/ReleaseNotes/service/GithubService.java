package com.projectManagement.ReleaseNotes.service;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHPullRequest;

import java.util.List;

public interface GithubService {

    List<GHCommit> getCommits(String owner, String repo);
    List<GHPullRequest> getPullRequests(String owner, String repo);
}
