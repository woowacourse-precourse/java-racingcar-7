package racingcar.race;

import java.util.List;

import racingcar.io.CarInputHandler;
import racingcar.io.CarOutputHandler;
import racingcar.racer.car.Car;
import racingcar.racer.car.CarFactory;

public class CarRacetrack implements Racetrack {
    CarInputHandler inputHandler = new CarInputHandler();
    CarOutputHandler outputHandler = new CarOutputHandler();
    RaceController raceController = new RaceController();

    public void raceStart() {
        List<Car> cars = new CarFactory().createRacers();
        int repeat = inputHandler.inputRepeatNum();
        outputHandler.print("실행 결과");
        for (int i = 0; i < repeat; i++) {
            List<Car> moveResult = raceController.moveAll(cars);
            outputHandler.printRaceResult(moveResult);
        }
        List<String> winners = raceController.findWinner(cars);
        outputHandler.printWinner(winners);
    }
}
