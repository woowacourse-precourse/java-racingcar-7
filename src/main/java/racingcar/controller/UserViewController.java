package racingcar.controller;

import java.util.List;

import static racingcar.view.UserResponseView.inputTypeError;
import static racingcar.view.UserResponseView.racingOutput;

public class UserViewController {
    void callErrorView(){
        inputTypeError();
    }

    void callRacingOutputView(List<String> carName, List<Integer> start){
        racingOutput(carName, start);
    }
}
