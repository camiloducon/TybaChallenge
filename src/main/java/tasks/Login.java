package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.HomeAdvantageDemo.BTN_USER;
import static userinterfaces.PopUp.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task{

	private String userName;
	private String password;
	
	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BTN_USER));
		BrowseTheWeb.as(actor).waitFor(5).second();
		BrowseTheWeb.as(actor).getDriver().switchTo().defaultContent();
		BrowseTheWeb.as(actor).waitFor(5).second();
		actor.attemptsTo(Enter.theValue(userName).into(TXT_USER_NAME));
		actor.attemptsTo(Enter.theValue(password).into(TXT_PASSWORD));
		actor.attemptsTo(Click.on(BTN_SIGN_IN));
		BrowseTheWeb.as(actor).waitFor(3).second();
		
	}

	public static Login enAdvantage(String userName, String password) {
		return instrumented(Login.class, userName, password);
	}
}
