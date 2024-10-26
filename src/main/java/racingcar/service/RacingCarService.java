package racingcar.service;

import racingcar.domain.Cars;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class RacingCarService {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    //자동차 별로 전진시키는 메소드
    public void race(Cars cars) {

        cars.getCars().entrySet().stream()
                .forEach(entry -> {
                    int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
                    String carName = entry.getKey();
                    cars.updateDistance(carName, randomNumber);
                });

    }

    //우승자를 구하는 메소드
    public List<String> getWinners(Cars cars) {
        List<String> winners = new ArrayList<>();
        int maxValue = Collections.max(cars.getCars().values());

        cars.getCars().entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return winners;
    }
}
