package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static userinterfaces.Register.*;

public class ValidateRegisterSuccess implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean mensajeDeFiltro =  LBL_CONFIRMATION_REGISTER.resolveFor(actor).isVisible();
        return mensajeDeFiltro;
    }

    public static ValidateRegisterSuccess enAdvantage(){
        return new ValidateRegisterSuccess();
    }

}
