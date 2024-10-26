package racingcar.model;

import java.util.List;

public class Game {
    private void oneRoundGame(Cars cars){
        Move move = new Move();
        List<Car> carGroup = cars.getCarGroup();
        for (Car car : carGroup) {
            move.moveFoward(car);
        }
    }

    public void nRoundGame(Cars cars,Integer trialCount){
        for(int i=0;i<trialCount;i++){
            oneRoundGame(cars);
        }
    }
}
