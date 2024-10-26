package racingcar.view.output;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputPrinter {

    private BigInteger totalMaxPosition = BigInteger.ZERO;

    public void printResult(int attemptCount, Map<String, List<BigInteger>> carMovementLog) {
        System.out.println("\n실행 결과");
        printCarMovement(attemptCount, carMovementLog);
        printWinner(carMovementLog);
    }

    public void printWinner(Map<String, List<BigInteger>> carMovementLog) {
        List<String> winners = new ArrayList<>();
        for (String name : carMovementLog.keySet()) {
            List<BigInteger> resultPositions = carMovementLog.get(name);
            BigInteger resultPosition = resultPositions.getLast();
            if (totalMaxPosition.compareTo(resultPosition) == 0) {
                winners.add(name);
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

    public void printCarMovement(int attemptCount, Map<String, List<BigInteger>> carMovementLog) {
        for (int step = 0; step < attemptCount; step++) {
            printStepResult(step, carMovementLog);
            System.out.println();
        }
    }

    private void printStepResult(int step, Map<String, List<BigInteger>> carMovementLog) {
        for (String name : carMovementLog.keySet()) {
            List<BigInteger> positions = carMovementLog.get(name);
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
        for (BigInteger i = BigInteger.ZERO; i.compareTo(stepPosition) < 0; i = i.add(BigInteger.ONE)) {
            System.out.print("-");
        }
        System.out.println();
    }
}
