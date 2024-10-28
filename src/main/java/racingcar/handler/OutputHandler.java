package racingcar.handler;

import java.util.List;
import java.util.Map;

public class OutputHandler {
    public static void winnerOutput(String message) {
        System.out.println("최종 우승자 : " + message);
    }

    public static void moveRecordsOutput(List<Map<String, String>> moveRecords) {
        System.out.println("실행 결과");

        for (Map<String, String> moveRecord : moveRecords) {
            recordOutput(moveRecord);

            System.out.println();
        }
    }

    private static void recordOutput(Map<String, String> moveRecord) {
        for (Map.Entry<String, String> entry : moveRecord.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}