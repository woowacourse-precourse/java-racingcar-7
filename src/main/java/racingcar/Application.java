package racingcar;

import java.util.ArrayList;

class Application {
    public static void main(String[] args) {
        Print.nameInputMessage();
        Input nameInput = new Input();
        ArrayList<String> carNames = Input.getCarNames(nameInput.string);
        ArrayList<Car> cars = Racing.generateCars(carNames);

        Print.numberInputMessage();
        Input numberInput = new Input();
        int num = Input.getNumber(numberInput.string);

        for (int i=0;i<num;i++) {
            Racing.race(cars);
        }

        ArrayList<String> winners = Racing.getWinners(cars);
        Print.printWinners(winners);
    }
}
