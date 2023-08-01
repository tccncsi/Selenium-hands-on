//This is for Custom Annotation to be used inside Selenium tests.
package com.utilities;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)

public @interface JiraCreateIssue {

	boolean isCreateIssue();

}
