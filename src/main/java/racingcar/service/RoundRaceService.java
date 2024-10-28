package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.model.CarName;
import racingcar.model.CarScores;
import racingcar.model.Distance;
import racingcar.view.OutputView;

public class RoundRaceService {
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;
    private static final int MIN_MOVE_DISTANCE = 4;
    private static final int MAX_MOVE_DISTANCE = 9;

    public static CarScores playGame(CarScores previousCarScores) {
        LinkedHashMap<CarName, Distance> nowScores = new LinkedHashMap<>();

        for (Map.Entry<CarName, Distance> nowCarScore : previousCarScores.getCarScores().entrySet()) {
            int randomNumber = getRandomNumber();
            Distance newDistance = moveOrStop(nowCarScore.getValue(), randomNumber);
            nowScores.put(nowCarScore.getKey(), newDistance);
            OutputView.printNowCarScore(nowCarScore.getKey(), newDistance);
        }

        return new CarScores(nowScores);
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
    }

    private static Distance moveOrStop(Distance previousDistance, int randomNumber) {
        if (randomNumber >= MIN_MOVE_DISTANCE && randomNumber <= MAX_MOVE_DISTANCE) {
            return new Distance(previousDistance.move(randomNumber));
        }
        return previousDistance;
    }
}
