package com.soebes.plugins.testing;

import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;

import static com.soebes.itf.extension.assertj.MavenExecutionResultAssert.assertThat;

@PluginTesting
class PluginIT extends BaseIntegration {

  @MavenTest
  @GitRepo("maven-enforcer")
  void maven_enforcer(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

  @MavenTest
  @GitRepo("maven-jar-plugin")
  void maven_jar_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

  @MavenTest
  @GitRepo("maven-install-plugin")
  void maven_install_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

  @MavenTest
  @GitRepo("maven-javadoc-plugin")
  void maven_javadoc_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

}
