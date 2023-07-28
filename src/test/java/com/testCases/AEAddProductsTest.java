package com.testCases;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.AEAddProductsPage;
import com.utilities.JiraCreateIssue;

public class AEAddProductsTest extends BaseClass {

    AEAddProductsPage aeaddproducts;

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void addProductsTest() throws InterruptedException {
        aeaddproducts = new AEAddProductsPage(driver);

        System.out.println("---------------- American Eagle Website Opened ------------------");

        // Accept cookies
        aeaddproducts.acceptCookie();

        // Hover over Clearance Menu
        aeaddproducts.hoverOverClearanceMenu();

        // Wait for menu options to load
        Thread.sleep(2000);

        // Select "Top" option from the menu
        aeaddproducts.selectOnTopOption();
        
        // Click on the product with the lowest price
        aeaddproducts.clickOnProductWithLowestPrice();
        
        // Verify product prices
        //aeaddproducts.VerifyProductPrices(); //assert
 
        // Getting available product sized
        aeaddproducts.getAvailableProuductSize();
        
        // Increase product quantity
        aeaddproducts.IncreaseProductQuantity();
        
        // Click on Add to Bag button
        aeaddproducts.clickOnAddToBagButton();
        
        // Click on View Bag Button
        aeaddproducts.clickOnViewBagButton();
        
        // Verify product details added to the Bag
        aeaddproducts.verifyBagProductDetails();
    }
}
