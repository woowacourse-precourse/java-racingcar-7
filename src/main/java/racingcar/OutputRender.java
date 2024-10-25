package racingcar;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputRender {

    private BigInteger totalMaxPosition = BigInteger.ZERO;

    public void renderResult(int attemptCount, Map<String, List<BigInteger>> carMovementData) {
        renderCarMovement(attemptCount, carMovementData);
        renderWinner(carMovementData);
    }

    public void renderCarMovement(int attemptCount, Map<String, List<BigInteger>> carMovementData) {
        for (int step = 0; step < attemptCount; step++) {
            printStepResult(step, carMovementData);
        }
    }

    public void renderWinner(Map<String, List<BigInteger>> carMovementData) {
        List<String> winners = new ArrayList<>();
        for (String name : carMovementData.keySet()) {
            List<BigInteger> resultPositions = carMovementData.get(name);
            BigInteger resultPosition = resultPositions.getLast();
            if (totalMaxPosition.compareTo(resultPosition) == 0) {
                winners.add(name);
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    private void printStepResult(int step, Map<String, List<BigInteger>> carMovementData) {
        for (String name : carMovementData.keySet()) {
            List<BigInteger> positions = carMovementData.get(name);
            BigInteger stepPosition = positions.get(step);

            printCarName(name);
            printStepPosition(stepPosition);

            if (totalMaxPosition.compareTo(stepPosition) < 0) {
                totalMaxPosition = stepPosition;
            }
        }
    }

    private void printCarName(String name) {
        System.out.print(name + " : ");
    }

    private void printStepPosition(BigInteger stepPosition) {
        for (BigInteger i = BigInteger.ZERO; i.compareTo(stepPosition) < 0; i = i.add(BigInteger.ONE)){
            System.out.print("-");
        }
        System.out.println();
    }
}
