package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.policy.MovementPolicy;

public class RacingGame {

    private final List<Car> participants = new ArrayList<>();
    private int currentTryCount = 0;
    private final int totalTryCount;

    private MovementPolicy movementPolicy;

    public RacingGame(
            MovementPolicy movementPolicy,
            int totalTryCount
    ) {
        this.movementPolicy = movementPolicy;
        this.totalTryCount = totalTryCount;
    }

    public void setMovementPolicy(MovementPolicy movementPolicy) {
        this.movementPolicy = movementPolicy;
    }

    public void tryRound() {
        if (currentTryCount >= totalTryCount) {
            throw new IllegalStateException("모든 라운드를 진행하였습니다");
        }
        participants.forEach(movementPolicy::move);
        ++currentTryCount;
    }

    public void join(List<Car> cars) {
        cars.forEach(this::join);
    }

    public void join(Car car) {
        if (participants.contains(car)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
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
