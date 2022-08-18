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

import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;
import com.soebes.itf.jupiter.maven.MavenProjectResult;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.soebes.itf.extension.assertj.MavenExecutionResultAssert.assertThat;

@PluginTesting
class MavenJavaDocPluginIT {

  @BeforeEach
  void beforeEach(MavenProjectResult result) throws GitAPIException, IOException {
    Files.deleteIfExists(Paths.get(result.getTargetProjectDirectory().toPath().toString(), "pom.xml"));
    Files.deleteIfExists(Paths.get(result.getTargetProjectDirectory().toPath().toString(), ".gitignore"));

    System.out.println("destination = " + result.getTargetProjectDirectory().toPath());

    try (var cloneRepository = Git
        .cloneRepository()
        .setDirectory(result.getTargetProjectDirectory())
        .setURI("https://github.com/apache/maven-javadoc-plugin.git")
//        .setBranch("mvn4")
        .call()) {
      System.out.println("cloneRepository = " + cloneRepository);
    }
  }

  @MavenTest
  void maven_javadoc_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

}
