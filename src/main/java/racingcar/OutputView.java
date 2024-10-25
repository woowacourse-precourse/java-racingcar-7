package racingcar;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class OutputView {

    private final OutputDataRepository outputDataRepository = new OutputDataRepository();
    private final OutputRender outputRender = new OutputRender();

    public void saveCarPosition(Car car) {
        outputDataRepository.saveCarPosition(car);
    }

    public void renderResult(int attemptCount) {
        Map<String, List<BigInteger>> carMovementData = outputDataRepository.getCarMovementData();
        outputRender.renderResult(attemptCount, carMovementData);
    }
}
