package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Cars cars = inputCars();
        int count = inputCount();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < count; i++) {
            cars.race(randomNumberGenerator);
        }
    }

    private static Cars inputCars() {
        Cars cars = new Cars(Console.readLine());
        return cars;
    }

    private static int inputCount() {
        return Integer.parseInt(Console.readLine());
    }
}
