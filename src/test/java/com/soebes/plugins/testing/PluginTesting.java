package com.soebes.plugins.testing;

import com.soebes.itf.jupiter.extension.MavenJupiterExtension;
import com.soebes.itf.jupiter.extension.MavenProjectSources;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.soebes.itf.jupiter.extension.MavenProjectSources.ResourceUsage.NONE;

@MavenJupiterExtension
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@MavenProjectSources(resourcesUsage = NONE)
public @interface PluginTesting {
}
