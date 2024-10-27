package racingcar;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = IOHandler.inputMessage();

        DataValidator.validName(input);
        int tryCount = DataValidator.validCount(IOHandler.inputTryCount());

        List<RacingCar> racingCarList = DataParser.createRacingCar(input);
        GameStart.run(racingCarList, tryCount);
    }
}
