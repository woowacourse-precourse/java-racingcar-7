package racingcar.racingapp.business;

import racingcar.racingapp.model.car.Car;
import racingcar.racingapp.model.car.Cars;
import racingcar.racingapp.model.car.carEngine.CarEngine;
import racingcar.racingapp.model.race.CarRacing;
import racingcar.racingapp.model.value.vo.CarNames;
import racingcar.racingapp.model.value.vo.CarRacingResult;
import racingcar.racingapp.model.value.vo.RaceRecord;
import racingcar.racingapp.model.value.vo.TotalLapCount;
import racingcar.racingapp.model.value.vo.Winners;

public class CarRacingService {

    private final CarEngine carEngine;

    private CarRacing carRacing;

    public CarRacingService(CarEngine carEngine) {
        if (carEngine == null) {
            throw new IllegalArgumentException("자동차 엔진은 비어있을 수 없습니다.");
        }
        this.carEngine = carEngine;
    }

    public CarRacingResult performCarRacing(CarNames carNames, TotalLapCount totalLapCount) {
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
