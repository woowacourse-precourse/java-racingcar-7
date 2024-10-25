package racingcar.controller;

import racingcar.model.Car;
import racingcar.utils.Utils;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final List<Car> cars = new ArrayList<>();
    private int tryNumber;
    // 컨트롤러 실행
    public void run() {
        inputInfo();
    }
    public void inputInfo(){
        String input = InputView.inputCarNames();
        tryNumber = Integer.parseInt(InputView.inputTryNumber());
    }
}
