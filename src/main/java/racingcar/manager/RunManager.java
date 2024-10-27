package racingcar.manager;

import racingcar.car.Car;
import racingcar.car.factory.CarFactory;

import java.util.List;
import java.util.Set;

public class RunManager {
    private final static String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final static String RESULT_MESSAGE = "최종 우승자";

    private final InputManager inputManager;
    private final RacingManager racingManager;
    private final WinnerManager winnerManager;

    public RunManager(InputManager inputManager, RacingManager racingManager, WinnerManager winnerManager) {
        this.inputManager = inputManager;
        this.racingManager = racingManager;
        this.winnerManager = winnerManager;
    }

    public void run(){
        printNameInputMessage();
        final String inputNames = inputManager.inputCarName();

        final Set<Car> cars = CarFactory.createCars(inputNames);

        printNumberInputMessage();
        int number = inputManager.inputAttemptNumber();

        racingManager.racingStart(cars, number);

        List<String> winnerList = winnerManager.whoWin(cars);

        printResultMessage(winnerList);

    }

    private void printResultMessage(List<String> winnerList) {
        System.out.println(RESULT_MESSAGE);
        String result = String.join(", ", winnerList);
        System.out.println(result);
    }

    private void printNumberInputMessage() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
    }

    private void printNameInputMessage() {
        System.out.println(INPUT_NAME_MESSAGE);
    }
}
