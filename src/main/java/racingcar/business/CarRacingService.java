package racingcar.business;

import racingcar.object.Car;
import racingcar.object.CarRacing;
import racingcar.object.Cars;
import racingcar.object.carEngine.CarEngine;
import racingcar.object.value.CarNames;
import racingcar.object.value.CarRacingResult;
import racingcar.object.value.RaceRecord;
import racingcar.object.value.TotalLapCount;
import racingcar.object.value.Winners;

public class CarRacingService {

    private final CarEngine carEngine;

    private CarRacing carRacing;

    public CarRacingService(CarEngine carEngine) {
        if (carEngine == null) {
            throw new IllegalArgumentException("자동차 엔진은 비어있을 수 없습니다.");
        }
        this.carEngine = carEngine;
    }

    public CarRacingResult performCarRacing(TotalLapCount totalLapCount, CarNames carNames) {
        carRacing = prepareForRacing(totalLapCount, carNames);

        CarRacingResult raceInformation = doRace();

        return raceInformation;
    }

    private CarRacing prepareForRacing(TotalLapCount totalLapCount, CarNames carNames) {
        Cars readyCars = standByCars(carNames);
        return CarRacing.standBy(readyCars, totalLapCount);
    }

    private CarRacingResult doRace() {
        RaceRecord raceRecord = carRacing.race();
        Winners winners = raceRecord.judge();
        return new CarRacingResult(raceRecord, winners);
    }

    private Cars standByCars(CarNames carNames) {
        return new Cars(carNames.carNames().stream()
                .map(carName -> Car.ready(carEngine, carName))
                .toList());
    }

}
