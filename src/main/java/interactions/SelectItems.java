package interactions;

import static userinterfaces.AdvantageProduct.*;

import java.util.Iterator;
import java.util.List;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

public class SelectItems implements Interaction {
	List<WebElementFacade> ListItems;
	List<WebElementFacade> ListLabelItem;
	private String item;

	public SelectItems(String item) {
		this.item = item;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BTN_POPULAR_ITEMS));
		String[] itemsExcel = item.split(";");
		for (String excel : itemsExcel) {
			ListItems = BTN_VIEW_DETAILS.resolveAllFor(actor);
			ListLabelItem = LBL_ITEM.resolveAllFor(actor);
			for (int i = 0; i < ListLabelItem.size(); i++) {
				if (ListLabelItem.get(i).getText().equals(excel)) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ListItems.get(i).click();
					actor.attemptsTo(Click.on(BTN_ADD_TO_CART));
					actor.attemptsTo(Click.on(BTN_BACK_HOME));
					actor.attemptsTo(Click.on(BTN_POPULAR_ITEMS));
					break;
				}
			}
		}



	}


	public static SelectItems enAdvantage(String item) {
		return new SelectItems(item);
	}

}
