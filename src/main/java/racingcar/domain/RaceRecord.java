package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public record RaceRecord(List<Car> carRecords) {

    public List<String> calculateWinners() {
        List<String> winners = new ArrayList<>();
        int maxScore = 0;

        for (Car car : carRecords) {
            int score = calculateScore(car.getReportCard());
            if (score > maxScore) {
                winners.clear();
                winners.add(car.getName());
                maxScore = score;
            } else if (score == maxScore) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int calculateScore(List<Boolean> reportCard) {
        return (int) reportCard.stream().filter(moved -> moved).count();
    }
}
