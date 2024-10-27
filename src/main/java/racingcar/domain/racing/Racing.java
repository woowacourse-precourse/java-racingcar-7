package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;

public class Racing {
    private final List<Car> cars;
    private final long totalRounds;
    private long currentRounds;

    public Racing(RacingConfig racingConfig) {
        cars = new ArrayList<>(racingConfig.getCars());
        totalRounds = racingConfig.getRounds();
        currentRounds = 0L;
    }

    public long getTotalRounds() {
        return totalRounds;
    }

    public void playRound() {
        validatePlayableRound();
        cars.forEach(Car::move);
        currentRounds++;
    }

    public Map<String, Long> getCurrentPosition() {
        Map<String, Long> currentPosition = new LinkedHashMap<>();
        cars.forEach(car -> currentPosition.put(car.getName(), car.getPosition()));

        return currentPosition;
    }

    private void validatePlayableRound() {
        if (currentRounds >= totalRounds) {
            throw new IllegalArgumentException("진행할 수 있는 모든 라운드를 진행하였습니다.");
        }
    }
}
