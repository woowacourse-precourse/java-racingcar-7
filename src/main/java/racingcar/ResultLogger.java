package racingcar;

import java.util.List;
import java.util.Map;

public class ResultLogger {

    public void print(Map<Long, List<Record>> result, long attemptNumber, List<String> winners) {
        StringBuilder sb = new StringBuilder();

        writeResult(result, attemptNumber, sb);
        writeWinners(winners, sb);

        System.out.print(sb);
    }

    private void writeResult(Map<Long, List<Record>> result, long attemptNumber, StringBuilder sb) {
        sb.append("\n").append("실행 결과").append("\n");
        for (long round = 1; round <= attemptNumber; round++) {
            writeRound(result.get(round), sb);
        }
    }

    private void writeRound(List<Record> round, StringBuilder sb) {
        for (Record record : round) {
            writeRecord(record, sb);
        }
        sb.append("\n");
    }

    private void writeRecord(Record record, StringBuilder sb) {
        sb.append(record.getName()).append(" : ");
        for (int i = 0; i < record.getMoveCount(); i++) {
            sb.append('-');
        }
        sb.append("\n");
    }

    private void writeWinners(List<String> winners, StringBuilder sb) {
        sb.append("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(winners.get(i));
        }
    }
}
