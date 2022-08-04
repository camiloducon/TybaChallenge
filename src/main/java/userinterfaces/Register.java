package userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class Register extends PageObject {

	public static final Target TXT_USERNAME = Target.the("USERNAME").located(By.name("usernameRegisterPage"));

	public static final Target TXT_EMAIL = Target.the("TXT_EMAIL").located(By.name("emailRegisterPage"));

	public static final Target TXT_PASSWORD = Target.the("TXT_PASSWORD").located(By.name("passwordRegisterPage"));

	public static final Target TXT_PASSWORD_CONFIRM = Target.the("TXT_PASSWORD_CONFIRM")
			.located(By.name("confirm_passwordRegisterPage"));

	public static final Target TXT_FIRST_NAME = Target.the("TXT_FIRST_NAME").located(By.name("first_nameRegisterPage"));

	public static final Target TXT_LAST_NAME = Target.the("TXT_LAST_NAME").located(By.name("last_nameRegisterPage"));

	public static final Target TXT_PHONE_NUMBER = Target.the("PHONE NUMBER")
			.located(By.name("phone_numberRegisterPage"));

	public static final Target SELECT_COUNTRY = Target.the("SELECT_COUNTRY")
			.located(By.name("countryListboxRegisterPage"));

	public static final Target TXT_CITY = Target.the("boton CUENTA").located(By.name("cityRegisterPage"));

	public static final Target TXT_ADDRESS = Target.the("TXT_ADDRESS").located(By.name("addressRegisterPage"));

	public static final Target TXT_STATE = Target.the("TXT_STATE").located(By.name("state_/_province_/_regionRegisterPage"));

	public static final Target TXT_POSTAL_CODE = Target.the("TXT_POSTAL_CODE")
			.located(By.name("postal_codeRegisterPage"));

	public static final Target CHECK_AGREE = Target.the("CHECK_AGREE")
			.locatedBy("//label[@class='checkboxText roboto-light animated']");

	public static final Target BTN_REGISTER = Target.the("TXT_POSTAL_CODE").located(By.id("register_btnundefined"));
	
	public static final Target LBL_CONFIRMATION_REGISTER = Target.the("LBL_CONFIRMATION_REGISTER").located(By.id("menuUserLink"));

	
	
}
