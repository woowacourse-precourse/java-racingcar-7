package racingcar.view;

import static racingcar.constant.InputMessage.NUMBER_OF_ATTEMPTS;
import static racingcar.constant.InputMessage.START_GAME;

public class OutputView {

    public void printStartMessage(){
        System.out.println(START_GAME.getMessage());
    }

    public void printAttemptMessage(){
        System.out.println(NUMBER_OF_ATTEMPTS.getMessage());
    }
}
