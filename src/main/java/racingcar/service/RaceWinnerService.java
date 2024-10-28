package racingcar.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.CarName;
import racingcar.model.CarScores;
import racingcar.model.Distance;
import racingcar.view.OutputView;

public class RaceWinnerService {
    private static final int INIT_MAX_TO_ZERO = 0;

    public static void findLastWinner(CarScores carScores) {
        int max = INIT_MAX_TO_ZERO;

        for (Map.Entry<CarName, Distance> nowCarScore : carScores.getCarScores().entrySet()) {
            Distance nowDistance = nowCarScore.getValue();
            max = getNewMax(max, nowDistance.getDistance());
        }

        LinkedHashMap<CarName, Distance> nowCarScores = carScores.getCarScores();
        Distance maxDistance = new Distance(max);
        List<String> lastWinners = nowCarScores.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxDistance))
                .map(Map.Entry::getKey)
                .map(CarName::getCarName)
                .collect(Collectors.toList());

        OutputView.printFinalWinner(lastWinners);
    }

    private static int getNewMax(int max, int nowScore) {
        return Math.max(nowScore, max);
    }
}
