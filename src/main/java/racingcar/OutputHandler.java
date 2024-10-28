package racingcar;

import java.util.List;

public class OutputHandler {
    private StringBuilder stringBuilder = new StringBuilder();

    public void getResult(List<CarRecord> carRecords, List<String> winners, Integer roundCount) {
        stringBuilder.setLength(0);
        stringBuilder.append('\n').append("실행 결과").append('\n');
        displayRacingProgress(carRecords, roundCount);
        printRacingWinners(winners);
        System.out.println(stringBuilder);
    }

    private void displayRacingProgress(List<CarRecord> carRecords, Integer roundCount) {
        for (int currentRound = 1; currentRound <= roundCount; currentRound++) {
            printRacingProgress(carRecords, currentRound);
        }
    }

    private void printRacingProgress(List<CarRecord> carRecords, Integer currentRound) {
        for (CarRecord carRecord : carRecords) {
            stringBuilder.append(carRecord.getCarName()).append(" : ");
            for (int i = 0; i < carRecord.getMoveCount(currentRound); i++) {
                stringBuilder.append("-");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");
    }

    private void printRacingWinners(List<String> winners) {
        stringBuilder.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i));
            if (i != winners.size() - 1) {
                stringBuilder.append(", ");
            }
        }
    }
}
