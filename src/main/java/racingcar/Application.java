package racingcar;

import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carList = InputView.inputCarList();
        Integer tryRounds = InputView.inputTryRounds();
    }
}
