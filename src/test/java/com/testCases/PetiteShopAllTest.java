package com.testCases;

import org.testng.annotations.Test;
import java.io.IOException;
import com.base.BaseClass;
import com.pageObjects.PetiteStudioHomePage;
import com.utilities.JiraCreateIssue;

public class PetiteShopAllTest extends BaseClass {
    PetiteStudioHomePage petitehomepage;

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void ShopAllLinksTest() throws InterruptedException, IOException {
        petitehomepage = new PetiteStudioHomePage(driver);
        
        petitehomepage.hoverOverShopAllLink();

        petitehomepage.verifyShopAllLinks();   
    }

    
    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void HelpLinksTest() throws InterruptedException, IOException {
        petitehomepage = new PetiteStudioHomePage(driver);
        
        petitehomepage.verifyHelpLinks();  
    }
    

}
