package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private final Input input = new Input();
    private final Output output = new Output();
    public void start() {
        output.printCarInput();
        List<String> nameList = input.userCarInput(Console.readLine());
        List<Car> carList = nameList.stream().map(Car::new).toList();
        output.printNumInput();
        int num = input.userNumInput(Console.readLine());
        RacingGame racingGame = new RacingGame(carList, num);
        racingGame.start();
    }
}
