package racingcar;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // scanner
        List<String> carNames = Input.inputCarNames();
        int round = Input.inputRound();

        RacingGame racingGame = new RacingGame(carNames);

        // 레이싱 게임 생성 및 플레이
        for (int i = 0; i < round; i++) {
            racingGame.playNextRound();
            RoundStatus roundStatus = racingGame.getRoundStatus();
            Output.showRound(roundStatus);
        }

        WinnerChoicer winnerChoicer = new WinnerChoicer(racingGame.getRoundStatus().getCarStatusList());
        Output.showWinner(winnerChoicer);
    }
}
