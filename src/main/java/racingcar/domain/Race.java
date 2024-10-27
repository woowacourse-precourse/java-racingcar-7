package racingcar.domain;

import racingcar.io.OutputWriter;
import racingcar.service.RaceService;
import racingcar.service.RaceServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final OutputWriter outputWriter = new OutputWriter();
    private final RaceService raceService = new RaceServiceImpl();
    private final String[] carNames;
    private final int num;


    public Race(String[] carNames, int num) {
        this.carNames = carNames;
        this.num = num;
    }

    public void start() throws IllegalArgumentException {
        List<Car> cars = makeRoster();

        for (int i = 0; i < num; i++) {
            raceService.race(cars);
            outputWriter.printIntermediateResult(cars);
        }
        outputWriter.printFinalResult(cars);
    }

    private List<Car> makeRoster() {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }


}
