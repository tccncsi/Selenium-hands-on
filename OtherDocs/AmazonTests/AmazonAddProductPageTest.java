package com.testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.AmazonAddProductPage;
import com.pageObjects.AmazonBabyPage;
import com.pageObjects.AmazonPage;
import com.utilities.JiraCreateIssue;

public class AmazonAddProductPageTest extends BaseClass
{
	
	AmazonPage amazonpage;
	AmazonBabyPage amazonbabypage;
	AmazonAddProductPage amazonaddproductpage;
	

	
	  @JiraCreateIssue(isCreateIssue = true)	  
	  @Test(priority = 3, enabled = true) 
	  public void addProductToCart() throws InterruptedException, IOException 
	  { 
		   
		  amazonaddproductpage = new AmazonAddProductPage(driver);
		  amazonaddproductpage.login();
		  amazonaddproductpage.navigateToProductPage();
		  amazonaddproductpage.selectProduct();
		  amazonaddproductpage.addToCart(); 
	      amazonaddproductpage.verifyProductAdded();
	      amazonaddproductpage.verifyShoppingCart(); 
	  }
	 
}
