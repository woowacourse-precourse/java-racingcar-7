package racingcar.race.track;

import java.util.List;

import racingcar.io.CarOutputHandler;
import racingcar.race.RaceUtils;
import racingcar.race.racer.car.Car;
import racingcar.race.racer.car.CarFactory;

public class CarRacetrack implements Racetrack {
    CarOutputHandler outputHandler = new CarOutputHandler();
    RaceUtils raceUtils = new RaceUtils();

    private final List<Car> cars;
    private final int repeat;

    public CarRacetrack(String[] names, int repeat) {
        this.cars =  new CarFactory().createRacers(names);
        this.repeat = repeat;
    }

    public void raceStart() {
        outputHandler.print("실행 결과");
        for (int i = 0; i < repeat; i++) {
            raceUtils.moveAll(cars);
            outputHandler.printRaceResult(cars);
        }
        List<String> winners = raceUtils.findWinner(cars);
        outputHandler.printWinner(winners);
    }
}
