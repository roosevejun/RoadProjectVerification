package com.tongtu.roadproject.verifification.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;


@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface EventBusInfo {
}
