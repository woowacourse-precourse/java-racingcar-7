package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    public void run() {
        Output.printCarNameRequestMessage();
        String carNames = Input.getCarNames();
        String[] carNamesArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNamesArray) {
            Car car = new Car(carName);
            cars.add(car);
        }

        Output.printNumberRequestMessage();
        int count = Input.getNumber();

        Output.printBlankLine();
        Output.printRunResultMessage();

        Race race = new Race(cars, count);
        race.start();
        Output.printFinalWinner(race.end());
    }
}
