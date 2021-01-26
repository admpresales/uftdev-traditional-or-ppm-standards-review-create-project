package com.mf;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.web.Browser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import com.hp.lft.sdk.web.*;

import unittesting.*;

import java.time.Year;

public class UFTDeveloperTest extends UnitTestClassBase {
Browser browser;
    public UFTDeveloperTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new UFTDeveloperTest();
        globalSetup(UFTDeveloperTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
        browser=BrowserFactory.launch(BrowserType.CHROME);
        browser.clearCache();
        browser.deleteCookies();
    }

    @After
    public void tearDown() throws Exception {
        browser.closeAllTabs();
    }

    @Test
    public void test() throws GeneralLeanFtException {
        int counter;
        browser.navigate("http://nimbusserver.aos.com:8088");
        browser.sync();
        String ThisYear = Year.now().toString();

        Link SignOutLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText(new RegExpProperty("Sign Out.*")).build());
        WebElement MenuUserIconWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .id("menuUserIcon").build());
        Image StrategicPortfolioImage = browser.describe(Image.class, new ImageDescription.Builder()
                .href("http://nimbusserver.aos.com:8088/PFM.300.html")
                .type(com.hp.lft.sdk.web.ImageType.LINK).build());
        StrategicPortfolioImage.click();
        browser.sync();
        Area JonathanKaplanImage = browser.describe(Area.class, new AreaDescription.Builder()
                .href(new RegExpProperty(".*jkaplan.*")).build());
        JonathanKaplanImage.click();
        browser.sync();
        Link SearchLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("SEARCH").build());
        SearchLink.click();
        Link RequestsLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Requests").build());
        RequestsLink.click();
        browser.sync();
        //PFM - Proposal
        EditField RequestTypeEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("REQUEST_TYPE_ID").build());
        RequestTypeEditField.setValue("PFM - Proposal");
        WebElement StatusWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("Status:").build());
        StatusWebElement.click();
        browser.sync();
        EditField StatusEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .title("Status").build());
        StatusEditField.setValue("Standards Review");
        WebElement TopSearchWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Search")
                .index(0).build());
        TopSearchWebElement.click();
        browser.sync();
        Link FirstResultLink = browser.describe(Table.class, new TableDescription.Builder()
                .id("searchResultTable")
                .tagName("TABLE").build())
                .describe(Link.class, new LinkDescription.Builder()
                        .tagName("A")
                        .index(0).build());
        FirstResultLink.click();
        browser.sync();
        WebElement StatusStandardsReviewWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Status: Standards Review ").build());
        counter = 0;
        do {
            counter++;
            if (counter >= 5) {
                try {
                    Reporter.reportEvent("Status Check", "The Standards Review status failed to display within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;

            }
        }
        while (!StatusStandardsReviewWebElement.exists());
        Link ApprovedLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Approved")
                .index(0).build());
        ApprovedLink.click();
        browser.sync();
        WebElement StatusReviewCompleteWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Status: Review Complete ").build());
        counter = 0;
        do {
            counter++;
            if (counter >= 5) {
                try {
                    Reporter.reportEvent("Status Check", "The Review Complete status failed to display within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;

            }
        }
        while (!StatusReviewCompleteWebElement.exists());
        ApprovedLink.click();
        browser.sync();
        WebElement StatusITSCReviewWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Status: ITSC Review ").build());
        counter = 0;
        do {
            counter++;
            if (counter >= 5) {
                try {
                    Reporter.reportEvent("Status Check", "The ITSC Review status failed to display within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;

            }
        }
        while (!StatusITSCReviewWebElement.exists());
        ApprovedLink.click();
        browser.sync();
        EditField ProjectManagerEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .title(new RegExpProperty("Project Manager:.*"))
                .type("text").build());
        counter = 0;
        do {
            counter++;
            if (counter >= 5) {
                try {
                    Reporter.reportEvent("Project Manager Field Check", "The Project Manager: field failed to display within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;

            }
        }
        while (!ProjectManagerEditField.exists());
        counter = 0;
        do {
            counter++;
            ProjectManagerEditField.setValue("Joseph Banks");
            if (counter >= 5){
                try {
                    Reporter.reportEvent("Set Expected Start Period Value","The Expected Start Period value never got set within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;
            }
        }
        while (!ProjectManagerEditField.getValue().equals("Joseph Banks"));

        browser.sync();
        EditField ProjectTypeEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .title(new RegExpProperty("Project Type:.*")).build());
        ProjectTypeEditField.setValue("Standard Project (PPM) - Medium Size");
        browser.sync();
        WebElement ContinueWorkflowActionWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Continue Workflow Action").build());
        ContinueWorkflowActionWebElement.click();
        browser.sync();
        WebElement StatusProjectCreationWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Status: Project Creation ").build());
        counter = 0;
        do {
            counter++;
            browser.sync();
            if (counter >= 5) {
                try {
                    Reporter.reportEvent("Status Check", "The Project Creation status failed to display within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;

            }
        }
        while (!StatusProjectCreationWebElement.exists());
        Link ExecuteNowLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Execute Now").build());
        ExecuteNowLink.click();
        browser.sync();
        WebElement StatusClosedApprovedWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Status: Closed (Approved) ").build());
        do {
            counter++;
            browser.sync();
            if (counter >= 5) {
                try {
                    Reporter.reportEvent("Status Check", "The Closed (Approved) status failed to display within " + counter + " attempts, aborting run", Status.Failed);
                } catch (ReportException e) {
                    e.printStackTrace();
                }
                MenuUserIconWebElement.click();
                SignOutLink.click();
                browser.sync();
                return;

            }
        }
        while (!StatusClosedApprovedWebElement.exists());
        MenuUserIconWebElement.click();
        SignOutLink.click();
        browser.sync();

    }

}