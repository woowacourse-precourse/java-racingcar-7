package racingcar.racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.racing.model.dto.RoundResult;

public class RacingGame {
    private final int allRound;
    private final List<Car> participants;

    public static RacingGame of(int allRound, List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new RacingGame(allRound, cars);
    }

    RacingGame(int allRound, List<Car> cars) {
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

    public List<List<RoundResult>> start() {
        List<List<RoundResult>> allRoundResult = new ArrayList<>();
        for (int i = 0; i < allRound; i++) {
            roundStart(participants);
            List<RoundResult> roundResults = participants.stream()
                    .map(car -> RoundResult.from(car))
                    .collect(Collectors.toList());
            allRoundResult.add(roundResults);
        }
        return allRoundResult;
    }

    public List<Car> selectWinners() {
        Collections.sort(participants);
        int winnerScore = participants.get(0).getTotalDistance();
        return participants.stream()
                .filter(participant -> participant.getTotalDistance() == winnerScore)
                .collect(Collectors.toList());
    }
}
