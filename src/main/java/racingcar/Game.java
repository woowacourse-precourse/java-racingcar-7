package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public Game() {
        OutputHandler.printInstructionForCarNames();
        List<String> carNames = InputHandler.getCarNames();

        OutputHandler.printInstructionForTimes();
        int times = InputHandler.getTimes();

        // 핵심 로직
        List<Car> cars = new ArrayList<>();

        // 1. 객체 생성
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
