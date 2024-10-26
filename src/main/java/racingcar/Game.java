package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Game {

    public List<RacingCar> init(List<String> carNames) {
        return initCars(carNames);
    }

    public List<RacingCar> initCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(RacingCar.createRacingCar(name));
        }
        return racingCars;
    }

    public List<RacingCar> executeLogic(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            Integer randomNumber = GameUtil.randomNumber();
            if (GameUtil.isForward(randomNumber)) {
                racingCar.addScore();
            }
        }
        return racingCars;
    }

    public List<String> selectWinner(List<RacingCar> racingCars) {
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
