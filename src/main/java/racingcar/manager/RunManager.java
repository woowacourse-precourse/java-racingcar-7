package racingcar.manager;

import racingcar.car.Car;
import racingcar.car.factory.CarFactory;

import java.util.Set;

public class RunManager {
    private final static String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private final InputManager inputManager;

    public RunManager(InputManager inputManager){
        this.inputManager = inputManager;
    }

    public void run(){
        printNameInputMessage();
        final String inputNames = inputManager.inputCarName();
        Set<Car> cars = CarFactory.createCars(inputNames);

        printNumberInputMessage();
    }

    private void printNumberInputMessage() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
    }

    private void printNameInputMessage() {
        System.out.println(INPUT_NAME_MESSAGE);
    }
}
