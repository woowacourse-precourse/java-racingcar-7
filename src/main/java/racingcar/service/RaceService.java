package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.CarName;
import racingcar.model.CarScores;
import racingcar.model.Distance;
import racingcar.view.OutputView;

public class RaceService {
    private static final int INIT_MAX = 0;

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

    public static void findFinalWinner(CarScores carScores) {
        int max = INIT_MAX;

        for (Map.Entry<CarName, Distance> nowCarScore : carScores.getCarScores().entrySet()) {
            Distance nowDistance = nowCarScore.getValue();
            max = getNewMax(max, nowDistance.getDistance());
        }

        LinkedHashMap<CarName, Distance> nowCarScores = carScores.getCarScores();
        Distance maxDistance = new Distance(max);
        List<String> lastWinners = (List<String>) nowCarScores.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxDistance))
                .map(Map.Entry::getKey)
                .map(CarName::getCarName)
                .collect(Collectors.toList());

        OutputView.printFinalWinner(lastWinners);
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

    private static int getNewMax(int max, int nowScore) {
        if (nowScore > max) {
            return nowScore;
        }
        return max;
    }
}
