package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.advantageonlineshopping.com/#/")
public class HomeAdvantageDemo extends PageObject{

	public static final Target BTN_USER  = Target.the("boton user").locatedBy("//a[@id='menuUserLink']");
	
}
