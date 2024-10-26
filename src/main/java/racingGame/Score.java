package racingGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    public Map<String, String> initializeScore(List<String> participateCarList) {
        Map<String, String> initialScore = new HashMap<>();

        for (int carIndex = 0; carIndex < participateCarList.size(); carIndex++) {
            initialScore.put(participateCarList.get(carIndex), "");
        }

        return initialScore;
    }

    public Map<String, String> resultOfOneGameScore(List<String> oneGameMoveCarList, Map<String, String> currentScore) {
        for (int moveCarIndex = 0; moveCarIndex < oneGameMoveCarList.size(); moveCarIndex++) {
            String moveCarName = oneGameMoveCarList.get(moveCarIndex);
            String thisCarScore = currentScore.get(moveCarName);

            // "-" 상수화 작업 필요
            thisCarScore += "-";

            currentScore.put(moveCarName, thisCarScore);
        }

        return currentScore;
    }
}
