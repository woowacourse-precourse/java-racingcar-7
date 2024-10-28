package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private int currentRound;
    private final RaceHistory raceHistory;
    private final Cars cars;
    private final int totalRounds;

    public RacingCarGame(Cars cars, int totalRounds) {
        raceHistory = new RaceHistory();
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    public void runRound() {
        if (isEndAllRounds()) {
            return;
        }

        cars.moveCarsAccordingToGameRule();
        raceHistory.recordRoundResult(cars);
        currentRound++;
    }

    public boolean isEndAllRounds() {
        return currentRound == totalRounds;
    }

    public List<String> determineWinners() {
        List<CarState> lastRoundHistory = raceHistory.getRaceHistory().getLast().getRoundHistory();
        int maxPosition = getMaxPosition(lastRoundHistory);

        return lastRoundHistory.stream()
                .filter(carState -> carState.getPosition() == maxPosition)
                .map(CarState::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<CarState> carStates) {
        return carStates.stream()
                .mapToInt(CarState::getPosition)
                .max()
                .orElse(0);
    }
}