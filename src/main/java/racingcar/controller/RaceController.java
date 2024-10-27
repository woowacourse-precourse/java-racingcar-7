package racingcar.controller;

import racingcar.config.CarRaceConfig;
import racingcar.domain.car.Car;
import racingcar.domain.race.CarRace;
import racingcar.domain.race.RacePosition;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.domain.car.CarName;
import racingcar.domain.move.MoveAttempt;

import java.util.Arrays;
import java.util.List;

public class RaceController {
    private static final String COMMA_DELIMITER = ",";
    private final CarRace carRace;
    private final CarRaceConfig carRaceConfig;

    public RaceController(CarRaceConfig carRaceConfig, CarRace carRace) {
        this.carRaceConfig = carRaceConfig;
        this.carRace = carRace;
    }

    public void run() {
        RacePosition updatePosition = readCarNames();
        MoveAttempt moveAttempt = readMoveAttempt();
        for (int i = 0; i < moveAttempt.getCount(); i++) {
            updatePosition = attemptToMove(updatePosition);
        }
        showWinner(updatePosition);
    }

    private RacePosition readCarNames() {
        carRaceConfig.getOutPutView().showCarNameExplanation();
        String carNamesString = carRaceConfig.getInputReceiver().readInput();
        List<CarName> carNameList = Arrays.stream(carNamesString.split(COMMA_DELIMITER, -1))
                .map(CarName::of)
                .toList();
        return generateDefaultRacePosition(carNameList);
    }

    private RacePosition generateDefaultRacePosition(List<CarName> carNameList) {
        List<Car> carList = carNameList.stream()
                .map(Car::new)
                .toList();
        return new RacePosition(carList);
    }

    private MoveAttempt readMoveAttempt() {
        carRaceConfig.getOutPutView().showAttemptExplanation();
        String attemptCountString = carRaceConfig.getInputReceiver().readInput();
        return MoveAttempt.of(attemptCountString);
    }

    private RacePosition attemptToMove(RacePosition currentPosition) {
        RacePosition updatePosition = carRace.update(currentPosition);
        showRacePosition(updatePosition);
        return updatePosition;
    }

    private void showRacePosition(RacePosition racePosition) {
        CarsDto racePositionDto = toCarsDto(racePosition.getCarList());
        carRaceConfig.getOutPutView().showRacePosition(racePositionDto);
    }

    private void showWinner(RacePosition finalPosition) {
        List<Car> farthestCars = finalPosition.findFarthestCar();
        carRaceConfig.getOutPutView().showWinner(toCarsDto(farthestCars));
    }

    private CarsDto toCarsDto(List<Car> carList) {
        return new CarsDto(carList.stream()
                .map(this::toCarDto)
                .toList());
    }

    private CarDto toCarDto(Car car) {
        return new CarDto(car.getName().getIdentifier(), car.getCarPosition().getPosition());
    }
}
