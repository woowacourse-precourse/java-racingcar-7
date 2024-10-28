package racingcar.service;

import racingcar.domain.Car;
import racingcar.move.MoveGenerator;
import racingcar.message.CarRaceMessage;
import racingcar.printer.Printer;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceService {

    private final List<Car> cars;
    private final int round;
    private final MoveGenerator moveGenerator;
    private final Printer printer;

    public CarRaceService(List<Car> cars, int round, MoveGenerator moveGenerator, Printer printer) {
        this.cars = cars;
        this.round = round;
        this.moveGenerator = moveGenerator;
        this.printer = printer;
    }

    public void startRace() {
        printer.printMessage(CarRaceMessage.EXECUTION_RESULT.getMessage());
        for (int i = 0; i < round; i++) {
            cars.forEach(car -> car.move(moveGenerator));
            printer.writeProgress(cars);
        }
        printer.printProgress();
        announceWinners();
    }

    private void announceWinners() {
        int maxDistance = cars.stream()
            .mapToInt(Car::getLocation)
            .max()
            .orElse(0);

        List<String> winners = cars.stream()
            .filter(car -> car.getLocation() == maxDistance)
            .map(Car::getName)
            .collect(Collectors.toList());

        printer.printMessage(CarRaceMessage.FINAL_WINNER.getMessage() + String.join(", ", winners));
    }
}
