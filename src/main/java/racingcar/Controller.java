package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Player;
import racingcar.domain.RacingGame;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {
        // 경주 게임에 필요한 정보 사용자 입력 받기
        List<String> carNames = inputView.enterCarNames();
        int roundCount = inputView.enterRoundCount();

        // 플레이어 정보 생성
        List<Player> players = new ArrayList<>();
        for (String carName : carNames) {
            players.add(Player.createPlayer(carName));
        }

        // 게임 진행
        RacingGame racingGame = new RacingGame(players, roundCount);
        racingGame.play();

        // 결과 출력
        outputView.printRoundResults(racingGame.getRoundResults());
        outputView.printWinner(racingGame.getWinners());
    }
}
