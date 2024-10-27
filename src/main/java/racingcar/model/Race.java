package racingcar.model;

import java.util.List;

public class Race extends Evaluator {
    private int rounds;
    private List<String> winners;

    public void createRounds(String raceRounds) {
        int rounds = Integer.parseInt(raceRounds);
        setRounds(rounds);
    }

    public void createWinners(Cars cars) {
        List<String> winners = searchWinners(cars);
        setWinners(winners);
    }

    private void setRounds(int rounds) {
        this.rounds = rounds;
    }

    private void setWinners(List<String> winners) {
        this.winners = winners;
    }

    public int getRounds() {
        return rounds;
    }

    public List<String> getWinners() {
        return winners;
    }
}