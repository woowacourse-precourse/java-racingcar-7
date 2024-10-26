package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {
    public void printIntermediateResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getPositionOutPut(car.getPosition()));
        }
    }

    private String getPositionOutPut(int carPosition) {
        String positionOutPut = "";
        for (int i = 0; i < carPosition; i++) {
            positionOutPut += "-";
        }
        return positionOutPut;
    }
}
