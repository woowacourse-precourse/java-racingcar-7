package racingcar.view.output;

import racingcar.game.GameResult;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    private BigInteger totalMaxPosition = BigInteger.ZERO;
    private int attemptCount;
    private Map<String, List<BigInteger>> carPositionLog;
    private final StringBuilder printResult = new StringBuilder();

    public void printResult(GameResult gameResult) {
        init(gameResult);
        print();
    }

    private void buildCarMovement() {
        for (int step = 0; step < attemptCount; step++) {
            printStepResult(step);
            printResult.append("\n");
        }
    }

    public void buildWinner() {
        List<String> winners = new ArrayList<>();
        for (String name : carPositionLog.keySet()) {
            List<BigInteger> resultPositions = carPositionLog.get(name);
            BigInteger resultPosition;
            resultPosition = getResultPosition(resultPositions);
            if (totalMaxPosition.compareTo(resultPosition) == 0) {
                winners.add(name);
            }
        }
        printResult.append("최종 우승자 : ");
        printResult.append(String.join(", ", winners));
    }

    private BigInteger getResultPosition(List<BigInteger> resultPositions) {
        BigInteger resultPosition;
        if (resultPositions.isEmpty()) {
            resultPosition = BigInteger.ZERO;
        } else {
            resultPosition = resultPositions.getLast();
        }
        return resultPosition;
    }

    public String getPrintResult() {
        return printResult.toString();
    }

    private void init(GameResult gameResult) {
        this.attemptCount = gameResult.getAttemptCount();
        this.carPositionLog = gameResult.getCarPositionLog();
    }

    private void print() {
        printResult.append("\n실행 결과\n");
        buildCarMovement();
        buildWinner();
        System.out.println(printResult);
    }

    private void printStepResult(int step) {
        for (String name : carPositionLog.keySet()) {
            List<BigInteger> positions = carPositionLog.get(name);
            BigInteger stepPosition = positions.get(step);

            printCarName(name);
            printStepPosition(stepPosition);

            updateTotalMaxPosition(stepPosition);
        }
    }

    private void updateTotalMaxPosition(BigInteger stepPosition) {
        if (totalMaxPosition.compareTo(stepPosition) < 0) {
            totalMaxPosition = stepPosition;
        }
    }

    private void printCarName(String name) {
        printResult.append(name).append(" : ");
    }

    private void printStepPosition(BigInteger stepPosition) {
        for (BigInteger i = BigInteger.ZERO; i.compareTo(stepPosition) < 0; i = i.add(BigInteger.ONE)) {
            printResult.append("-");
        }
        printResult.append("\n");
    }
}
