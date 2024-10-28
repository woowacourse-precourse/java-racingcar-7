package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Race;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarService {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_CONDITION = 4;

    public String raceStart(Race race) {

        List<String> roundResults = new ArrayList<>();

        Integer round = race.getRound();
        List<Car> cars = race.getCars();

        for (int i = 0; i < round; i++) {
            roundResults.add(raceOneRound(cars));
        }

        return String.join("\n\n", roundResults);
    }

    public String raceOneRound(List<Car> cars) {

        List<String> roundResult = new ArrayList<>();

        cars.forEach(car -> {
            if (isMove()) {
                car.move();
            }
            roundResult.add(car.printPosition());
        });

        return String.join("\n", roundResult);
    }

    public String findWinner(Race race) {

        int maxPosition = getMaxPosition(race.getCars());

        return race.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public Integer getMaxPosition(List<Car> cars) {

        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public Boolean isMove() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MOVE_CONDITION;
    }
}
