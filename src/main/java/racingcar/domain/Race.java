package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void start() {
        // TODO: 실제 경주 로직을 구현
    }

    public List<String> getWinners() {
        // TODO: 우승자 결정 로직 구현 후 결과 반환
        return List.of("결과"); // 임시 결과 반환
    }
}
