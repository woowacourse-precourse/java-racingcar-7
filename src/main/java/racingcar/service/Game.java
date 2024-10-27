package racingcar.service;

import static racingcar.util.Constant.PRINT_RESULT_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.InputUtils;
import racingcar.util.OutputUtils;

public class Game {
    List<Car> carList = new ArrayList<>();

    public void initialize(){
        carList = InputUtils.inputCarName();
        int attempt = InputUtils.inputAttempt();

        start(attempt);
    }

    public void start(int attempt){
        System.out.println(PRINT_RESULT_MESSAGE);
        for (int i = 0; i < attempt; i++){
            carList.forEach(Car::moveForward);
            OutputUtils.printPosition(carList);
        }
        OutputUtils.printEnding(carList);
    }
}