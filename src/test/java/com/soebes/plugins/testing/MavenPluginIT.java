package com.soebes.plugins.testing;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.soebes.itf.jupiter.extension.MavenGoal;
import com.soebes.itf.jupiter.extension.MavenJupiterExtension;
import com.soebes.itf.jupiter.extension.MavenProfile;
import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;
import com.soebes.itf.jupiter.maven.MavenProjectResult;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.soebes.itf.extension.assertj.MavenExecutionResultAssert.assertThat;

@MavenJupiterExtension
class MavenPluginIT {

  @BeforeEach
  void beforeEach(TestInfo testInfo, MavenProjectResult result) throws GitAPIException, URISyntaxException {
    String methodName = testInfo.getTestMethod()
        .orElseThrow(IllegalArgumentException::new)
        .getName();
    File targetProjectDirectory = result.getTargetProjectDirectory();

    Path path = Paths.get(targetProjectDirectory.getAbsolutePath());
    File targetProjectBaseDirectory = path.getParent().toFile();

    //Create a directory based on the method name.
    File remoteRepo = new File(targetProjectBaseDirectory, methodName + ".git" );
    remoteRepo.mkdir();

    var cloneRepository = Git
        .cloneRepository()
        .setDirectory(remoteRepo)
        .setURI("https://github.com/apache/maven-javadoc-plugin.git")
        .call();
  }

  @MavenTest
  @MavenGoal("verify")
  @MavenProfile("run-its")
  void maven_javadoc_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

}
