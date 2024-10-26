package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingGameService;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        List<Car> cars = Arrays.stream(carNames).map(Car::new).toList();
    }
}
