package racingcar.executor;

import racingcar.entity.Car;
import racingcar.executor.mover.AllCarMoverImpl;
import racingcar.executor.util.DataConverter;
import racingcar.extractor.car.name.CarNameExtractorImpl;
import racingcar.input.car.name.ConsoleCarNameInput;
import racingcar.input.trial.ConsoleMoveTrialInput;
import racingcar.output.process.ProcessOutputHandlerImpl;
import racingcar.output.result.ResultOutputHandlerImpl;

import java.util.List;

public class CarRacingExecutor {

    private final ConsoleCarNameInput consoleCarNameInput;
    private final CarNameExtractorImpl carNameExtractor;
    private final AllCarMoverImpl moveDistanceCalculator;
    private final ConsoleMoveTrialInput consoleMoveTrialInput;
    private final ProcessOutputHandlerImpl processOutputHandler;
    private final ResultOutputHandlerImpl resultOutputHandler;

    public CarRacingExecutor(ConsoleCarNameInput consoleCarNameInput,
                             CarNameExtractorImpl carNameExtractor,
                             AllCarMoverImpl moveDistanceCalculator,
                             ConsoleMoveTrialInput consoleMoveTrialInput,
                             ProcessOutputHandlerImpl processOutputHandler,
                             ResultOutputHandlerImpl resultOutputHandler) {
        this.consoleCarNameInput = consoleCarNameInput;
        this.carNameExtractor = carNameExtractor;
        this.moveDistanceCalculator = moveDistanceCalculator;
        this.consoleMoveTrialInput = consoleMoveTrialInput;
        this.processOutputHandler = processOutputHandler;
        this.resultOutputHandler = resultOutputHandler;
    }

    public void run() {
        String carNameInputString = consoleCarNameInput.readCarName();
        String[] carNameList = carNameExtractor.extractFromInputString(carNameInputString);
        List<Car> racingHistory = DataConverter.convertFromCarNameListToCarList(carNameList);
        int trial = consoleMoveTrialInput.readMoveTrialCount();

        processOutputHandler.printFirstPhrase();
        for (int i = 0; i < trial; i++) {
            racingHistory = moveDistanceCalculator.run(racingHistory);
            processOutputHandler.printHistory(racingHistory);
        }
        resultOutputHandler.printWinner(racingHistory);
    }
}
