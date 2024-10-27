package racingGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfScore {
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

    public List<String> makeFinalWinnerList(Map<String, String> currentScore) {
        List<List<String>> finalParticipantsAndScoreList = makeFinalScoreMapToList(currentScore);
        List<String> finalWinnerList = extractFinalWinnerList(finalParticipantsAndScoreList);

        return finalWinnerList;
    }

    private List<List<String>> makeFinalScoreMapToList(Map<String, String> currentScore) {
        List<List<String>> finalParticipantsAndScoreList = new ArrayList<>();

        for (Map.Entry<String, String> entry : currentScore.entrySet()) {
            List<String> participantResult = new ArrayList<>();

            participantResult.add(entry.getKey());
            participantResult.add(entry.getValue());
            finalParticipantsAndScoreList.add(participantResult);
        }

        return finalParticipantsAndScoreList;
    }

    private List<String> extractFinalWinnerList(List<List<String>> finalParticipantsAndScoreList) {
        List<String> finalWinnerList = new ArrayList<>();
        int maxScore = findMaxScore(finalParticipantsAndScoreList);

        for (List<String> participantAndScore : finalParticipantsAndScoreList) {
            String participantName = participantAndScore.get(0);
            String stringOfScore = participantAndScore.get(1);

            if (stringOfScore.length() == maxScore) {
                finalWinnerList.add(participantName);
            }
        }

        return finalWinnerList;
    }

    private int findMaxScore(List<List<String>> finalParticipantsAndScoreList) {
        int maxScore = 0;

        for (List<String> participant : finalParticipantsAndScoreList) {
            String stringOfScore = participant.get(1);
            int thisScore = stringOfScore.length();
            maxScore = Math.max(maxScore, thisScore);
        }

        return maxScore;
    }
}
