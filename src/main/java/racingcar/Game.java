package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Game {
    private final Integer round;
    private final List<RacingCar> racingCars;

    public Game(Integer round) {
        this.round = round;
        this.racingCars = new ArrayList<>();
    }

    public Integer getRound() {
        return round;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void init(List<String> carNames) {
        initCars(carNames);
    }

    public void initCars(List<String> carNames) {
        for (String name : carNames) {
            racingCars.add(RacingCar.createRacingCar(name));
        }
    }

    public List<RacingCar> executeLogic() {
        for (RacingCar racingCar : racingCars) {
            Integer randomNumber = GameUtil.randomNumber();
            if (GameUtil.isForward(randomNumber)) {
                racingCar.addScore();
            }
        }
        return racingCars;
    }

    public List<String> selectWinner() {
        Optional<RacingCar> firstWinner = racingCars.stream().max(Comparator.comparing(RacingCar::getScore));

        if (firstWinner.isEmpty()) {
            throw new IllegalArgumentException("승자가 없습니다.");
        }

        Integer maxScore = firstWinner.get().getScore();

        List<String> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getScore().equals(maxScore)) {
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }
}
