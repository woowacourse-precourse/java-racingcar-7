package racingcar.service;

import static racingcar.controller.GameContoller.INITIAL_SCORE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameService {

    public Map<String, Integer> mapPlayerNames(List<String> playerNames) {
        Map<String, Integer> playerScoreBoard = new LinkedHashMap<>();
        playerNames.forEach((playerName) -> {
            playerScoreBoard.put(playerName, INITIAL_SCORE);
        });
        return playerScoreBoard;
    }

    public void movePlayersRandomly(Map<String, Integer> playerScoreBoard) {
        playerScoreBoard.forEach((player, score) -> {
            int randomVal = Randoms.pickNumberInRange(0, 9);
            if (randomVal >= 4) {
                playerScoreBoard.put(player, score + 1);
            }
        });
    }
}
