package racingcar;

import racingcar.config.CarRaceConfig;
import racingcar.domain.car.Car;
import racingcar.domain.race.CarRace;
import racingcar.domain.race.RacePosition;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.io.InputReceiver;
import racingcar.domain.car.CarName;
import racingcar.domain.move.MoveAttempt;
import racingcar.io.view.OutPutView;

import java.util.Arrays;
import java.util.List;

public class RaceController {
    private static final String COMMA_DELIMITER = ",";
    private final InputReceiver inputReceiver;
    private final OutPutView outPutView;
    private final CarRace carRace;

    public RaceController(CarRaceConfig carRaceConfig, CarRace carRace) {
        this.inputReceiver = carRaceConfig.getInputReceiver();
        this.outPutView = carRaceConfig.getOutPutView();
        this.carRace = carRace;
    }

    public void run() {
        RacePosition updatePosition = readCarNames();
        MoveAttempt moveAttempt = readMoveAttempt();
        for(int i = 0; i < moveAttempt.getCount(); i ++) {
            updatePosition = attemptToMove(updatePosition);
        }
        showWinner(updatePosition);
    }

    private RacePosition readCarNames() {
        String carNamesString = inputReceiver.readInput();
        List<CarName> carNameList = Arrays.stream(carNamesString.split(COMMA_DELIMITER))
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
        String attemptCountString = inputReceiver.readInput();
        return MoveAttempt.of(attemptCountString);
    }

    private RacePosition attemptToMove(RacePosition currentPosition) {
        RacePosition updatePosition = carRace.update(currentPosition);
        showRacePosition(updatePosition);
        return updatePosition;
    }

    private void showRacePosition(RacePosition racePosition) {
        CarsDto racePositionDto = toCarsDto(racePosition.getCarList());
        outPutView.showRacePosition(racePositionDto);
    }

    private void showWinner(RacePosition finalPosition) {
        List<Car> farthestCars = finalPosition.findFarthestCar();
        outPutView.showWinner(toCarsDto(farthestCars));
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
