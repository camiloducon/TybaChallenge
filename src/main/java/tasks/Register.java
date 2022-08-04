package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.Register.*;
import static userinterfaces.Register.CHECK_AGREE;
import static userinterfaces.Register.SELECT_COUNTRY;
import static userinterfaces.Register.TXT_EMAIL;
import static userinterfaces.Register.TXT_USERNAME;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class Register implements Task {

	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String country;
	private String city;
	private String address;
	private String state;
	private String postal;

	public Register(String userName, String email, String password, String confirmPassword, String firstName,
			String lastName, String phoneNumber, String country, String city, String address, String state,
			String postal) {

		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.city = city;
		this.address = address;
		this.state = state;
		this.postal = postal;

	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(userName).into(TXT_USERNAME), Enter.theValue(email).into(TXT_EMAIL),
				Enter.theValue(password).into(TXT_PASSWORD), Enter.theValue(confirmPassword).into(TXT_PASSWORD_CONFIRM),
				Enter.theValue(firstName).into(TXT_FIRST_NAME), Enter.theValue(lastName).into(TXT_LAST_NAME),
				Enter.theValue(phoneNumber).into(TXT_PHONE_NUMBER),
				SelectFromOptions.byVisibleText(country).from(SELECT_COUNTRY), Enter.theValue(city).into(TXT_CITY),
				Enter.theValue(address).into(TXT_ADDRESS), Enter.theValue(state).into(TXT_STATE),
				Enter.theValue(postal).into(TXT_POSTAL_CODE));
		actor.attemptsTo(Click.on(CHECK_AGREE));
		actor.attemptsTo(Click.on(BTN_REGISTER));
		BrowseTheWeb.as(actor).waitFor(5).second();

	}

	public static Register enAdvantage(String userName, String email, String password, String confirmPassword,
			String firstName, String lastName, String phoneNumber, String country, String city, String address,
			String state, String postal) {
		return instrumented(Register.class, userName, email, password, confirmPassword, firstName, lastName,
				phoneNumber, country, city, address, state, postal);
	}
}
