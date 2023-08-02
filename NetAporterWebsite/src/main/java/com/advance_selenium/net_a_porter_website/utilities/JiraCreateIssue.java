//This is for Custom Annotation to be used inside Selenium tests.
package com.advance_selenium.net_a_porter_website.utilities;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)

public @interface JiraCreateIssue {

	boolean isCreateIssue();

}
