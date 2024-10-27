package racingcar.model.Car.move;

import racingcar.model.Car.Car;
import java.util.List;

public class Forward extends Move implements MoveStrategy {

    @Override
    public void move(List<Car> cars) {
        for(int i=0; i<cars.size(); i++) {
            Car nowCar = cars.get(i);
            if(moveByRandom() >= MOVE_STANDARD) {
                nowCar.addMove(MOVE_NUM_PER_RADE);
            }
        }
    }

}
