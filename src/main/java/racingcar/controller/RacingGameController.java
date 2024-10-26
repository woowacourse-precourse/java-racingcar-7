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
        System.out.println("시도할 횟수");
        int playRound = Integer.parseInt(Console.readLine());

        playRound(playRound, cars);
    }

    private void playRound(int playRound, List<Car> cars) {
        for (int i = 0; i < playRound; i++){
            racingGameService.play(cars);
            printResult(cars);
        }
    }

    private void printResult(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }
}
