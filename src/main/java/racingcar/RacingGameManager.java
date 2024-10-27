package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGameManager {
    private final CarManager carManager;
    private final ConsoleIO console;

    public RacingGameManager(CarManager carManager, ConsoleIO console) {
        this.carManager = carManager;
        this.console = console;
    }

    public void startGame() {
        String input = console.getNameInput();
        List<Car> cars = carManager.createCarsFromInput(input);
        int count = Integer.parseInt(console.getCountInput());
        validateInputCount(count);
        console.printResultMessage();
        for (int i = 0; i < count; i++) {
            playGame(cars);
        }
        List<Car> winner = carManager.findWinner(cars);
        console.printWinner(winner.stream().map(Car::getName).toList());
    }

    private void playGame(List<Car> cars) {
        for (Car car: cars) {
            int random = Randoms.pickNumberInRange(0,9);
            car.moveOrStop(random);
        }
        console.printEachResult(cars);
    }

    private void validateInputCount(int count) {
        if (count < 2 || count > 1000) {
            throw new IllegalArgumentException("횟수는 최소 2번부터 최대 1000번까지 가능합니다. 입력값 :" + count);
        }
    }
}
