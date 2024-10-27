package racingcar;

import static racingcar.Constant.PRINT_RESULT_MESSAGE;

import java.util.ArrayList;
import java.util.List;

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