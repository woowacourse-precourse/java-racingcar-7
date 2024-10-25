package racingcar.controller;

import java.util.List;
import racingcar.car.Cars;
import racingcar.input.InputReader;
import racingcar.output.OutputViewer;

public class RacingManager {

    private final InputReader  inputReader;
    private final OutputViewer outputViewer;

    public RacingManager(InputReader inputReader, OutputViewer outputViewer) {
        this.inputReader = inputReader;
        this.outputViewer = outputViewer;
    }

    public void run() {
        outputViewer.getCarNameInputMessage();
        Cars cars = new Cars(inputReader.getNames());

        outputViewer.getTryCountInputMessage();
        int tryCnt = inputReader.getTryCount();

        outputViewer.getRacingProgressMessage();
        outputViewer.getSystemOutPrint(progress(cars, tryCnt));

        outputViewer.getRacingResultMessage(joinWinners(cars));
    }

    private String joinWinners(Cars cars) {
        List<String> winners = cars.getRacingWinners();
        return String.join(", ", winners);
    }

    private String progress(Cars cars, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            cars.updateCarsMovement();
            sb.append(cars).append("\n\n");
        }
        return sb.toString();
    }
}
