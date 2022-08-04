package userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PopUp extends PageObject {

	public static final Target BTN_CREATE_ACCOUNT = Target.the("boton CUENTA")
			.locatedBy("//a[contains(text(),'CREATE NEW ACCOUNT')]");

	public static final Target TXT_USER_NAME = Target.the("TXT_USER_NAME")
			.located(By.name("username"));

	public static final Target TXT_PASSWORD = Target.the("TXT_PASSWORD")
			.located(By.name("password"));

	public static final Target BTN_SIGN_IN = Target.the("boton SIGN IN")
			.locatedBy("//button[contains(text(),'SIGN IN')]");

}
