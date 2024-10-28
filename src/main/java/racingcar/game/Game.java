package racingcar.game;

import racingcar.car.Car;

import java.util.ArrayList;

public class Game {
    public static void start(ArrayList<Car> carList, int n) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < n; i++) {
            progress(carList);
            printProgress(carList);
        }

        getResult();
    }

    private static void progress(ArrayList<Car> carList) {
        for (Car c : carList) {
            c.move();
        }
    }

    private static void printProgress(ArrayList<Car> carList) {
        for (Car c : carList) {
            System.out.println(c.getName() + " : " + "-".repeat(c.getMoveCount()));
        }
        System.out.println();
    }

    private static void getResult() {

    }
}
