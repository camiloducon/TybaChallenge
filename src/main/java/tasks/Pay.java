package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.OrderPay.BTN_PAY_NOW;
import static userinterfaces.OrderPay.BTN_PAY_NOW_MANUAL;
import static userinterfaces.OrderPay.RDB_MASTER_CREDIT;
import static userinterfaces.OrderPay.SELECT_AÑO_EXPIRATION_CARD;
import static userinterfaces.OrderPay.SELECT_MES_EXPIRATION_CARD;
import static userinterfaces.OrderPay.TXT_CARDHOLDER_NAME;
import static userinterfaces.OrderPay.TXT_CVV_CARD;
import static userinterfaces.OrderPay.TXT_NUMBER_CARD;
import static userinterfaces.OrderPay.TXT_SAFEPAY_PASSWORD;
import static userinterfaces.OrderPay.TXT_SAFEPAY_USER_NAME;

import interactions.ChoosePay;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class Pay implements Task {

	private String choosePay;
	private String safePayName;
	private String safePayPassword;
	private String cardNumber;
	private String cvvNumber;
	private String mmExpirationDate;
	private String yyExpirationDate;
	private String cardHolderName;

	public Pay(String choosePay, String safePayName, String safePayPassword, String cardNumber, String cvvNumber,
			String mmExpirationDate, String yyExpirationDate, String cardHolderName) {
		this.choosePay = choosePay;
		this.safePayName = safePayName;
		this.safePayPassword = safePayPassword;
		this.cardNumber = cardNumber;
		this.cvvNumber = cvvNumber;
		this.mmExpirationDate = mmExpirationDate;
		this.yyExpirationDate = yyExpirationDate;
		this.cardHolderName = cardHolderName;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		switch (choosePay) {
		case "SafePay":
			actor.attemptsTo(Enter.theValue(safePayName).into(TXT_SAFEPAY_USER_NAME));
			actor.attemptsTo(Enter.theValue(safePayPassword).into(TXT_SAFEPAY_PASSWORD));
			actor.attemptsTo(Click.on(BTN_PAY_NOW));
			break;

		default:
			actor.attemptsTo(Click.on(RDB_MASTER_CREDIT));
			actor.attemptsTo(Enter.theValue(cardNumber).into(TXT_NUMBER_CARD));
			actor.attemptsTo(Enter.theValue(cvvNumber).into(TXT_CVV_CARD));
			actor.attemptsTo(SelectFromOptions.byVisibleText(mmExpirationDate).from(SELECT_MES_EXPIRATION_CARD));
			actor.attemptsTo(SelectFromOptions.byVisibleText(yyExpirationDate).from(SELECT_AÑO_EXPIRATION_CARD));
			actor.attemptsTo(Enter.theValue(cardHolderName).into(TXT_CARDHOLDER_NAME));
			actor.attemptsTo(Click.on(BTN_PAY_NOW_MANUAL));
			break;
		}
		//actor.attemptsTo(ChoosePay.enAdvantage(choosePay, safePayName, safePayPassword, cardNumber, cvvNumber,
			//	mmExpirationDate, yyExpirationDate, cardHolderName));

	}

	public static Pay enAdvantage(String choosePay, String safePayName, String safePayPassword, String cardNumber, String cvvNumber,
			String mmExpirationDate, String yyExpirationDate, String cardHolderName) {
		return instrumented(Pay.class, choosePay, safePayName, safePayPassword, cardNumber, cvvNumber,
				mmExpirationDate, yyExpirationDate, cardHolderName);
	}
}
