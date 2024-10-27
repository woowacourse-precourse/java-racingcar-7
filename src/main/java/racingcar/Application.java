package racingcar;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {



/*    initializeCars(List<String> carNames)
    generateRandomNumber()

    canMove(int randomNumber)
    moveCar(Car car, int randomNumber)
    playRound(List<Car> cars)
    getWinners(List<Car> cars)

    validateCarName(String carName)
    validateAttemptCount(String attemptCount)*/

    public static void main(String[] args) {
        // InputHandler 인스턴스 생성
        InputHandler inputHandler = new InputHandler();

        // 메서드 호출
        List<String> carNames = inputHandler.getCarNames();
        int attemptCount = inputHandler.getRaceAttemptCount();
    }
}
