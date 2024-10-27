package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * 자동차 경주 게임을 관리한다.
 */
public class RacingGameManager {
    //TODO 승자를 찾고
    //출력한다
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
        //승자찾고 출력
        List<Car> winner = carManager.findWinner(cars);
        console.printWinner(winner.stream().map(Car::getName).toList());
    }

    private void playGame(List<Car> cars) {
        for (Car car: cars) {
            int random = Randoms.pickNumberInRange(0,9);
            if (isMovable(random)) {
                car.moveForward();   //이걸 RacingGameManager에서 하는게 맞나?
            }
        }
        console.printEachResult(cars);
    }

    private boolean isMovable(int randomNumber) {
        int CRITERIA = 4;
        return randomNumber >= CRITERIA;
    }

    private void validateInputCount(int count) {
        if (count < 2 || count > 1000) {
            throw new IllegalArgumentException("횟수는 최소 2번부터 최대 1000번까지 가능합니다. 입력값 :" + count);
        }
    }
}
