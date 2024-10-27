package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = inputCars();
    }

    private static Cars inputCars() {
        Cars cars = new Cars(Console.readLine());
        return cars;
    }
}
