package racingcar;

import Controller.RacingCarController;
import util.Input;

import java.util.List;

public class Application {
    public static List<String> carName;
    public static int numTry;

    public static void main(String[] args) {
        try {
            carName = Input.inputCar();
            numTry = Input.inputNumTry();

            RacingCarController racingCar = new RacingCarController(carName, numTry);
            racingCar.run();
            String result = racingCar.result();

            System.out.println(result);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "프로그램을 종료합니다.");
        }
    }
}
