package racingcar;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // scanner
        Input input = new Input();
        List<String> carNames = input.inputCarNames();
        int round = input.inputRound();

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
