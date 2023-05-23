package Utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
static WebDriver driver;
String Excelpath = ConfigReader.getexcelfilepath("Login");
String result;

public void WaitForElement(WebElement element) {
new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
}

public String getResultfromExcel(String sheetName, int rownumber,String res) throws InvalidFormatException, IOException {
ExcelReader reader = new ExcelReader();
List<Map<String, String>> testdata = reader.getData(Excelpath, sheetName);
 result = testdata.get(rownumber).get(res);
LoggerLoad.info("Expected result from Excel sheetname " + sheetName + " and " + rownumber + " : " + result);
return result;
}


public Map<String,String> getLoginCredentialsfromExcel(String sheetName,int rownumber) throws InvalidFormatException, IOException {

Map<String,String> credentials = null;
ExcelReader reader = new ExcelReader();
List<Map<String, String>> testdata = reader.getData(Excelpath, sheetName);
String username= testdata.get(rownumber).get("Username");
String password= testdata.get(rownumber).get("Password");
if(username != null && password!=null) {
credentials.put("username",username);
credentials.put("password",password);
LoggerLoad.info("Credential received from sheet "+sheetName+" for username " + username);
return credentials;
}
else {
	{throw new RuntimeException("Credentials not found");
}
}


}

public static String getErrorText() throws InterruptedException {
Thread.sleep(1000);
String errorMsg = driver.switchTo().alert().getText();
LoggerLoad.info("The Error Message is:" +errorMsg);
driver.switchTo().alert().accept();
return errorMsg;
}
}


