package implementation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import reUsableMethods.BaseClass;

public class PNB_AutoLoan_Implementation extends BaseClass {
	public static String propertyfile = "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\resources\\Properties\\PNB_AutoLoan_Lead.properties";
	public static String propertyfileDE = "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\resources\\Properties\\PNB_AutoLoan_DataEncoding.properties";
	public static String WIpropertyfile = "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\resources\\Properties\\WorkItemNumber.properties";
	public static String propertyfilePE = "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\resources\\Properties\\PNB_AL_PreEvaluation.properties";
	public static String propertyfileCE = "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\resources\\Properties\\PNB_AL_CreditEvaluation.properties";
	public static String propertyfileCI = "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\resources\\Properties\\PNB_AL_Credit_Investigation.properties";
	public static String propertyfileCA = "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\resources\\Properties\\PNB_AL_CustomerAcceptance.properties";
	public static String propertyfileCCR = "C:\\Users\\tlingeshwaran\\Downloads\\PNB_AutoLoan\\PNB_AutoLoan\\src\\test\\resources\\Properties\\PNB_AL_CreditControlReview.properties";

	public static void userLaunchBrowser() {
		String url = getProperty("url", propertyfile);
		launchEdge(url);
		doWindowMaximize();
	}

	public static void userEnterCredentials() {
		String username = getProperty("usernamexpath", propertyfile);
		doSendKeys(username, "usrlosqa5");
		String password = getProperty("passwordxpath", propertyfile);
		doSendKeys(password, "user123#");
		String cabinet = getProperty("cabinetxpath", propertyfile);
		doDropDownSelectByVisibleText(cabinet, "pnbrlosqa");
	}

	public static void clickloginButton() throws InterruptedException {
		String loginButton = getProperty("loginbuttonxpath", propertyfile);
		doClick(loginButton);
		Thread.sleep(2000);

		String pagetitle = driver.getTitle();

		if (pagetitle.equalsIgnoreCase("OmniApp | Main")) {

			System.out.println("login successfully");

		} else {

			System.out.println("User already Login");

			driver.findElement(By.id("oaloginform:contloginbtn")).click();

		}
	}

	public static void selectProcess() {
		doImplicitWait(10);
		WebElement element = driver.findElement(By.xpath("//iframe[@id='iframe_Int10']"));
		driver.switchTo().frame(element);
		String processButton = getProperty("processbutton", propertyfile);
		doClick(processButton);
		doSwitchToDefault();
		doThreadSleep(2);
		doFrameSwitchByNameId("popupIFrame_ProcessPickList");
		String LOS = getProperty("LOS", propertyfile);
		doThreadSleep(2);
		doClick(LOS);
		doSwitchToDefault();
	}

