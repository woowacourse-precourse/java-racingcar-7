package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Judgment {

    private final MovementRecord movementRecord;

    public Judgment(final MovementRecord movementRecord) {
        this.movementRecord = movementRecord;
    }

    public List<String> getWinners() {
        Map<String, Integer> finalRound = getFinalRound();
        int maxPosition = getMaxPosition(finalRound);

        return findWinners(finalRound, maxPosition);
    }

    private Map<String, Integer> getFinalRound() {
        List<Map<String, Integer>> records = movementRecord.getRoundRecords();

        return records.getLast();
    }

    private int getMaxPosition(final Map<String, Integer> finalRound) {
        return finalRound.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    private List<String> findWinners(final Map<String, Integer> finalRound, final int maxPosition) {
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : finalRound.entrySet()) {
            if (entry.getValue() == maxPosition) {
                winners.add(entry.getKey());
            }
        }

        return winners;
    }

}
