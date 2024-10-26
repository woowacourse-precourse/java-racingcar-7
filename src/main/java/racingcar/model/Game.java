package racingcar.model;

import java.util.List;

public class Game {
    public void oneRoundGame(Cars cars){
        Move move = new Move();
        List<Car> carGroup = cars.getCarGroup();
        for (Car car : carGroup) {
            move.moveFoward(car);
        }
    }
}
