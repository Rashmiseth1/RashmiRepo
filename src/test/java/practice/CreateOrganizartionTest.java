package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.vtiger.genericUtility.Base;
import com.vtiger.objectrepos.CreateNewOrganizationPage;
import com.vtiger.objectrepos.HomePage;
import com.vtiger.objectrepos.OrganizationInformationPage;
import com.vtiger.objectrepos.OrganizationPage;

public class CreateOrganizartionTest extends Base{
	@Test
	public void createOrg() {
		//Click on Org Module
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		//Click on OrgLookUpImg
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrgLookUpImg();
		//Give org Name and save it
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization("TCS-R"+jutil.getRandomNum());
		//Get headertext 
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String header = oip.getHeader();
		//Validation7
		SoftAssert s=new SoftAssert();
		s.assertTrue(header.contains("TCS"));
		Reporter.log("==ORGANIZATION IS CREATED AND TC IS PASSED==");
		s.assertAll();
		
		
	}
}
