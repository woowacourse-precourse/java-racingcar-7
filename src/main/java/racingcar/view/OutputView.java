package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void printMoveResultMessage() {
        System.out.println("실행 결과");
    }

    public void printMovedCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getMovedNumber(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
