package com.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class AmazonRP extends BasePage {

    public AmazonRP(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-hook='see-all-reviews-link-foot']")
    WebElement seeMoreReviews;

    @FindBy(xpath = "//div[@id='cm_cr-review_list']/div[@data-hook='review']")
    List<WebElement> reviews;


    
    public void click_seeMoreReviews() {
        implicitWait();
        seeMoreReviews.click();
    }

    int srno = 0;

    public void getReviewInFormat() {
        // [S.No-Customer|Stars|Main Comment| Summary Comment| Commented date in MM-dd-yyyy format| Other Information like Size & Colors etc..]...
        Iterator<WebElement> reviewIterator = reviews.iterator();
        try (FileWriter writer = new FileWriter("reviews.txt")) {
            while (reviewIterator.hasNext()) {
                srno++;
                WebElement review = reviewIterator.next();
                String stars = review.findElement(By.xpath(".//i[@data-hook='review-star-rating']")).getAttribute("class");
                String mainComment = review.findElement(By.xpath(".//a[@data-hook=\"review-title\"]/span[2]")).getText();
                String summaryComment = review.findElement(By.xpath(".//div[@class=\"a-row a-spacing-small review-data\"]/span")).getText();
                String date = review.findElement(By.xpath(".//span[@data-hook='review-date']")).getText();
                String colour = review.findElement(By.xpath(".//a[@data-hook='format-strip']")).getText();

                if (stars.contains("5") && date.contains("2023")) {
                	
                	String date_format = convertDate(date);
                	
                    String reviewDetails = String.format("%d | 5 Star | %s | %s | %s | %s\n", srno, mainComment, summaryComment, date_format, colour);
                    System.out.print(reviewDetails); 
                    writer.write(reviewDetails);
                }
            }
            System.out.println("Reviews written to reviews.txt successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
