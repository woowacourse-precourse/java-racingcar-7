package racingcar.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import racingcar.model.policy.MovementPolicy;

public class RacingGame {

    private final Set<Car> participants = new TreeSet<>();
    private int currentRound = 0;
    private final int totalRound;

    private MovementPolicy movementPolicy;

    public RacingGame(
            MovementPolicy movementPolicy,
            int totalRound
    ) {
        this.movementPolicy = movementPolicy;
        this.totalRound = totalRound;
    }

    public int getCarId() {
        return participants.size() + 1;
    }

    public void setMovementPolicy(MovementPolicy movementPolicy) {
        this.movementPolicy = movementPolicy;
    }

    public void playRound() {
        participants.forEach(movementPolicy::move);
        ++currentRound;
    }

    public void join(Car car) {
        if (participants.contains(car)) {
            throw new IllegalStateException("자동차 이름은 중복될 수 없습니다.");
        }
        this.participants.add(car);
    }

    public List<Car> getCurrentCarState() {
        return participants.stream().map(Car::new).toList();
    }

    public List<Car> getWinners() {
        int winnerPosition = participants.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return participants.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::new)
                .toList();
    }
}
