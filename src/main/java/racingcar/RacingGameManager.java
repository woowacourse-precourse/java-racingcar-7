package racingcar;

import java.util.List;

/**
 * 자동차 경주 게임을 관리한다.
 */
public class RacingGameManager {
    //TODO 자동차를 생산하고 횟수만큼 반복하며 자동차를 이동한다
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

    }

    private void validateInputCount(int count) {
        if (count < 2 || count > 1000) {
            throw new IllegalArgumentException("횟수는 최소 2번부터 최대 1000번까지 가능합니다. 입력값 :" + count);
        }
    }
}
