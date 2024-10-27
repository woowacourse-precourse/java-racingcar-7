package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RaceCarServiceImpl implements RaceCarService {
    private final List<Car> carNames;
    private final int gameRound;

    private final int START_RANGE = 1;
    private final int END_RANGE = 9;


    public RaceCarServiceImpl(List<Car> carNames, int gameRound) {
        this.carNames = carNames;
        this.gameRound = gameRound;
    }

    @Override
    public void playEachRound() {
        for (int i = 0; i < gameRound; i++) {
            for (Car car : carNames) {
                int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
                car.printMyTrace(randomNumber);
            }
            System.out.println();
        }
    }

    @Override
    public String announceWinner() {
        final int max_dist = carNames.stream()
                .map(Car::getDist)
                .max(Comparator.naturalOrder())
                .orElse(0);

        if (max_dist == 0) {
            throw new IllegalArgumentException("[ERROR] 전진 거리가 모두 0이므로 우승자가 없습니다.");
        }

        return carNames.stream()
                .filter(car -> max_dist == car.getDist())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
