package com.projectManagement.ReleaseNotes.Jobs;

import com.projectManagement.ReleaseNotes.service.GithubService;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHPullRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GitHubJob {

    @Autowired
    private GithubService gitHubService;

    @Value("${github.owner}")
    private String owner;

    @Value("${github.repo}")
    private String repo;


    @Scheduled(cron = "0 0 12 * * ?")
    public void fetchGitHubData() {

        List<GHCommit> commits = gitHubService.getCommits(owner, repo);
        List<GHPullRequest> pullRequests = gitHubService.getPullRequests(owner, repo);

        // Process the commits and pull requests as needed
        System.out.println("Fetched " + commits.size() + " commits and " + pullRequests.size() + " pull requests.");

    }
}
