package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.power.PowerGenerator;
import racingcar.domain.power.RandomPowerGenerator;
import racingcar.view.InputView;

public class RacingCarController {

    private final PowerGenerator powerGenerator;
    private final InputView inputView;

    public RacingCarController() {
        this.powerGenerator = new RandomPowerGenerator();
        this.inputView = new InputView();
    }

    public void start() {
        String inputCarNames = inputView.inputCarNames();

        String inputTryCount = inputView.inputTryCount();

        List<String> names = Arrays.asList(inputCarNames.split(","));
        Cars cars = new Cars(names);

        System.out.println("실행 결과");
        for (int i = 0; i < Integer.parseInt(inputTryCount); i++) {
            cars.move(powerGenerator);
            System.out.println(cars.getForwardStatuses() + "\n");
        }

    }

}
