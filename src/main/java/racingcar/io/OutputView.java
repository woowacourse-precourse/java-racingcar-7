package racingcar.io;

import static racingcar.global.constant.Message.READ_CAR_NAME_MESSAGE;
import static racingcar.global.constant.Message.READ_MOVEMENT_NUMBER_MESSAGE;

import racingcar.car.Cars;

public class OutputView {
    public void printCarNameMessage() {
        println(READ_CAR_NAME_MESSAGE);
    }

    public void printMovementNumberMessage() {
        println(READ_MOVEMENT_NUMBER_MESSAGE);
    }

    public void printCarStatement(Cars cars) {
        println(getCarState(cars));
        print("\n");
    }

    private String getCarState(Cars cars) {
        return cars.toString();
    }

    public void println(String string) {
        System.out.println(string);
    }

    public void print(String string) {
        System.out.print(string);
    }
}
