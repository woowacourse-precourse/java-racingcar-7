package racingcar.Controller;

import java.util.List;
import racingcar.Car;
import racingcar.service.MoveService;

public class MoveProcessController {

    private final MoveService moveService = new MoveService();

    public void moveProcess(int count, List<Car> cars){

        for(int i=0; i<count; i++){
            moveControl(cars);
        }

    }

    private void moveControl(List<Car> cars) {
        for (Car car : cars) {
            moveService.possibleMoveCheck(car);
        }
    }

}
