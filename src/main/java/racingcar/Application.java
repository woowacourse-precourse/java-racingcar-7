package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarInputHandler carInputHandler = new CarInputHandler();
        CarOutputHandler carOutputHandler = new CarOutputHandler();

        String inputCarNames = carInputHandler.userInputCarNames();
        String[] separatedCarNames = carInputHandler.splitCarNames(inputCarNames);
        List<Car> carNameList = Car.createCarList(separatedCarNames);

        int howManyTimesMove = carInputHandler.userInputHowManyTimes();
        carOutputHandler.runRace(carNameList, howManyTimesMove);
    }
}