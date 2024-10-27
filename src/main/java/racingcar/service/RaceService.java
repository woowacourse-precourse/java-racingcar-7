package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.model.CarName;
import racingcar.model.CarScores;
import racingcar.model.Distance;

public class RaceService {
    public static CarScores playGame(CarScores previousCarScores) {
        LinkedHashMap<CarName, Distance> nowScores = new LinkedHashMap<>();

        for (Map.Entry<CarName, Distance> nowCarScore : previousCarScores.getCarScores().entrySet()) {
            int randomNumber = getRandomNumber();
            Distance newDistance = moveOrStop(nowCarScore.getValue(), randomNumber);
            nowScores.put(nowCarScore.getKey(), newDistance);
            // 출력 로직 필요
        }

        return new CarScores(nowScores);
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static Distance moveOrStop(Distance previousDistance, int randomNumber) {
        if (randomNumber >= 4 && randomNumber <= 9) {
            return new Distance(previousDistance.move(randomNumber));
        }
        return previousDistance;
    }

}
