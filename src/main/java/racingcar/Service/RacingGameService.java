package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.Model.RacingCar;

public class RacingGameService {

    public void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void play(List<RacingCar> carList, int number) {
        IntStream.range(0, number)
            .forEach(round -> playRound(carList, round));
        determineWinners(carList);
    }

    private void playRound(List<RacingCar> carList, int round) {
        carList.forEach(RacingGameService::goOrStop);
    }

    private static void goOrStop(RacingCar car) {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        if (pickedNumber >= 4) {
            car.setScore(car.getScore() + 1);
        }
    }

    public List<RacingCar> determineWinners(List<RacingCar> carList) {
        int maxScore = carList.stream()
            .mapToInt(RacingCar::getScore)
            .max()
            .orElse(0);

        return carList.stream()
            .filter(car -> car.getScore() == maxScore)
            .collect(Collectors.toList());
    }
}
