package racingcar.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.InputMessage;
import racingcar.Model.Car;
import racingcar.Model.Race;
import racingcar.Model.RaceResult;

public class RacingRaceService {

    public static final int MINIMUM_VALUE_CAR_POWER = 4;

    public void racingRace(){

        InputMessage inputMessage = new InputMessage();
        List<Car> cars = new ArrayList<>();
        RaceResult raceResult = new RaceResult();

        String[] carNames = inputMessage.inputCarNameReturnSplit(",");
        int numberOfRounds = Integer.parseInt(inputMessage.inputNumberOfTries());

        for (String carName : carNames){
            Car car = new Car(carName);
            cars.add(car);
        }

        Race race = new Race(cars, MINIMUM_VALUE_CAR_POWER);
        race.startRace(numberOfRounds);

        raceResult.calculateWinners(race.getCars());
        raceResult.printWinners();
    }

}
