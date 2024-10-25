package racingcar;

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
        while(attempt>0){
            for (Car car : carList){
                car.moveForward();
            }
            attempt--;
        }
    }
}
