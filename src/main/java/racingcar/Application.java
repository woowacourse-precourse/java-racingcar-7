package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = UserInput.inputCars();
        int tryCount = UserInput.inputTryCount();

        Race race = new Race(cars, tryCount);
        race.playRacing();
    }
}