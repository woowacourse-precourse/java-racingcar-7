package racingcar.Controller;

import racingcar.Model.CarNameValidator;
import racingcar.Model.RacingCars;
import racingcar.View.InputView;

public class InputController {
    public static RacingCars setRacingCars(){
        try{
            CarNameValidator carNameValidator = new CarNameValidator(InputView.inputCars());
            return new RacingCars(carNameValidator.names);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setRacingCars();
        }
    }
}
