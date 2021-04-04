package lecture6.api;

import org.kohsuke.github.*;

import java.io.IOException;

public class GitHubApi {
  public static void main(String[] args) {
    String token = "I'm very lazy";

    try {
      GitHub github = new GitHubBuilder().withOAuthToken(token).build();
      createRepo(github);
      listMyRepos(github);
      deleteComments(github);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void deleteComments(GitHub github) throws IOException {
    GHUser owner = github.getUser("IlyaHalsky");
    GHRepository repo = owner.getRepository("scala-3-test");
    PagedIterable<GHCommitComment> comments = repo.listCommitComments("19e9e41ef1f0bdbb72dc3e91fb2a39033e5fd16a");
    for (GHCommitComment comment: comments) {
      comment.delete();
    }
  }

  private static void listMyRepos(GitHub github) throws IOException {
    GHUser me = github.getUser("IlyaHalsky");
    PagedIterable<GHRepository> repos = me.listRepositories();
    for (GHRepository repo : repos) {
      System.out.println(repo.getName());
    }
  }

  private static void createRepo(GitHub github) throws IOException {
    GHRepository repo = github
        .createRepository("test-repo")
        .description("this is test repo")
        .gitignoreTemplate("Java")
        .homepage("test.test")
        .create();
  }
}

