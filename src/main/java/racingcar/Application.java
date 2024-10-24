package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = IOHandler.inputMessage();

        List<RacingCar> racingCarList = DataParser.parseName(input);
        int tryCount = DataParser.parseCount(IOHandler.inputTryCount());

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (RacingCar racingCar : racingCarList) {
                racingCar.move();
            }
            System.out.println("");
        }
    }
}
