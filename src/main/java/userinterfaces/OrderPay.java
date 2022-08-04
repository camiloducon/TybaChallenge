package userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class OrderPay extends PageObject{

	public static final Target TXT_SAFEPAY_USER_NAME = Target.the("TXT_SAFEPAY_USER_NAME")
			.located(By.name("safepay_username"));
	
	public static final Target TXT_SAFEPAY_PASSWORD = Target.the("TXT_SAFEPAY_PASSWORD")
			.located(By.name("safepay_password"));
	
	public static final Target BTN_PAY_NOW = Target.the("BTN_PAY_NOW")
			.located(By.id("pay_now_btn_SAFEPAY"));
	
	public static final Target LBL_VALIDATE_SAFEPAY = Target.the("LBL_VALIDATE_SAFEPAY")
			.locatedBy("//span[@class='roboto-regular ng-scope']");
	
	public static final Target RDB_MASTER_CREDIT = Target.the("RDB_MASTER_CREDIT")
			.locatedBy("//div[@class='imgRadioButton']//img");
	
	public static final Target TXT_NUMBER_CARD = Target.the("TXT_NUMBER_CARD")
			.located(By.name("card_number"));
	
	public static final Target TXT_CVV_CARD = Target.the("TXT_CVV_CARD")
			.located(By.name("cvv_number"));
	
	public static final Target SELECT_MES_EXPIRATION_CARD = Target.the("SELECT_MES_EXPIRATION_CARD")
			.located(By.name("mmListbox"));
	
	public static final Target SELECT_AÑO_EXPIRATION_CARD = Target.the("SELECT_AÑO_EXPIRATION_CARD")
			.located(By.name("yyyyListbox"));
	
	public static final Target TXT_CARDHOLDER_NAME = Target.the("TXT_NUMBER_CARD")
			.located(By.name("cardholder_name"));
	
	public static final Target BTN_PAY_NOW_MANUAL = Target.the("BTN_PAY_NOW_MANUAL")
			.located(By.id("pay_now_btn_ManualPayment"));
	
	
}
