package racingcar.view.output;

import racingcar.car.Car;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class OutputView {

    private final OutputLogRepository outputLogRepository = new OutputLogRepository();
    private final OutputPrinter outputPrinter = new OutputPrinter();

    public void saveCarPosition(Car car) {
        outputLogRepository.saveCarPositionLog(car);
    }

    public void printResult(int attemptCount) {
        Map<String, List<BigInteger>> carMovementData = outputLogRepository.getCarPositionLog();
        outputPrinter.printResult(attemptCount, carMovementData);
    }
}
