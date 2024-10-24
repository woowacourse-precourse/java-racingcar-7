package racingcar;

import utility.CarRacing;
import utility.Input;
import utility.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static List<String> cars;
    public static List<Integer> currentSituation;
    public static int numTry;

    public static void main(String[] args) {
        try {
            cars = Input.inputCars();
            numTry = Input.inputNumTry();
            currentSituation = new ArrayList<>(Collections.nCopies(cars.size(), 0));

            CarRacing.start();

            Result.printWinner(cars, currentSituation);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n프로그램을 종료합니다.");
            throw new IllegalArgumentException(e.getMessage() + "프로그램을 종료합니다.");
        }
    }
}
