package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceController {
    public void run() {
        List<Car> cars = getReadyForCarList();
        int count = getReadyForCount();

        Output.printBlankLine();
        Output.printRunResultMessage();

        startRace(cars, count);
    }

    private List<Car> getReadyForCarList(){
        Output.printCarNameRequestMessage();
        return getCarList(split(Input.getCarNames()));
    }

    private List<Car> getCarList(String[] carNamesArray){
        return Arrays.stream(carNamesArray)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String[] split(String carNames){
        return carNames.split(",");
    }

    private int getReadyForCount(){
        Output.printNumberRequestMessage();
        return Input.getNumber();
    }

    private void startRace(List<Car> cars, int count){
        Race race = new Race(cars, count);
        race.start();
        Output.printFinalWinner(race.end());
    }
}
