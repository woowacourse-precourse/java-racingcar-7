package racingcar.race.track.cartrack;

import java.util.List;

import racingcar.io.CarOutputHandler;
import racingcar.race.racer.car.Car;
import racingcar.race.racer.car.CarFactory;
import racingcar.race.track.Racetrack;

public class CarRacetrack implements Racetrack {
    CarOutputHandler outputHandler = new CarOutputHandler();
    CarRaceUtils carRaceUtils = new CarRaceUtils();

    private final List<Car> cars;
    private final int repeat;

    public CarRacetrack(String[] names, int repeat) {
        this.cars = new CarFactory().createRacers(names);
        this.repeat = repeat;
    }

    public void raceStart() {
        outputHandler.print("실행 결과");
        for (int i = 0; i < repeat; i++) {
            carRaceUtils.moveAll(cars);
            outputHandler.printRaceResult(cars);
        }
        List<String> winners = carRaceUtils.findWinner(cars);
        outputHandler.printWinner(winners);
    }

    public int getRepeat() {
        return repeat;
    }

    public List<Car> getCars() {
        return cars;
    }
}
