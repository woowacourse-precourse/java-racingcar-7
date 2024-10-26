package racingcar.controller;

import java.util.List;
import racingcar.car.Cars;
import racingcar.input.InputReader;
import racingcar.output.OutputViewer;

public class RacingManager {

    private final InputReader inputReader;
    private final OutputViewer outputViewer;

    public RacingManager(InputReader inputReader, OutputViewer outputViewer) {
        this.inputReader = inputReader;
        this.outputViewer = outputViewer;
    }

    public void run() {
        outputViewer.getCarNameInputMessage();
        final Cars cars = Cars.createCars(inputReader.getNames());

        outputViewer.getTryCountInputMessage();
        final int tryCount = inputReader.getTryCount();

        outputViewer.getRacingProgressMessage();
        outputViewer.getSystemOutPrint(progress(cars, tryCount));
        outputViewer.getRacingResultMessage(joinWinners(cars));
    }

    private String joinWinners(final Cars cars) {
        List<String> winners = cars.getRacingWinners();
        return String.join(", ", winners);
    }

    private String progress(final Cars cars, final int tryCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            sb.append(cars).append("\n");
        }
        return sb.toString();
    }
}
