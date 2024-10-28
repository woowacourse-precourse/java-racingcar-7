package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> inputNames = new HashMap<>();
        int numIterations = 0;

        InputHandler inputHandler = new InputHandler();

        System.out.println(GuideMessage.INPUT_NAME.getMessage());
        inputNames = inputHandler.readCarNames();
        System.out.println(GuideMessage.INPUT_ITER.getMessage());
        numIterations = inputHandler.readIterNum();
    }
}
