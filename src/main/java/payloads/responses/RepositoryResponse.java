package payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
public class RepositoryResponse {

    @JsonProperty
    private int id;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty
    private Owner owner;
    @JsonProperty("private")
    private boolean isPrivate;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty
    private String description;
    @JsonProperty
    private boolean fork;
    @JsonProperty
    private String url;
    @JsonProperty("archive_url")
    private String archiveUrl;
    @JsonProperty("assignees_url")
    private String assigneesUrl;
    @JsonProperty("blobs_url")
    private String blobsUrl;
    @JsonProperty("branches_url")
    private String branchesUrl;
    @JsonProperty("collaborators_url")
    private String collaboratorsUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("commits_url")
    private String commitsUrl;
    @JsonProperty("compare_url")
    private String compareUrl;
    @JsonProperty("contents_url")
    private String contentsUrl;
    @JsonProperty("contributors_url")
    private String contributorsUrl;
    @JsonProperty("deployments_url")
    private String deploymentsUrl;
    @JsonProperty("downloads_url")
    private String downloadsUrl;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("forks_url")
    private String forksUrl;
    @JsonProperty("git_commits_url")
    private String gitCommitsUrl;
    @JsonProperty("git_refs_url")
    private String gitRefsUrl;
    @JsonProperty("git_tags_url")
    private String gitTagsUrl;
    @JsonProperty("git_url")
    private String gitUrl;
    @JsonProperty("issue_comment_url")
    private String issueCommentUrl;
    @JsonProperty("issue_events_url")
    private String issueEventsUrl;
    @JsonProperty("issues_url")
    private String issuesUrl;
    @JsonProperty("keys_url")
    private String keysUrl;
    @JsonProperty("labels_url")
    private String labelsUrl;
    @JsonProperty("languages_url")
    private String languagesUrl;
    @JsonProperty("merges_url")
    private String mergesUrl;
    @JsonProperty("milestones_url")
    private String milestonesUrl;
    @JsonProperty("notifications_url")
    private String notificationsUrl;
    @JsonProperty("pulls_url")
    private String pullsUrl;
    @JsonProperty("releases_url")
    private String releasesUrl;
    @JsonProperty("ssh_url")
    private String sshUrl;
    @JsonProperty("stargazers_url")
    private String stargazersUrl;
    @JsonProperty("statuses_url")
    private String statusesUrl;
    @JsonProperty("subscribers_url")
    private String subscribersUrl;
    @JsonProperty("subscription_url")
    private String subscriptionUrl;
    @JsonProperty("tags_url")
    private String tagsUrl;
    @JsonProperty("teams_url")
    private String teamsUrl;
    @JsonProperty("trees_url")
    private String treesUrl;
    @JsonProperty("clone_url")
    private String cloneUrl;
    @JsonProperty("mirror_url")
    private String mirrorUrl;
    @JsonProperty("hooks_url")
    private String hooksUrl;
    @JsonProperty("svn_url")
    private String svnUrl;
    @JsonProperty
    private String homepage;
    @JsonProperty
    private String organization;
    @JsonProperty
    private String language;
    @JsonProperty
    private int forks;
    @JsonProperty("forks_count")
    private int forksCount;
    @JsonProperty("stargazers_count")
    private int stargazersCount;
    @JsonProperty("watchers_count")
    private int watchersCount;
    @JsonProperty
    private int watchers;
    @JsonProperty
    private int size;
    @JsonProperty("default_branch")
    private String defaultBranch;
    @JsonProperty("open_issues")
    private int openIssues;
    @JsonProperty("open_issues_count")
    private int openIssuesCount;
    @JsonProperty("is_template")
    private boolean isTemplate;
    @JsonProperty
    private License license;
    @JsonProperty
    private ArrayList<String> topics;
    @JsonProperty("has_issues")
    private boolean hasIssues;
    @JsonProperty("has_projects")
    private boolean hasProjects;
    @JsonProperty("has_wiki")
    private boolean hasWiki;
    @JsonProperty("has_pages")
    private boolean hasPages;
    @JsonProperty("has_downloads")
    private boolean hasDownloads;
    @JsonProperty("has_discussions")
    private boolean hasDiscussions;
    @JsonProperty
    private boolean archived;
    @JsonProperty
    private boolean disabled;
    @JsonProperty
    private String visibility;
    @JsonProperty("pushed_at")
    private LocalDateTime pushedAt;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
    @JsonProperty
    private Permissions permissions;
    @JsonProperty("allow_rebase_merge")
    private boolean allowRebaseMerge;
    @JsonProperty("template_repository")
    private String templateRepository;
    @JsonProperty("temp_clone_token")
    private String tempCloneToken;
    @JsonProperty("allow_squash_merge")
    private boolean allowSquashMerge;
    @JsonProperty("allow_auto_merge")
    private boolean allowAutoMerge;
    @JsonProperty("delete_branch_on_merge")
    private boolean deleteBranchOnMerge;
    @JsonProperty("allow_merge_commit")
    private boolean allowMergeCommit;
    @JsonProperty("allow_forking")
    private boolean allowForking;
    @JsonProperty("subscribers_count")
    private int subscribersCount;
    @JsonProperty("network_count")
    private int networkCount;
    @JsonProperty("web_commit_signoff_required")
    private boolean webCommitSignoffRequired;
    @JsonProperty("allow_update_branch")
    private boolean allowUpdateBranch;
    @JsonProperty("use_squash_pr_title_as_default")
    private boolean useSquashPrTitleAsDefault;
    @JsonProperty("squash_merge_commit_message")
    private String squashMergeCommitMessage;
    @JsonProperty("squash_merge_commit_title")
    private String squashMergeCommitTitle;
    @JsonProperty("merge_commit_message")
    private String mergeCommitMessage;
    @JsonProperty("merge_commit_title")
    private String mergeCommitTitle;
}
