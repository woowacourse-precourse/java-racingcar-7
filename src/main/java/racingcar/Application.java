package racingcar;
/*
* application 정리 [o]
* model(RacingGame) 구현[o]
* round별 전진 구현[o]
* */
import java.util.List;
import racingcar.view.InputView;

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
        }
        // 우승자 발표
    }
}
