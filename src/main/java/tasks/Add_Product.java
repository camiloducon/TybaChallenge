package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static userinterfaces.AdvantageProduct.*;

import interactions.SelectItems;

public class Add_Product implements Task {

	private String userName;

	public Add_Product(String userName) {
		this.userName = userName;

	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		BrowseTheWeb.as(actor).waitFor(5).second();
		actor.attemptsTo(SelectItems.enAdvantage(userName));
		BrowseTheWeb.as(actor).waitFor(5).second();
		actor.attemptsTo(Click.on(BTN_CART));
		actor.attemptsTo(Click.on(BTN_CHECK_OUT));
		BrowseTheWeb.as(actor).waitFor(2).second();
		actor.attemptsTo(Click.on(BTN_NEXT));
		BrowseTheWeb.as(actor).waitFor(3).second();
	}

	public static Add_Product enAdvantage(String userName) {
		return instrumented(Add_Product.class, userName);
	}
}
