package racingcar.controller;

import java.util.List;

import static racingcar.view.UserResponseView.*;

public class UserViewController {

    void callErrorView(){
        inputTypeError();
    }

    void callRacingOutputView(List<String> carName, List<Integer> start){
        racingOutput(carName, start);
    }

    void callWinnerOutput(List<String> winners){
        finalWinner(winners);
    }
}
