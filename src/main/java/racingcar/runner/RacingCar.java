package racingcar.runner;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.runner.dto.CarDto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RacingCar {

    private final String carString;
    private final String roundString;

    private List<CarDto> cars;
    private int rounds;

    public RacingCar(String carString, String roundString) {
        this.carString = carString;
        this.roundString = roundString;
    }

    public String run() {
        cars = Arrays.stream(carString.split(","))
            .map(car -> new CarDto(car, 0))
            .toList();
        rounds = Integer.parseInt(roundString);

        return "";
    }

    private void startRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            for (CarDto car : cars) {
                this.updateMovementStatusByCar(car);
            }
            System.out.println();
        }
    }

    private void updateMovementStatusByCar(CarDto car) {
        int movementStatus = car.getMovementStatus() + this.getMovingStatus();
        car.setMovementStatus(movementStatus);
        this.printRoundResult(car);
    }

    private int getMovingStatus() {
        int minForMovingForward = 4;
        int random = Randoms.pickNumberInRange(0, 9);

        if (random < minForMovingForward) {
            return 0;
        }

        return 1;
    }

    private void printRoundResult(CarDto car) {
        System.out.printf("%s : %s%n", car.getCarName(), "-".repeat(car.getMovementStatus()));
    }

    private int getMaxMovement() {
        return cars.stream()
            .max(Comparator.comparingInt(CarDto::getMovementStatus))
            .map(CarDto::getMovementStatus)
            .orElse(0);
    }
}
