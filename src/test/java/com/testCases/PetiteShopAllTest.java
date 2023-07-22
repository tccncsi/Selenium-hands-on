package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
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
        List<String> hrefs = petitehomepage.getAllAnchorTagsHrefs();

        for (String href : hrefs) {
        	verifyLinkStatus(href);
        }
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void HelpLinksTest() throws InterruptedException, IOException {
        petitehomepage = new PetiteStudioHomePage(driver);
        List<String> helpSectionLinksHrefs = petitehomepage.getAllHelpSectionLinksHrefs();

        for (String href : helpSectionLinksHrefs) {
        	verifyLinkStatus(href);
        }
    }
    
    private void verifyLinkStatus(String href) throws IOException {
        URL url = new URL(href);
        
        //Opens a connection to the URL 
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        
        //similar to GET -> Only requests the headers of the resource without response body
        httpURLConnection.setRequestMethod("HEAD");
        
        //Establishes connection to the URL -> To the server specified in the URL
        httpURLConnection.connect();

        //Retrives the HTTP reponse code from the server -> 200 OK
        int responseCode = httpURLConnection.getResponseCode();
        
        //Closes the connection to the URL -> To release the resources
        httpURLConnection.disconnect();

        System.out.println("Link: " + href + ", Response Code: " + responseCode);

        //HttpURLConnection.HTTP_OK has value <200>
        Assert.assertEquals(responseCode, HttpURLConnection.HTTP_OK, "Link is not working properly: " + href);
    }
}
