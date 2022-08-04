package stepsdefinition;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static utils.Constantes.CAMILO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import questions.*;
import tasks.AbrirNavegador;
import tasks.Add_Product;
import tasks.Login;
import tasks.Pay;
import utils.DataDrivenExcel;
import utils.Excel;

public class purchase {
	@Managed
	private WebDriver hisBrowser;

	DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
	Map<String, String> data = new HashMap<>();

	@Before
	public void setUp() {
		CAMILO.can(BrowseTheWeb.with(hisBrowser));
	}

	@Given("^camilo want to navigate into app advantageOnline (\\d+)$")
	public void camilo_want_to_navigate_into_app_advantageOnline(int row, DataTable dataExcel) {
		List<Map<String, String>> dataFeature = dataExcel.asMaps(String.class, String.class);
		Excel excel = new Excel(dataFeature.get(0).get("Ruta Excel"), dataFeature.get(0).get("Pestana"), true, row);
		data = dataDriverExcel.leerExcel(excel);
		CAMILO.wasAbleTo(AbrirNavegador.enTyba());
	}

	@When("^i login$")
	public void i_login() {
		CAMILO.wasAbleTo(Login.enAdvantage(data.get("Username"), data.get("Password")));
	}

	@Then("^make purchase$")
	public void make_purchase() {
		CAMILO.wasAbleTo(Add_Product.enAdvantage(data.get("Items")));
	}

	@Then("^validate purchase$")
	public void validate_purchase() {
		CAMILO.wasAbleTo(Pay.enAdvantage(data.get("Choose payment"), data.get("safePayName"),
				data.get("safePayPassword"), data.get("Card number"), data.get("CVV number"),
				data.get("Mes Expiration date"), data.get("Año Expiration date"), data.get("Cardholder name")));
		CAMILO.should(seeThat(ValidatePurchaseSuccess.enAdvantage()));

	}

}
