package com.advancedselenium.net_a_porter_website.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class AEHomePage extends BasePage{

	public AEHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='onetrust-button-group']")
	WebElement popup;
	
	@FindBy(xpath="//*[@id='onetrust-accept-btn-handler']")
	WebElement popup_accept_all_btn;
	
	public void handlePopup() {
        // Step 5: Use a try-catch block to handle the exception when the popup is not present
        try {
            // Step 6: Use WebDriverWait to wait for the popup to appear (using ExpectedConditions.visibilityOf)
            WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
            wait.until(ExpectedConditions.visibilityOf(popup));

            // Step 7: Check if the popup is present before interacting with it
            if (popup.isDisplayed()) {
                // Step 8: Click on the close button to dismiss the popup
                popup_accept_all_btn.click();
            }
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // The popup was not found, or it did not appear within the given wait time.
            // You can handle this exception as needed or ignore it.
        }

        // Step 9: You can continue with your test or other actions on the page...
    }

}
