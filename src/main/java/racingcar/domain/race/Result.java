package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<Records> records;

    public Result(List<Records> records) {
        this.records = new ArrayList<>(records);
    }

    public String generateResultMessage() {
        StringBuilder message = new StringBuilder();
        for (Records records : this.records) {
            message.append(records.generateRecordsMessage());
            message.append(System.lineSeparator());
        }
        return message.toString();
    }

    public List<Records> getResults() {
        return records;
    }
}
