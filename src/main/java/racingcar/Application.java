package racingcar;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = IOHandler.inputMessage();

        DataValidator.validateName(input);
        int tryCount = DataValidator.validateTryCount(IOHandler.inputTryCount());

        List<RacingCar> racingCarList = DataParser.createRacingCar(input);
        GameStart.run(racingCarList, tryCount);
    }
}
