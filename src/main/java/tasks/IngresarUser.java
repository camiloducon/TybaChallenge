package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.HomeAdvantageDemo.BTN_USER;
import static userinterfaces.PopUp.*;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.Helpers;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IngresarUser implements Task {

	Helpers helpers = new Helpers();
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BTN_USER));
		BrowseTheWeb.as(actor).waitFor(5).second();
		BrowseTheWeb.as(actor).getDriver().switchTo().defaultContent();
		BrowseTheWeb.as(actor).waitFor(5).second();
		actor.attemptsTo(WaitUntil.the(BTN_CREATE_ACCOUNT, isClickable()),Click.on(BTN_CREATE_ACCOUNT));
		BrowseTheWeb.as(actor).waitFor(5).second();
	}

	public static IngresarUser enHome() {
		return instrumented(IngresarUser.class);

	}

}
