package racingcar;

import java.util.ArrayList;

class Application {
    public static void main(String[] args) {
        Print.nameInputMessage();
        Input input = new Input();
        ArrayList<String> carNames = Input.getCarNames(input.nameInput);
        ArrayList<Car> cars = Racing.generateCars(carNames);

        Print.numberInputMessage();
        int num = Input.getNumber(input.numberInput);

        for (int i=0;i<num;i++) {
            Racing.race(cars);
        }

    }
}
