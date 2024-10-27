package racingcar;
/*
* 우승자 발표 클래스 생성 및 구현[o]
* */
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.RoundProcessResultView;
import racingcar.view.WinnerView;

public class Application {
    public static void main(String[] args) {
        // 입력
        List<String> carNames = InputView.readNamesInput();
        int numberRounds = InputView.readMoveNumInput();
        // 객체 생성 및 초기화
        RacingGame racingGame = new RacingGame(carNames);
        // 레이싱 게임
        for(int round = 0; round < numberRounds; round++){
            // 라운드별 게임
            racingGame.raceOneRound();
            RoundProcessResultView.displayRoundResult(racingGame.getCars());
        }
        // 우승자 발표
        List<Racingcar> winners = racingGame.finalWinner();
        WinnerView.showWinners(winners);
    }
}
