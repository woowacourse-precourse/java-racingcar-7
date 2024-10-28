package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;
import racingcar.Model.Race;
import racingcar.Model.RaceResult;
import racingcar.Service.UserInputService;
import racingcar.View.RacingCarView;

public class RacingRaceController {

    public static final int MINIMUM_VALUE_CAR_POWER = 4;

    public void racingRace() {

        RacingCarView racingCarView = new RacingCarView();
        List<Car> cars = new ArrayList<>();
        Race race = new Race(cars, MINIMUM_VALUE_CAR_POWER);
        RaceResult raceResult = new RaceResult();

        String[] carNames = racingCarView.inputCarNames();

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }

        UserInputService.racingCarUserInput(carNames);

        int numberOfRounds = Integer.parseInt(racingCarView.inputNumberOfTries());

        UserInputService.racingCarTryCountInput(numberOfRounds);

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        race.startRace(numberOfRounds);

        raceResult.calculateWinners(race.getCars());
        racingCarView.printWinners(raceResult.getWinners());
    }

}
