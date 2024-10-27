package racingcar;

import static racingcar.Winner.winners;

import java.util.ArrayList;
import java.util.List;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.util.Separator;
import racingcar.vehicle.Car;

public class RacingCar {

    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final Separator separator = new Separator();
    private final Winner winner = new Winner();

    public void run() {
        consoleOutputHandler.printCarNameInstruction();
        String carListInput = consoleInputHandler.getCarListInput();
        consoleOutputHandler.printTryCountInstruction();
        int tryCount = consoleInputHandler.getMoveTryCount();
        List<String> carList = separator.separateCarList(carListInput);
        List<Car> cars = new ArrayList<>();

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < carList.size(); i++) {
            cars.add(new Car(carList.get(i), tryCount));
        }

        for (int i = 0; i < tryCount; i++) {
            cars.forEach(car -> {
                car.moveForward();
                consoleOutputHandler.printExecumentInstruction(car);
            });
            System.out.println();
        }

        winners = winner.determineWinners(cars);

        consoleOutputHandler.printWinner(winners);
    }

}
