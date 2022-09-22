package com.soebes.plugins.testing;

import com.soebes.itf.jupiter.maven.MavenProjectResult;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.util.Arrays;

class BaseIntegration {

  @BeforeEach
  void beforeEach(TestInfo testInfo, MavenProjectResult result) throws GitAPIException {
    System.out.println("testInfo = " + testInfo);
    System.out.println("method = " + testInfo.getTestMethod());
    var method = testInfo.getTestMethod().orElseThrow(IllegalStateException::new);
    var annotations = method.getAnnotations();
    Arrays.stream(annotations).forEach(s -> System.out.println("Annotation: = " + s));
    if (!method.isAnnotationPresent(GitRepo.class)) {
      throw new IllegalStateException("@GitRepo Annotation does not exist");
    }
    var gitRepoAnnotation = method.getAnnotation(GitRepo.class);
    String repositoryBase = gitRepoAnnotation.repositoryBase();
    String repo = gitRepoAnnotation.value();

    //TODO: Check for empty value!!
    String gitRepo = repositoryBase + "/" + repo + ".git";
    System.out.println("gitRepo = " + gitRepo);

    try (var cloneRepository = Git
        .cloneRepository()
        .setDirectory(result.getTargetProjectDirectory().toFile())
        .setURI(gitRepo)
//        .setBranch("mvn4")
        .call()) {
      System.out.println("cloneRepository = " + cloneRepository);
    }

  }

}
