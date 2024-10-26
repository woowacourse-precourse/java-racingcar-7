package racingcar.racing.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.racing.view.OutputView;

public class RacingGame {
    private final int allRound;
    private final List<Car> participants;

    public RacingGame(int allRound, List<Car> cars) {
        this.allRound = allRound;
        this.participants = cars;
    }

    private void roundStart(List<Car> cars) {
        for (Car car : cars) {
            if (car.movedDistance() >= 4) {
                car.updateTotalDistance();
            }
        }
    }

    public List<Car> start() {
        for (int i = 0; i < allRound; i++) {
            roundStart(participants);
            OutputView.printRoundResult(participants);
        }
        return selectWinners();
    }

    public List<Car> selectWinners() {
        Collections.sort(participants);
        int winnerScore = participants.get(0).getTotalDistance();
        return participants.stream()
                .filter(participant -> participant.getTotalDistance() == winnerScore)
                .collect(Collectors.toList());
    }
}
