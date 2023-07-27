package com.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.HMHomePage;
import com.pageObjects.HMSportPage;
import com.utilities.JiraCreateIssue;import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

public class HandMTest extends BaseClass {

    HMHomePage hmhomepage;
    HMSportPage hmsportpage;

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void verifyRecommendedSortSelectedByDefault() throws InterruptedException, IOException {
        hmhomepage = new HMHomePage(driver);
        hmsportpage = new HMSportPage(driver);

        hmhomepage.acceptCookiesIfDisplayed();
        hmhomepage.hoverOverSportMenu();
        hmhomepage.selectSportsMensViewAll();
        hmsportpage.clickOnSortBy();
        assertTrue(hmsportpage.checkRecommendedSelected(), "Recommended option is not selected as default option");
        
        
        
        
        hmsportpage.clickOnLoadMoreProductsButtonUntilAllShown();
        List<String> initialHref = hmsportpage.getProductHrefLinks();

        hmsportpage.selectLowestPriceOption();
        Thread.sleep(3000);
        hmsportpage.clickOnLoadMoreProductsButtonUntilAllShown();
        List<String> updatedHref = hmsportpage.getProductHrefLinks();

        assertTrue(!initialHref.equals(updatedHref));
        //assertTrue(hmsportpage.verifyHrefChanged(initialHref,updatedHref), "Href have not changed after applying the filter.");

        
        
        hmsportpage.clickOnSortBy();

        hmsportpage.selectRecommendedOption();     
        Thread.sleep(2000);
        hmsportpage.clickOnLoadMoreProductsButtonUntilAllShown();
        List<String> recommendedHref = hmsportpage.getProductHrefLinks();
        assertTrue(initialHref.equals(recommendedHref));
    }
}
