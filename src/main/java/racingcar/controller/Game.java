package racingcar.controller;

import racingcar.View.InputView;
import racingcar.View.constants.Notice;

public class Game {

    public void run(){
        InputView.printInsertMessage(Notice.ASK_CAR_NAMES);
        InputView.printInsertMessage(Notice.ASK_NUMBER_OF_TRIALS);

    }

}
