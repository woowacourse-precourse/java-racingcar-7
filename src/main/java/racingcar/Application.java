package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputName = IOHandler.inputName();
        DataValidator.validateName(inputName);
        String inputTryCount = IOHandler.inputTryCount();
        int tryCount = DataValidator.validateTryCount(inputTryCount);

        List<RacingCar> racingCarList = DataParser.createRacingCar(inputName);
        GameStart.run(racingCarList, tryCount);
    }
}