	public static void searchQueue() throws AWTException, Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("iframe_Int10");
		String searchLOSLead = getProperty("searchLOSLead", propertyfile);
		doClick(searchLOSLead);
		Thread.sleep(5000);
		doClear(searchLOSLead);
		Thread.sleep(5000);
		doSendKeys(searchLOSLead, "LOS_Lead");
		doSwitchToDefault();
	}

	public static void selectQueue() throws AWTException, Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("iframe_Int10");
		String LOSLead = getProperty("clickLOSLead", propertyfile);
		fluentWaitByXpath(LOSLead);
		Thread.sleep(5000);
		doClick(LOSLead);
		doSwitchToDefault();
	}

	public static void searchAndSelectQueue() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("iframe_Int11");
		String searchBox = getProperty("searchboxqueue", propertyfile);
		Thread.sleep(15000);
		doClick(searchBox);
		Thread.sleep(15000);
		doClear(searchBox);
		Thread.sleep(5000);
		doSendKeys(searchBox, "LOS_LEAD");
		Thread.sleep(2000);
		// doSingleClick(KeyEvent.VK_ENTER);
		String queuesearchbutton = getProperty("queuesearchbutton", propertyfile);
		Thread.sleep(3000);
		doClick(queuesearchbutton);
		String queue = getProperty("clickQueue", propertyfile);
		Thread.sleep(5000);
		doClick(queue);
		doSwitchToDefault();
	}

	public static void selectNewButton() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("iframe_Int42");
		String newButton = getProperty("newbutton", propertyfile);
		fluentWaitByXpath(newButton);
		doClick(newButton);
		doSwitchToDefault();
		Thread.sleep(5000);
		doWebHandle(1);
		// System.out.println("done");
	}

	public static void loanDetails() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String LoanDetailsPlus = getProperty("loandetailsplus", propertyfile);
		doClick(LoanDetailsPlus);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String LoanProduct = getProperty("loanproduct", propertyfile);
		doDropDownSelectByVisibleText(LoanProduct, "AUTO LOAN");
		Thread.sleep(5000);
		String LoanSubProduct = getProperty("loansubproduct", propertyfile);
		doDropDownSelectByVisibleText(LoanSubProduct, "AL NEW");
		String LoanPurpose = getProperty("loanpurpose", propertyfile);
		doDropDownSelectByVisibleText(LoanPurpose, "PERSONAL");
		doSwitchToDefault();
	}

	public static void selectLoanTerm() throws InterruptedException, AWTException {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String loanTerm = getProperty("loanTerm", propertyfile);
		doClick(loanTerm);
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		doSwitchToDefault();

		doFrameSwitchByNameId("ngformIframe");
		String AppliedAmount = getProperty("appliedamount", propertyfile);
		doClick(AppliedAmount);
		Thread.sleep(5000);
		doSendKeys(AppliedAmount, "1300000");
		String SaveandClose1 = getProperty("saveandclose", propertyfile);
		doClick(SaveandClose1);
		doSwitchToDefault();
	}

	public static void partyDetails() throws InterruptedException {

		doFrameSwitchByNameId("ngformIframe");
		String PDaddButton = getProperty("partyDetailsAddButton", propertyfile);
		doClick(PDaddButton);
		String partyType = getProperty("PDPartyType", propertyfile);
		doDropDownSelectByVisibleText(partyType, "BORROWER");
		String firstName = getProperty("PDFirstName", propertyfile);
		doClickAndSendKeys(firstName, "NEW");
		String middleName = getProperty("PDMiddleName", propertyfile);
		doClickAndSendKeys(middleName, "G");
		String lastName = getProperty("PDLastName", propertyfile);
		doClickAndSendKeys(lastName, "EN");
		String Suffix = getProperty("Suffix", propertyfile);
		doClickAndSendKeys(Suffix, "MR");
		String DOB = getProperty("PDDOB", propertyfile);
		doClickAndSendKeys(DOB, "09/09/1990");
		String placeOfBirth = getProperty("PDPlaceOfBirth", propertyfile);
		doClickAndSendKeys(placeOfBirth, "phpppp");
		String gender = getProperty("PDGender", propertyfile);
		doDropDownSelectByVisibleText(gender, "MALE");
		String maritalStatus = getProperty("PDMaritalStatus", propertyfile);
		doDropDownSelectByVisibleText(maritalStatus, "SINGLE");
		String NoOfDependents = getProperty("NoOfDependents", propertyfile);
		doClickAndSendKeys(NoOfDependents, "1");
		String SourceOfIncome = getProperty("PDSourceOfIncome", propertyfile);
		doDropDownSelectByVisibleText(SourceOfIncome, "EMPLOYEDPROFESSIONALPENSIONERREMITTANCE");
		doSwitchToDefault();
	}

	public static void partyDetails_AddressDetails() throws Exception {
		doFrameSwitchByNameId("ngformIframe");
		String addButton = getProperty("PDAdrressButtonAddButton", propertyfile);
		doClick(addButton);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String addressType = getProperty("PDAdressType", propertyfile);
		doDropDownSelectByVisibleText(addressType, "PERMANENT");
		String sameAsPresent = getProperty("PDAddSameAsPresent", propertyfile);
		doDropDownSelectByVisibleText(sameAsPresent, "YES");
		String address = getProperty("PDAddress_Area", propertyfile);
		doClickAndSendKeys(address, "sdfghdxcvbnjhfdcvbh");

		String province = getProperty("PDProvince", propertyfile);
		doClick(province);
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String city = getProperty("PDCity", propertyfile);
		doClick(city);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String barangay = getProperty("PDBarangay", propertyfile);
		doClick(barangay);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String saveButton = getProperty("PDAddrSave", propertyfile);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void PartyDetails_ContactDetails() {
		doFrameSwitchByNameId("ngformIframe");
		String Pd_Cd_AddButton = getProperty("PDCDAddButton", propertyfile);
		doClick(Pd_Cd_AddButton);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String PdCdMobileNumber = getProperty("PdCdMobileNumber", propertyfile);
		doClickAndSendKeys(PdCdMobileNumber, "123456789");
		String PdCdEmail = getProperty("PdCdEmail", propertyfile);
		doClickAndSendKeys(PdCdEmail, "gsfgsf@gmail.com");
		String saveButton = getProperty("PdCdSaveButton", propertyfile);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void PartyDetails_EmployementDetails() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String addButton = getProperty("PdEdAddButton", propertyfile);
		doClick(addButton);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		Thread.sleep(3000);
		String employerType = getProperty("PdEdEmployerType", propertyfile);
		doDropDownSelectByVisibleText(employerType, "GOVERNMENT");
		String employerName = getProperty("PdEdEmployerName", propertyfile);
		doClickAndSendKeys(employerName, "ugfdugfu");
		String natureOfEmployement = getProperty("PdEdNatureOfEmployement", propertyfile);
		doDropDownSelectByVisibleText(natureOfEmployement, "PROFESSIONAL, SCIENTIFIC AND TECHNICAL ACTIVITIES");
		String employementType = getProperty("PdEdEmplyementType", propertyfile);
		doDropDownSelectByVisibleText(employementType, "LOCALLY EMPLOYED - GOVERNMENT");
		String employmentStatus = getProperty("PdEdEmploymentStatus", propertyfile);
		doDropDownSelectByVisibleText(employmentStatus, "REGULAR");
		String position = getProperty("PdEdPosition", propertyfile);
		doDropDownSelectByVisibleText(position, "MIDDLE OFFICER");
		String tenureInyears = getProperty("PdEdTenureInYears", propertyfile);
		doClickAndSendKeys(tenureInyears, "3");
		String basicSalary = getProperty("PdEdBasicSalary", propertyfile);
		doClickAndSendKeys(basicSalary, "123456");
		doSwitchToDefault();
	}

	public static void employerAddress() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String address = getProperty("PdEdHouseUnit", propertyfile);
		doClickAndSendKeys(address, "erfrefdfcrfd");
		String EmpProvince = getProperty("PdEdEmpProvince", propertyfile);
		dropDownSelectInInputTag(EmpProvince, 3);
		Thread.sleep(5000);
		String EmpCity = getProperty("PdEdEmpCity", propertyfile);
		doClick(EmpCity);
		Robot r = new Robot();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String EmpBarangay = getProperty("PdEdBarangay", propertyfile);
		doClick(EmpBarangay);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String save = getProperty("PdEdSaveButton", propertyfile);
		doClick(save);
		String saveButton = getProperty("PdSaveButton2", propertyfile);
		doClick(saveButton);
		doSwitchToDefault();
		Thread.sleep(5000);
		doFrameSwitchByNameId("ngformIframe");
		String PNBdepositaccount = getProperty("PNBdepositaccount", propertyfile);
		Thread.sleep(5000);
		doClick(PNBdepositaccount);
		doSwitchToDefault();

	}

	public static void collateralDetails() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		Thread.sleep(5000);
		String collateralTab = getProperty("collateralTab", propertyfile);
		doClick(collateralTab);
		Thread.sleep(5000);
		String addButton = getProperty("collateralAddButton", propertyfile);
		doClick(addButton);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String vehicleType = getProperty("vehicleType", propertyfile);
		doDropDownSelectByVisibleText(vehicleType, "NEW");
		String brand = getProperty("brand", propertyfile);
		doClick(brand);
		Robot r = new Robot();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String model = getProperty("model", propertyfile);
		doClick(model);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String saveButton = getProperty("CollateralSaveButton", propertyfile);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void sourcingInfo() throws AWTException, InterruptedException {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String RelationshipOfficer = getProperty("relationshipofficer", propertyfile);
		Thread.sleep(5000);
		doClick(RelationshipOfficer);
		Thread.sleep(2000);
		doSingleClick(KeyEvent.VK_ENTER);
		String RelationshipOfficerOK = getProperty("relationshipOK", propertyfile);
		doClick(RelationshipOfficerOK);
		String EntityType = getProperty("entitytype", propertyfile);
		doDropDownSelectByVisibleText(EntityType, "INDIVIDUAL");
		String TypeOfApplication = getProperty("typeofapplication", propertyfile);
		doDropDownSelectByVisibleText(TypeOfApplication, "NEW");
	}

	public static void riskDetails1() throws Exception {
		doWebhandles(1);
		doFrameSwitchByNameId("ngformIframe");
		String CRRRiskTab = getProperty("RiskTab", propertyfile);
		doClick(CRRRiskTab);
		Thread.sleep(3000);
		String CRRaddButton = getProperty("CRRPlusbutton", propertyfile);
		doClick(CRRaddButton);
		doSwitchToDefault();
		Thread.sleep(3000);
		doFrameSwitchByNameId("ngformIframe");
		String CRRPartyType = getProperty("CRRPartyType", propertyfile);
		Thread.sleep(3000);
		doDropDownSelectByIndex(CRRPartyType, 1);
		Thread.sleep(3000);
		String CRROccupation = getProperty("CRROccupation", propertyfile);
		doClick(CRROccupation);
		Thread.sleep(3000);
		String CRRPicklistOK = getProperty("CRRPicklistOK", propertyfile);
		Thread.sleep(3000);
		doClick(CRRPicklistOK);
		String CRRSourceofFunds = getProperty("CRRSourceofFunds", propertyfile);
		doClick(CRRSourceofFunds);
		Thread.sleep(3000);
		doClick(CRRPicklistOK);
		String CRRMTV = getProperty("CRRMTV", propertyfile);
		doClick(CRRMTV);
		Thread.sleep(3000);
		doClick(CRRPicklistOK);
		String CRRDeposit = getProperty("CRRDeposit", propertyfile);
		doClick(CRRDeposit);
		Thread.sleep(3000);
		doClick(CRRPicklistOK);
		String CRRGMTV = getProperty("CRRGMTV", propertyfile);
		doClick(CRRGMTV);
		Thread.sleep(3000);
		doClick(CRRPicklistOK);
		String CRRRelationship = getProperty("CRRRelationship", propertyfile);
		doClick(CRRRelationship);
		Thread.sleep(3000);
		doClick(CRRPicklistOK);
		String CRRCitizenship = getProperty("CRRCitizenship", propertyfile);
		doClick(CRRCitizenship);
		Thread.sleep(3000);
		doClick(CRRPicklistOK);
		doSwitchToDefault();
	}

	public static void riskDetails2() throws Exception {
		doFrameSwitchByNameId("ngformIframe");
		String CRRCheckdeposit = getProperty("CRRCheckdeposit", propertyfile);
		doClick(CRRCheckdeposit);
		Thread.sleep(3000);
		String CRRPurchase = getProperty("CRRPurchase", propertyfile);
		doClick(CRRPurchase);
		Thread.sleep(3000);
		String CRRLoans = getProperty("CRRLoans", propertyfile);
		doClick(CRRLoans);
		Thread.sleep(3000);
		String CRRTrustUITF = getProperty("CRRTrustUITF", propertyfile);
		doClick(CRRTrustUITF);
		Thread.sleep(3000);
		String CRRCreditcard = getProperty("CRRCreditcard", propertyfile);
		doClick(CRRCreditcard);
		Thread.sleep(3000);
		String CRRInternet = getProperty("CRRInternet", propertyfile);
		doClick(CRRInternet);
		Thread.sleep(3000);
		String CRRCashCard = getProperty("CRRCashCard", propertyfile);
		doClick(CRRCashCard);
		Thread.sleep(3000);
		String CRRFundtransfer = getProperty("CRRFundtransfer", propertyfile);
		doClick(CRRFundtransfer);
		Thread.sleep(3000);
		String CRRInterbranch = getProperty("CRRInterbranch", propertyfile);
		doClick(CRRInterbranch);
		Thread.sleep(3000);
		String CRRDollarsavingsacc = getProperty("CRRDollarsavingsacc", propertyfile);
		doClick(CRRDollarsavingsacc);
		Thread.sleep(3000);
		String CRRForeignremittance = getProperty("CRRForeignremittance", propertyfile);
		doClick(CRRForeignremittance);
		Thread.sleep(3000);
		String CRRTreasury = getProperty("CRRTreasury", propertyfile);
		doClick(CRRTreasury);
		Thread.sleep(3000);
		String CRRForeignexchange = getProperty("CRRForeignexchange", propertyfile);
		doClick(CRRForeignexchange);
		Thread.sleep(3000);
		String CRRSafetyDepositBox = getProperty("CRRSafetyDepositBox", propertyfile);
		doClick(CRRSafetyDepositBox);
		Thread.sleep(3000);
		String CRRTradeFinance = getProperty("CRRTradeFinance", propertyfile);
		doClick(CRRTradeFinance);
		Thread.sleep(3000);
		String CRRCASA = getProperty("CRRCASA", propertyfile);
		doClick(CRRCASA);
		Thread.sleep(3000);
		String saveButton = getProperty("CRRSaveButton", propertyfile);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void actionDetails() throws Exception {
		doFrameSwitchByNameId("ngformIframe");
		String ActionTab = getProperty("ActionTab", propertyfile);
		doClick(ActionTab);
		Thread.sleep(5000);
		String Decision = getProperty("Decision", propertyfile);
		doDropDownSelectByVisibleText(Decision, "Submit");
		Thread.sleep(5000);
		String DecisionRemarks = getProperty("DecisionRemarks", propertyfile);
		doClickAndSendKeys(DecisionRemarks, "All are Looks Good");
		Thread.sleep(5000);
		String DecisionSubmitBTN = getProperty("DecisionSubmitBTN", propertyfile);
		doClick(DecisionSubmitBTN);
		doSwitchToDefault();
		Thread.sleep(5000);
		String Workitem = getProperty("Workitem", propertyfile);
		String LN = getText(Workitem);
		String[] refWI = LN.split("-");
		String Loannumber = refWI[1];
		System.out.println(Loannumber);
		setProperty(WIpropertyfile, "LoanRefNumber", Loannumber, "this is Work Item Number");
		doFrameSwitchByNameId("popupIFrame_confirmdone");
		String yesButton = getProperty("LeadYesButton", propertyfile);
		Thread.sleep(2000);
		doClick(yesButton);
		doSwitchToDefault();
	}

	public static void documentUpload() throws Exception {

		doFrameSwitchByNameId("ngformIframe");
		String documentTab = getProperty("documentTab", propertyfile);
		doClick(documentTab);
		String partyType = getProperty("documentPartyType", propertyfile);
		doDropDownSelectByIndex(partyType, 1);
		Thread.sleep(3000);
		String checkBox = getProperty("mandatoryCheckBox", propertyfile);
		doClick(checkBox);
		Thread.sleep(3000);
		String DOCphotocopyuploadbutton = getProperty("DOCphotocopyuploadbutton", propertyfile);
		doClick(DOCphotocopyuploadbutton);
		doSwitchToDefault();
		Thread.sleep(3000);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfile);
		Thread.sleep(3000);
		doClick(uploadfromcomputer);
		Thread.sleep(3000);
		documentUploadfromSystem("C:\\Users\\prathap.e\\Desktop\\IMG_20230819_141612.jpg");
		String uploadbutton = getProperty("uploadbutton", propertyfile);
		Thread.sleep(3000);
		doClick(uploadbutton);

	}

	public static void documentUploadDealer() throws Exception {
		Thread.sleep(3000);
		doWebHandle(1);
		doFrameSwitchByNameId("ngformIframe");
		String DOCdealerquotationloadbutton = getProperty("DOCdealerquotationloadbutton", propertyfile);
		doClick(DOCdealerquotationloadbutton);
		doSwitchToDefault();
		Thread.sleep(3000);
		doWebhandles(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfile);
		doClick(uploadfromcomputer);
		Thread.sleep(3000);
		documentUploadfromSystem("C:\\Users\\prathap.e\\Desktop\\IMG_20230819_141612.jpg");
		String dealersQuotation = getProperty("documentType", propertyfile);
		doDropDownSelectByVisibleText(dealersQuotation, "Dealers Quotation");
		Thread.sleep(2000);
		String uploadbutton = getProperty("uploadbutton", propertyfile);
		Thread.sleep(3000);
		doClick(uploadbutton);
		Thread.sleep(3000);
	}

	public static void documentUploadACR() throws Exception {
		doWebhandles(0);
		Thread.sleep(3000);
		doWebhandles(1);
		doFrameSwitchByNameId("ngformIframe");
		String DOCACRloadbutton = getProperty("DOCACRloadbutton", propertyfile);
		doClick(DOCACRloadbutton);
		doSwitchToDefault();
		Thread.sleep(3000);
		doWebhandles(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfile);
		doClick(uploadfromcomputer);
		Thread.sleep(3000);
		documentUploadfromSystem("C:\\Users\\prathap.e\\Desktop\\IMG_20230819_141612.jpg");
		String ACR = getProperty("documentType", propertyfile);
		doDropDownSelectByVisibleText(ACR, "Alien Certificate of Registration");
		String uploadbutton = getProperty("uploadbutton", propertyfile);
		Thread.sleep(3000);
		doClick(uploadbutton);
	}

	public static void documentUploadLatestBiling() throws Exception {
		Thread.sleep(3000);
		doWebhandles(1);
		doFrameSwitchByNameId("ngformIframe");
		String DOClatestbilingloadbutton = getProperty("DOClatestbilingloadbutton", propertyfile);
		doClick(DOClatestbilingloadbutton);
		doSwitchToDefault();
		Thread.sleep(3000);
		doWebhandles(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfile);
		doClick(uploadfromcomputer);
		Thread.sleep(3000);
		documentUploadfromSystem("C:\\Users\\prathap.e\\Desktop\\IMG_20230819_141612.jpg");
		String LatestBilling = getProperty("documentType", propertyfile);
		doDropDownSelectByVisibleText(LatestBilling, "Latest Biling Statement");
		String uploadbutton = getProperty("uploadbutton", propertyfile);
		Thread.sleep(3000);
		doClick(uploadbutton);
		doSwitchToDefault();
	}

