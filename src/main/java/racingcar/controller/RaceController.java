package racingcar.controller;

import racingcar.model.Car;
import racingcar.domain.Race;
import racingcar.util.Separator;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.Arrays;
import java.util.List;

public class RaceController {
    public void run() {
        List<Car> cars = getReadyForCarList();
        int count = getReadyForCount();

        Output.printBlankLine();
        Output.printRunResultMessage();

        startRace(cars, count);
    }

    private List<Car> getReadyForCarList() {
        Output.printCarNameRequestMessage();
        return getCarList(Separator.split(Input.getCarNames()));
    }

    private List<Car> getCarList(String[] carNamesArray) {
        return Arrays.stream(carNamesArray)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    private int getReadyForCount() {
        Output.printNumberRequestMessage();
        return Input.getNumber();
    }

    private void startRace(List<Car> cars, int count) {
        Race race = new Race(cars, count);
        race.start();
        Output.printFinalWinner(race.end());
    }
}
