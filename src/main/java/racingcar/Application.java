package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = InputProcessor.getCarNames();
        int moveCount = InputProcessor.getMoveCount();
        System.out.println("carNames = " + carNames);
        System.out.println("moveCount = " + moveCount);
    }

}
