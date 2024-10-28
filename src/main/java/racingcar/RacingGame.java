package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private int MINIMUM_ROUND = 1;
    private int MINIMUM_NUMBER_OF_CAR = 2;

    private final int round;
    private List<Car> racingCars;
    private List<RacingGameRecord> records = new ArrayList<>();

    public RacingGame(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int round) {
        if (MINIMUM_ROUND > round) {
            throw new IllegalArgumentException("경주에 참여하려면 최소 1라운드 이상 설정해야 해요.");
        }

    }

    public void apply(List<Car> racingCars) {
        validateRacingCars(racingCars);
        this.racingCars = racingCars;
    }

    private void validateRacingCars(List<Car> racingCars) {
        if (MINIMUM_NUMBER_OF_CAR > racingCars.size()) {
            throw new IllegalArgumentException("경주에 참여할 자동차는 최소 2대 이상 있어야 해요.");
        }
    }

    public void start() {
        int count = 0;
        while (count++ < round) {
            int currentCount = count;
            racingCars
                    .forEach(car -> {
                        int distance = Randoms.pickNumberInRange(0, 9);
                        car.moveForward(distance);
                        this.records.add(new RacingGameRecord(currentCount, distance, car));
                    });
        }
    }

    public List<Car> getWinners() {
        Car winner = racingCars.stream()
                .max(Comparator.comparingInt(Car::currentLocation))
                .orElseThrow(() -> new IllegalArgumentException("우승자가 없어요."));

        return racingCars.stream()
                .filter(car -> winner.currentLocation() == car.currentLocation())
                .collect(Collectors.toList());
    }

    public List<RacingGameRecord> getRecords() {
        return this.records;
    }
}
