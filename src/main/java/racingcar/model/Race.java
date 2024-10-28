package racingcar.model;

import static racingcar.util.RandomNumGenerator.generateRandomNum;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.dto.RacingUnitResult;
import racingcar.model.dto.RacingUnitResultList;

public class Race {
    private int count;
    private Cars cars;

    public Race(int count, Cars cars) {
        this.count = count;
        this.cars = cars;
    }

    public RacingUnitResultList proceedRace() {
        RacingUnitResultList racingUnitResultList = new RacingUnitResultList();

        for (int i = 0; i < count; i++) {
            proceedRound(racingUnitResultList);
        }

        return racingUnitResultList;
    }

    private void proceedRound(RacingUnitResultList racingUnitResultList) {
        RacingUnitResult racingUnitResult = new RacingUnitResult();

        for (Car car : cars.getCarList()) {
            updateCarPosition(car);
            racingUnitResult.addResult(car);
        }

        racingUnitResultList.addUnitResult(racingUnitResult);
    }

    private static void updateCarPosition(Car car) {
        int randomFuel = generateRandomNum();
        car.updatePosition(randomFuel);
    }

}
