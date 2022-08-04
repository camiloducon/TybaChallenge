package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AdvantageProduct extends PageObject {

	public static final Target BTN_POPULAR_ITEMS = Target.the("BTN_POPULAR_ITEMS")
			.locatedBy("//a[contains(text(),'POPULAR ITEMS')]");
	
	public static final Target LBL_ITEM = Target.the("LBL_ITEM")
			.locatedBy("//article[@id='popular_items']//p");
	
	public static final Target BTN_VIEW_DETAILS = Target.the("BTN_VIEW_DETAILS")
			.locatedBy("//article[@id='popular_items']//a");
	
	public static final Target BTN_ADD_TO_CART = Target.the("BTN_ADD_TO_CART")
			.locatedBy("//button[@name='save_to_cart']");
	
	public static final Target BTN_BACK_HOME = Target.the("BTN_BACK_HOME")
			.locatedBy("//a[@translate='HOME']");
	
	public static final Target BTN_CART = Target.the("BTN_CART")
			.locatedBy("//a[@id='shoppingCartLink']");
	
	public static final Target BTN_CHECK_OUT = Target.the("BTN_CHECK_OUT")
			.locatedBy("//button[@id='checkOutButton']");
	
	public static final Target BTN_NEXT = Target.the("BTN_NEXT")
			.locatedBy("//button[@id='next_btn']");
	
	
	
}
