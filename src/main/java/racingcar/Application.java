package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        inputHandler.inputNames();
        inputHandler.inputCount();

        List<Car> cars = new ArrayList<>();
        for(String name : inputHandler.getNames()){
            Car car = new Car(name);
            cars.add(car);
        }

        Race race = new Race(cars, inputHandler.getRunCount());

        race.runRace();
        race.showWinners();
    }
}
