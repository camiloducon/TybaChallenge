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
import questions.ValidateRegisterSuccess;
import tasks.AbrirNavegador;
import tasks.IngresarUser;
import utils.DataDrivenExcel;
import utils.Excel;

public class Register {
	@Managed
	private WebDriver hisBrowser;

	DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
	Map<String, String> data = new HashMap<>();

	@Before
	public void setUp() {
		CAMILO.can(BrowseTheWeb.with(hisBrowser));
	}

	@Given("^camilo want to navigate into advantageOnline (.*)$")
	public void camilo_want_to_navigate_into_advantageOnline(int row, DataTable dataExcel) {
		List<Map<String, String>> dataFeature = dataExcel.asMaps(String.class, String.class);
		Excel excel = new Excel(dataFeature.get(0).get("Ruta Excel"), dataFeature.get(0).get("Pestana"), true, row);
		data = dataDriverExcel.leerExcel(excel);
		CAMILO.wasAbleTo(AbrirNavegador.enTyba());
		CAMILO.wasAbleTo(IngresarUser.enHome());

	}

	@When("^fill out the form$")
	public void fill_out_the_form() {
		CAMILO.wasAbleTo(tasks.Register.enAdvantage(data.get("Username"), data.get("Email"), data.get("Password"),
				data.get("Confirm password"), data.get("First Name"), data.get("Last Name"), data.get("Phone Number"),
				data.get("Country"), data.get("City"), data.get("Address"), data.get("State"),
				data.get("Postal Code")));
	}

	@Then("^I can validate the correct creation$")
	public void i_can_validate_the_correct_creation() {
		CAMILO.should(seeThat(ValidateRegisterSuccess.enAdvantage()));
	}

}
