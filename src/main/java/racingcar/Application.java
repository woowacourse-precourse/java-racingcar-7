package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        InputOutputHandler.initInput();

        ArrayList<String> carNames = InputOutputHandler.getCarName();
        int racingCounter = InputOutputHandler.getRacingCounter();

        ArrayList<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }







    }
}
