package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static userinterfaces.OrderPay.*;

public class ValidatePurchaseSuccess implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean mensajeDeFiltro =  LBL_VALIDATE_SAFEPAY.resolveFor(actor).isVisible();
        return mensajeDeFiltro;
    }

    public static ValidatePurchaseSuccess enAdvantage(){
        return new ValidatePurchaseSuccess();
    }

}
