package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = IOHandler.inputMessage();

        List<RacingCar> racingCarList = DataParser.parseName(input);
    }
}
