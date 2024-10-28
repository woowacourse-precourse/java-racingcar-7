package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;
import racingcar.util.Separator;
import racingcar.vehicle.Car;
import racingcar.vehicle.Vehicle;

public class RacingCar {

    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final Separator separator = new Separator();
    private final Winner winner = new Winner();

    public void run() {
        consoleOutputHandler.printCarNameInstruction();
        String vehicleListInput = consoleInputHandler.getVehicleListInput();
        consoleOutputHandler.printTryCountInstruction();
        int tryCount = consoleInputHandler.getMoveTryCount();
        List<String> vehicleList = separator.separateVehicleList(vehicleListInput);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < vehicleList.size(); i++) {
            vehicles.add(new Car(vehicleList.get(i), tryCount));
        }

        for (int i = 0; i < tryCount; i++) {
            vehicles.forEach(vehicle -> {
                vehicle.attemptMoveForward();
                consoleOutputHandler.printProgressDegree(vehicle);
            });
            System.out.println();
        }

        winner.determine(vehicles);

        consoleOutputHandler.printWinner(winner.getWinners());
    }

}
