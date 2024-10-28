package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        InputParser inputParser = new InputParser();

        String inputCarNames = inputView.readCarNames();
        ArrayList<Car> carNames = inputParser.parseCarNames(inputCarNames);
        String inputTryCount = inputView.readTryCount();
        int tryCount = inputParser.parseTryCount(inputTryCount);
    }
}
