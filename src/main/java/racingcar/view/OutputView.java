package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    public void printTrialResult(Cars cars){
        List<Car> carGroup = cars.getCarGroup();
        for (Car car : carGroup) {
            System.out.println(car.getName()+" : "+car.getPosition());
            System.out.println();
        }
    }
}