// data encoding Stage

	public static void searchandselectWorkItem() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("iframe_Int3002");
		String process = getProperty("Process", propertyfileDE);
		doDropDownSelectByVisibleText(process, "LOS");
		String searchBox = getProperty("searchBox", propertyfileDE);
		doClick(searchBox);
		Thread.sleep(2000);
		doClear(searchBox);
		Thread.sleep(2000);
		String workItem = getProperty("LoanRefNumber", WIpropertyfile);
		doSendKeys(searchBox, workItem);
		Thread.sleep(5000);
		String searchWorkItem = getProperty("searchWorkItem", propertyfileDE);
		doClick(searchWorkItem);
		doSwitchToDefault();
		doFrameSwitchByNameId("iframe_Int42");
		String dataEncoding = getProperty("dataencoding", propertyfileDE);
		Thread.sleep(3000);
		doClick(dataEncoding);
		doSwitchToDefault();
		Thread.sleep(2000);
		doWebhandles(1);
	}

	public static void applicationInfo() {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String employeeRefNumber = getProperty("EmployeeReferrerNumber", propertyfileDE);
		doClick(employeeRefNumber);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String okButton = getProperty("EmployeeReferrerNumberOK", propertyfileDE);
		doClick(okButton);
		doSwitchToDefault();
	}

	public static void productDetails() {

		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String productDetails = getProperty("ProductEnter", propertyfileDE);
		doClick(productDetails);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String program = getProperty("SelectProgram", propertyfileDE);
		doDropDownSelectByVisibleText(program, "");
		String broker = getProperty("BrokerSelect", propertyfileDE);
		// broker in input
		String brokerIncentive = getProperty("BrokerIncentive", propertyfileDE);
		doSendKeys(brokerIncentive, "12");
		String LTG = getProperty("LTGYes", propertyfileDE);
		doClick(LTG);
		String hcgCovered = getProperty("HGCQualifiedYes", propertyfileDE);
		doClick(hcgCovered);
		String saveButton = getProperty("ProductDeatialsSaveChanges", propertyfileDE);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void dataEncoding_PartyDetails() {

		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String partyDetails = getProperty("PartyEnter", propertyfileDE);
		doClick(partyDetails);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String dedupe = getProperty("PartyDedupe", propertyfileDE);
		doClick(dedupe);
		doClick(partyDetails);
	}

	public static void partyDetails_AddressDetails_DataEncoding() {

		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String addressTab = getProperty("PartyAddressDetails", propertyfileDE);
		doClick(addressTab);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String lengthOfStayInMonths = getProperty("PartyAddressLengthStayMonths", propertyfileDE);
		doSendKeys(lengthOfStayInMonths, "4");
		String lengthOfStayInYears = getProperty("PartyAddressLengthStayYears", propertyfileDE);
		doSendKeys(lengthOfStayInYears, "10");
		String homeOwnership = getProperty("SelectHomeOwnership", propertyfileDE);
		doDropDownSelectByValue(homeOwnership, "");
		String saveButton = getProperty("PartyAddrressSave", propertyfileDE);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void Id() {

		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String addButton = getProperty("PartyIdsAdd", propertyfileDE);
		doClick(addButton);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String idType = getProperty("PartyIDtype", propertyfileDE);
		doDropDownSelectByValue(idType, "");
		String idNumber = getProperty("PartyIDnumber", propertyfileDE);
		doSendKeys(idNumber, "12345");
		String idExpiryDate = getProperty("PartyIDexpiryDate", propertyfileDE);
		doSendKeys(idExpiryDate, "02/02/2030");
		String saveButton = getProperty("PartyIDSaveandClose", propertyfileDE);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void partyDetails_EmployementAddress() {

		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String empAddressTab = getProperty("", propertyfileDE);
		doClick(empAddressTab);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String otherIncome = getProperty("PartyEmploymentOtherIncome", propertyfileDE);
		doSendKeys(otherIncome, "120000");
		String employerAddress = getProperty("PartyEmployerEmailAddress", propertyfileDE);
		doSendKeys(employerAddress, "newgen@newgensoft.com");
		String saveButton = getProperty("PartyEmploymentSaveChanges", propertyfileDE);
		doClick(saveButton);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String saveButton2 = getProperty("PartySaveChanges", propertyfileDE);
		doClick(saveButton2);
	}

	public static void collateraldetails() throws Exception {

		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String collateralTab = getProperty("CollateralTab", propertyfileDE);
		doClear(collateralTab);
		Thread.sleep(2000);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String addCollateralDetails = getProperty("addCollateralDetails", propertyfileDE);
		doClick(addCollateralDetails);
		String dealersName = getProperty("dealersName", propertyfileDE);
		doDropDownSelectByIndex(dealersName, 1);
		Thread.sleep(3000);
		String saveButton = getProperty("collateralSaveButtonDE", propertyfileDE);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void bureauCheck() throws Exception {

		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String bureauCheckTab = getProperty("bureauCheckTab", propertyfileDE);
		doClick(bureauCheckTab);
		Thread.sleep(2000);
		String fetchButton = getProperty("fetchButton", propertyfileDE);
		doClick(fetchButton);
		Thread.sleep(5000);
		doSwitchToDefault();
	}

	public static void action() throws Exception {

		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String actionTab = getProperty("actionTab", propertyfileDE);
		doClick(actionTab);
		Thread.sleep(2000);
		String decision = getProperty("decision", propertyfileDE);
		doDropDownSelectByVisibleText(decision, "Submit");
		Thread.sleep(3000);
		String remarks = getProperty("remarks", propertyfileDE);
		doClick(remarks);
		doSendKeys(remarks, "ok");
		String submitButton = getProperty("actionSubmitButton", propertyfileDE);
		doClick(submitButton);
		doSwitchToDefault();
	}

	// PreEvaluation_Stage

	public static void actionTab_PreEvaluation() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String actionClick = getProperty("actionTab", propertyfilePE);
		doClick(actionClick);
		String decision = getProperty("decision", propertyfilePE);
		doDropDownSelectByVisibleText(decision, "Submit");
		Thread.sleep(3000);
		String remarks = getProperty("remarks", propertyfilePE);
		doSendKeys(remarks, "ok");
		String submit = getProperty("submit", propertyfilePE);
		doClick(submit);
		doSwitchToDefault();
		Thread.sleep(5000);
		doFrameSwitchByNameId("popupIFrame_confirmdone");
		String okButton = getProperty("okButton", propertyfilePE);
		doClick(okButton);
	}

	// Credit_Investigation
	public static void TeleInfo() {
		doImplicitWait(10);
		String ExpandLayout = getProperty("expandlayout", propertyfileCE);
		doClick(ExpandLayout);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(4);
		String teleClick = getProperty("teleclick", propertyfileCE);
		doClick(teleClick);
		doImplicitWait(10);
		String teleFiTableClick = getProperty("telefitableclick", propertyfileCE);
		doThreadSleep(5);
		doClick(teleFiTableClick);
		doSwitchToDefault();
		doThreadSleep(5);
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(5);
		System.out.println("Done2");
		String addButtonClick = getProperty("callattemptbuttonpress", propertyfileCE);
		doClick(addButtonClick);
		doSwitchToDefault();
		doThreadSleep(5);
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(4);
		System.out.println("Done3");
		String verificationType = getProperty("verificationdropdown", propertyfileCE);
		doDropDownSelectByVisibleText(verificationType, "PERSONAL VERIFICATION");
		doThreadSleep(3);
		String numberContacted = getProperty("numbercontacted", propertyfileCE);
		doSendKeys(numberContacted, "12345678");
		doThreadSleep(3);
		String googleListed = getProperty("googlelisted", propertyfileCE);
		doDropDownSelectByVisibleText(googleListed, "YES");
		doThreadSleep(3);
		String informantName = getProperty("informantname", propertyfileCE);
		doSendKeys(informantName, "Siddhesh");
		doThreadSleep(3);
		String informantdesignation = getProperty("informantdesignation", propertyfileCE);
		doSendKeys(informantdesignation, "B.E");
		doThreadSleep(3);
		String saveAndclose = getProperty("saveandclose", propertyfileCE);
		doClick(saveAndclose);
		doThreadSleep(3);
		System.out.println("Done4");
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(3);
		System.out.println("Done5");
		String verified = getProperty("verified", propertyfileCE);
		doClick(verified);
		doThreadSleep(3);
		String SaveChanges = getProperty("savechanges", propertyfileCE);
		doClick(SaveChanges);
		doThreadSleep(2);
		doSwitchToDefault();
		doThreadSleep(2);
		System.out.println("Done6");
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(2);
		System.out.println("Done7");
		String SendEmail = getProperty("sendemail", propertyfileCE);
		doClick(SendEmail);
		doThreadSleep(3);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(3);
		String okButton = getProperty("okbutton", propertyfileCE);
		doClick(okButton);
	}

	public static void fieldCI() {
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(3);
		String fieldCI = getProperty("fieldci", propertyfileCE);
		doClick(fieldCI);
		doSwitchToDefault();

	}

	public static void documentUploadCreditCheck() throws Exception {
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(3);
		String Document = getProperty("document", propertyfileCE);
		doClick(Document);
		System.out.println("DONE8");
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(3);
		String Showmandatory = getProperty("showmandatory", propertyfileCE);
		doClick(Showmandatory);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(3);
		String Mandoc = getProperty("mandoc", propertyfileCE);
		doClick(Mandoc);
		doSwitchToDefault();
		Thread.sleep(3000);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfile);
		Thread.sleep(3000);
		doClick(uploadfromcomputer);
		Thread.sleep(3000);
		documentUploadfromSystem("C:\\Users\\ssasikumar\\Desktop\\July 31_ autobill_231.pdf");
		String uploadbutton = getProperty("uploadbutton", propertyfile);
		Thread.sleep(3000);
		doClick(uploadbutton);
	}

	public static void documentPNBloandDelings() throws Exception {
		doThreadSleep(3);
		doWebhandles(1);
		doFrameSwitchByNameId("ngformIframe");
		String PNBLoanDealings = getProperty("pnbloansavings", propertyfileCE);
		doClick(PNBLoanDealings);
		doSwitchToDefault();
		doThreadSleep(3);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfileCE);
		doClick(uploadfromcomputer);
		doThreadSleep(3);
		documentUploadfromSystem("C:\\Users\\ssasikumar\\Desktop\\July 31_ autobill_231.pdf");
		String xpnbLoandeals = getProperty("xpnbloandetails", propertyfileCE);
		doDropDownSelectByVisibleText(xpnbLoandeals, "PNB Loan Dealings");
		String uploadbutton = getProperty("uploadbutton", propertyfileCE);
		doThreadSleep(3);
		doClick(uploadbutton);
		System.out.println("Doc2");
	}

	public static void documentResidenceVerif() throws Exception {
		doThreadSleep(3);
		doWebhandles(1);
		doThreadSleep(3);
		doFrameSwitchByNameId("ngformIframe");
		String residenceVerify = getProperty("residenceverificationreport", propertyfileCE);
		doClick(residenceVerify);
		doSwitchToDefault();
		doThreadSleep(3);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfileCE);
		doClick(uploadfromcomputer);
		doThreadSleep(3);
		documentUploadfromSystem("C:\\Users\\ssasikumar\\Desktop\\July 31_ autobill_231.pdf");
		String xpnbLoandeals = getProperty("xpnbloandetails", propertyfileCE);
		doDropDownSelectByVisibleText(xpnbLoandeals, "Residence Verification Report");
		String uploadbutton = getProperty("uploadbutton", propertyfileCE);
		doThreadSleep(3);
		doClick(uploadbutton);
	}

	public static void documentEmporBusiverify() throws Exception {
		doThreadSleep(3);
		doWebhandles(1);
		doThreadSleep(3);
		doFrameSwitchByNameId("ngformIframe");
		String empResidence = getProperty("emplyomentorbusinessverification", propertyfileCE);
		doClick(empResidence);
		doSwitchToDefault();
		doThreadSleep(3);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfileCE);
		doClick(uploadfromcomputer);
		doThreadSleep(3);
		documentUploadfromSystem("C:\\Users\\ssasikumar\\Desktop\\July 31_ autobill_231.pdf");
		String xpnbLoandeals = getProperty("xpnbloandetails", propertyfileCE);
		doDropDownSelectByVisibleText(xpnbLoandeals, "Employment or Business Verification");
		String uploadbutton = getProperty("uploadbutton", propertyfileCE);
		doThreadSleep(3);
		doClick(uploadbutton);
	}

	public static void documentPvcid() throws Exception {
		doThreadSleep(3);
		doWebhandles(1);
		doThreadSleep(3);
		doFrameSwitchByNameId("ngformIframe");
		String pvcid = getProperty("pvcidverification", propertyfileCE);
		doClick(pvcid);
		doSwitchToDefault();
		doThreadSleep(3);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfileCE);
		doClick(uploadfromcomputer);
		doThreadSleep(3);
		documentUploadfromSystem("C:\\Users\\ssasikumar\\Desktop\\July 31_ autobill_231.pdf");
		String xpnbLoandeals = getProperty("xpnbloandetails", propertyfileCE);
		doDropDownSelectByVisibleText(xpnbLoandeals, "PVCID verification SEC Registration Certificate");
		String uploadbutton = getProperty("uploadbutton", propertyfileCE);
		doThreadSleep(3);
		doClick(uploadbutton);
	}

	public static void PvcidGis() throws Exception {
		doSwitchToDefault();
		doThreadSleep(3);
		doWebhandles(1);
		doThreadSleep(3);
		doFrameSwitchByNameId("ngformIframe");
		String pvcidgis = getProperty("pvcidgis", propertyfileCE);
		doClick(pvcidgis);
		doSwitchToDefault();
		doThreadSleep(3);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfileCE);
		doClick(uploadfromcomputer);
		doThreadSleep(3);
		documentUploadfromSystem("C:\\Users\\ssasikumar\\Desktop\\July 31_ autobill_231.pdf");
		String xpnbLoandeals = getProperty("xpnbloandetails", propertyfileCE);
		doDropDownSelectByVisibleText(xpnbLoandeals, "PVCID verification of latest GIS");
		String uploadbutton = getProperty("uploadbutton", propertyfileCE);
		doThreadSleep(3);
		doClick(uploadbutton);
		System.out.println("Doc6");
	}

	public static void tradeRefer() throws Exception {
		doSwitchToDefault();
		doThreadSleep(3);
		doWebhandles(1);
		doThreadSleep(3);
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(5);
		String traderefer = getProperty("tradeverificationreport", propertyfileCE);
		doClick(traderefer);
		doSwitchToDefault();
		doThreadSleep(3);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfileCE);
		doClick(uploadfromcomputer);
		doThreadSleep(3);
		documentUploadfromSystem("C:\\Users\\ssasikumar\\Desktop\\July 31_ autobill_231.pdf");
		String xpnbLoandeals = getProperty("xpnbloandetails", propertyfileCE);
		doDropDownSelectByVisibleText(xpnbLoandeals, "Trade References Verification Report");
		String uploadbutton = getProperty("uploadbutton", propertyfileCE);
		doThreadSleep(3);
		doClick(uploadbutton);
		System.out.println("Doc7");
	}

	public static void riskTab() {
		doWebHandle(1);
		doSwitchToDefault();
		doThreadSleep(3);
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(4);
		String Risk = getProperty("risk", propertyfileCE);
		doClick(Risk);
		System.out.println("Clicked");
		String RiskAdd = getProperty("riskadd", propertyfileCE);
		doClick(RiskAdd);
		doThreadSleep(3);
		String PartyType = getProperty("partytype", propertyfileCE);
		doDropDownSelectByIndex(PartyType, 1);
		doThreadSleep(3);
		String SaveClose = getProperty("saveclose", propertyfileCE);
		doClick(SaveClose);
	}

	public static void actionTab() {
		System.out.println("Done");
		doWebHandle(1);
		doThreadSleep(3);
		doSwitchToDefault();
		doThreadSleep(3);
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(4);
		String actionTab = getProperty("actiontab", propertyfileCE);
		doClick(actionTab);
		doSwitchToDefault();
		doThreadSleep(3);
		doFrameSwitchByNameId("ngformIframe");
		String DecsionSelect = getProperty("decisonselect", propertyfileCE);
		doDropDownSelectByVisibleText(DecsionSelect, "Submit");
		doThreadSleep(3);
		String remarks = getProperty("remarks", propertyfileCE);
		doSendKeys(remarks, "ok");
		doThreadSleep(3);
		String submitButton = getProperty("buttonSubmit", propertyfileCE);
		doClick(submitButton);
	}

	// Credit_Evaluation

	public static void CAM() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String PSIC = getProperty("PSIC", propertyfileCE);
		doClick(PSIC);
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		doSwitchToDefault();
	}

	public static void incomeDerivation() {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String incomeDerivationTab = getProperty("incomeDerivation", propertyfileCE);
		doClick(incomeDerivationTab);
		doSwitchToDefault();
		doFrameSwitchByNameId("ngformIframe");
		String addButton = getProperty("addButton", propertyfileCE);
		doClick(addButton);
		String partyType = getProperty("partyType", propertyfileCE);
		doDropDownSelectByIndex(partyType, 1);
		String totalTaxble = getProperty("totalTaxble", propertyfileCE);
		doClickAndSendKeys(partyType, "121212");
		String totalNonTaxble = getProperty("totalNonTaxble", propertyfileCE);
		doClickAndSendKeys(totalNonTaxble, "121212");
		String gmiButton = getProperty("GMIButton", propertyfileCE);
		doClick(gmiButton);
		String saveButton = getProperty("saveButtonIncomeDerivation", propertyfileCE);
		doClick(saveButton);
		doSwitchToDefault();
	}

	public static void action_CreditEvaluation() throws Exception {
		doImplicitWait(10);
		doFrameSwitchByNameId("ngformIframe");
		String actionTab = getProperty("actionTab", propertyfileCE);
		doClick(actionTab);
		String decision = getProperty("decision", propertyfileCE);
		doDropDownSelectByVisibleText(decision, "Recommend");
		String remarks = getProperty("remarks", propertyfileCE);
		doClickAndSendKeys(remarks, "ok");
		String submitButton = getProperty("submitButton", propertyfileCE);
		doClick(submitButton);
		Thread.sleep(3000);

		doFrameSwitchByNameId("popupIFrame_confirmdone");
		String okButton = getProperty("okButton", propertyfileCE);
		doClick(okButton);
	}

	public static void documentUpload_CustomerAcceptance() throws Exception {
		
		doFrameSwitchByNameId("ngformIframe");
		
		

		String documenttab = getProperty("documenttab", propertyfileCA);
		doClick(documenttab);
		
		doThreadSleep(2);
		String docpartytype = getProperty("docpartytype", propertyfileCA);
		doDropDownSelectByIndex(docpartytype, 1);
		doThreadSleep(2);

		String Showmandatory = getProperty("manddoc", propertyfileCA);
		doClick(Showmandatory);
//        doSwitchToDefault();
//        doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(2);
		String docupload = getProperty("docfundclearance", propertyfileCA);
		doClick(docupload);
		doSwitchToDefault();
		Thread.sleep(3000);
		doWebHandle(2);
		String uploadfromcomputer = getProperty("uploadfromcomputer", propertyfile);
		Thread.sleep(3000);
		doClick(uploadfromcomputer);
		Thread.sleep(3000);
		documentUploadfromSystem(
				"C:\\Users\\tlingeshwaran\\Downloads\\FSD_Auto Loan_POST SIGN OFF_Draft version 1.xlsx");
		String uploadbutton = getProperty("uploadbutton", propertyfile);
		Thread.sleep(3000);
		doClick(uploadbutton);
	}

	public static void outwardDoc_CustomerAcceptance() {
		doThreadSleep(3);
		doWebHandle(1);
		doSwitchToDefault();
		doThreadSleep(2);
		doFrameSwitchByNameId("ngformIframe");
		String outwardDoc = getProperty("outwardDoc", propertyfileCA);
		doClick(outwardDoc);

		String attention = getProperty("attention", propertyfileCA);
		doClickAndSendKeys(attention, "ok");

		String note = getProperty("note", propertyfileCA);
		doClickAndSendKeys(note, "okay");

		String managersCheck = getProperty("managersCheck", propertyfileCA);
		doClick(managersCheck);

		String creditCASAAccount = getProperty("creditCASAAccount", propertyfileCA);
		doClick(creditCASAAccount);

		String plateNumber = getProperty("plateNumber", propertyfileCA);
		doClickAndSendKeys(plateNumber, "1233");

		String motorNumber = getProperty("motorNumber", propertyfileCA);
		doClickAndSendKeys(motorNumber, "5644");

		String chasisNumber = getProperty("chasisNumber", propertyfileCA);
		doClickAndSendKeys(chasisNumber, "233434");

		String color = getProperty("color", propertyfileCA);
		doClickAndSendKeys(color, "black");

		String engineNumber = getProperty("engineNumber", propertyfileCA);
		doClickAndSendKeys(engineNumber, "23434");

		String logChassisNumber = getProperty("logChassisNumber", propertyfileCA);
		doClickAndSendKeys(logChassisNumber, "233434");

		String date = getProperty("date", propertyfileCA);
		doClickAndSendKeys(date, "08/28/2023");

		String promiseToPay = getProperty("promiseToPay", propertyfileCA);
		doClickAndSendKeys(promiseToPay, "1000000");

		String pnPlateNumber = getProperty("pnPlateNumber", propertyfileCA);
		doClickAndSendKeys(pnPlateNumber, "2334");

		String pnEngineNumber = getProperty("pnEngineNumber", propertyfileCA);
		doClickAndSendKeys(pnEngineNumber, "23434");

		String pnChasisNumber = getProperty("pnChasisNumber", propertyfileCA);
		doClickAndSendKeys(pnChasisNumber, "233434");

		String pnColor = getProperty("pnColor", propertyfileCA);
		doClickAndSendKeys(pnColor, "black");
	}

	public static void action_CustomerAcceptance() throws InterruptedException {
		doSwitchToDefault();
		doThreadSleep(2);
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(2);
		String actionClick = getProperty("actionTab", propertyfilePE);
		doClick(actionClick);
		String decision = getProperty("decision", propertyfilePE);
		doDropDownSelectByVisibleText(decision, "Submit");
		Thread.sleep(3000);
		String remarks = getProperty("remarks", propertyfilePE);
		doSendKeys(remarks, "ok");
		String submit = getProperty("submit", propertyfilePE);
		doClick(submit);
		doSwitchToDefault();
//        Thread.sleep(5000);
//        doFrameSwitchByNameId("popupIFrame_confirmdone");
//        String okButton = getProperty("okButton", propertyfilePE);
//        doClick(okButton);
	}
	public static void outwarddoc_CreditControlReview() {
		doFrameSwitchByNameId("ngformIframe");
		doThreadSleep(2);
		String outwarddoctab = getProperty("outwarddoctab", propertyfileCCR);
		doClick(outwarddoctab);
		doThreadSleep(2);
		String date = getProperty("PNBexposredate", propertyfileCCR);
		doClickAndSendKeys(date, "08/25/2025");
		
	}
	public static void action_CreditControlReview() throws InterruptedException {
		String actiontab = getProperty("actiontab", propertyfileCCR);
		doClick(actiontab);
		Thread.sleep(2000);
		String decision = getProperty("decision", propertyfileCCR);
		doDropDownSelectByVisibleText(decision, "Submit");
		Thread.sleep(3000);
		String remarks = getProperty("remarks", propertyfileCCR);
		doClick(remarks);
		doSendKeys(remarks, "ok");
		String submit = getProperty("submit", propertyfileCCR);
		doClick(submit);
		doThreadSleep(2);
		doSwitchToDefault();
		doFrameSwitchByNameId("popupIFrame_confirmdone");
		doThreadSleep(2);
		String confsubmit = getProperty("confsubmit", propertyfileCCR);
		doClick(confsubmit);
		doSwitchToDefault();
	}
}
