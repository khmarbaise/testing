package com.soebes.plugins.testing;

import com.soebes.itf.jupiter.extension.MavenDebug;
import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;

import static com.soebes.itf.extension.assertj.MavenExecutionResultAssert.assertThat;

@PluginTesting
//@GitBranch("mvn4")
class PluginIT extends BaseIntegration {

  @MavenTest
  @GitRepo("maven-clean-plugin")
  void maven_clean_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

  @MavenTest
  @GitRepo("maven-compiler-plugin")
  void maven_compiler_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

  @MavenTest
  @GitRepo("maven-deploy-plugin")
  void maven_deploy_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

  @MavenTest
  @GitRepo("maven-install-plugin")
  void maven_install_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

  @MavenTest
  @GitRepo("maven-resources-plugin")
  void maven_resources_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

  @MavenTest
  @GitRepo("maven-ear-plugin")
  void maven_ear_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

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
  @GitRepo("maven-javadoc-plugin")
  @MavenDebug
  void maven_javadoc_plugin(MavenExecutionResult result) {
    assertThat(result).isSuccessful();
  }

}
