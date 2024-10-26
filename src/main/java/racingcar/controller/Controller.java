package racingcar.controller;

import racingcar.service.Parser;
import racingcar.view.InputView;

import java.util.List;

public class Controller {

    private final InputView inputView = new InputView();
    private final Parser parser = new Parser();

    public void run() {
        String inputCarList = inputView.inputCarList();
        String inputTryCnt = inputView.inputTryCnt();
        List<String> carList = parser.parseCarList(inputCarList);

        // 테스트용
        for (String car : carList) {
            System.out.println(car);
        }

        System.out.println("시도할 횟수: " + inputTryCnt);
    }
}
