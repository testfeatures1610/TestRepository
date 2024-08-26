package com.projectManagement.ReleaseNotes.Controllers;

import com.projectManagement.ReleaseNotes.service.GithubService;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHPullRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/github")
public class GitHubController {

    @Autowired
    private GithubService gitHubService;

    @GetMapping("/commits/{owner}/{repo}")
    public List<GHCommit> getCommits(@PathVariable String owner, @PathVariable String repo) throws IOException {
        return gitHubService.getCommits(owner, repo);
    }

    @GetMapping("/pullrequests/{owner}/{repo}")
    public List<GHPullRequest> getPullRequests(@PathVariable String owner, @PathVariable String repo) throws IOException {
        return gitHubService.getPullRequests(owner, repo);
    }
}
