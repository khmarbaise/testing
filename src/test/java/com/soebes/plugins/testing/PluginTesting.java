package com.soebes.plugins.testing;

import com.soebes.itf.jupiter.extension.MavenJupiterExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MavenJupiterExtension(resourcesIts = false)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PluginTesting {
}
