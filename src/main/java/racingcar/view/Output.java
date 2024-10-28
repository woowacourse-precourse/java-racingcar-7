package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;


public class Output {
    public void printRoundResult(Cars cars) {
        for(Car car : cars.getCarList()) {
            System.out.print(car.getName() + " : ");
            printDash(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private void printDash(int count) {
        for(int i = 0; i < count; i++)
            System.out.print("-");
    }
}
