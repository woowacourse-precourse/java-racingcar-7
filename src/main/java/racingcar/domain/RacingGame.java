package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarStatusDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> racingCars;
    private final int round;

    public RacingGame(List<Car> cars, int round) {
        this.racingCars = cars;
        this.round = round;
    }

    public Map<Integer, List<CarStatusDto>> raceAllRound() {
        Map<Integer, List<CarStatusDto>> roundResults = new HashMap<>();
        for (int i = 1; i <= round; i++) {
            raceRound();
            roundResults.put(i, getCurrentRoundStatus());
        }
        return roundResults;
    }

    private void raceRound() {
        racingCars.forEach(car -> car.move(getMoveCondition()));
    }

    private List<CarStatusDto> getCurrentRoundStatus() {
        return racingCars.stream()
                .map(car -> new CarStatusDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    private int getMoveCondition() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
