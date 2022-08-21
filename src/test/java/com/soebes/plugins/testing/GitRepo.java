package com.soebes.plugins.testing;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GitRepo {

  String repositoryBase() default "https://github.com/apache";

  String value() default "";

}
