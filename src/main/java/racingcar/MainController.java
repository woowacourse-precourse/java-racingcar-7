package racingcar;

import racingcar.view.InputView;

import java.util.Map;

public class MainController {
    public static  void run(){
        String inputString = InputView.readString();
        int number = InputView.readNumber();
        String[] carNames = inputString.split(",");
        RacingGame.startGame(carNames,number);
    }
}
