package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.policy.MovementPolicy;

public class RacingGame {

    private final List<Car> participants = new ArrayList<>();
    private int currentRound = 0;
    private final int totalRound;

    private MovementPolicy movementPolicy;

    public RacingGame(MovementPolicy movementPolicy, int totalRound) {
        this.movementPolicy = movementPolicy;
        this.totalRound = totalRound;
    }

    public void setMovementPolicy(MovementPolicy movementPolicy) {
        this.movementPolicy = movementPolicy;
    }

    public void playRound() {
        participants.forEach(movementPolicy::move);
        ++currentRound;
    }

    public void join(Car car) {
        this.participants.add(car);
    }

    public List<Car> getParticipants() {
        return new ArrayList<>(participants);
    }
}
