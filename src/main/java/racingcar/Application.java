package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    public void run(){
        InputController inputController = new InputController();
        List<String> carNames = inputController.readCarNames();
        Integer tryCount = inputController.readTryCount();
    }
}
