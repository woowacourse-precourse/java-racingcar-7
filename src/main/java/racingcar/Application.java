package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarController;
import racingcar.repository.CarRepositoryImpl;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController carGame = new CarController(
                new CarService(new CarRepositoryImpl(new ArrayList<>())),
                new InputView(),
                new OutputView()
        );

        carGame.run();
    }
}
