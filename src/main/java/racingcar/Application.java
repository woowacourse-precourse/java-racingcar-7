package racingcar;
import racingcar.view.InputView;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        try {
            String carNamesInput = InputView.getCarNames();
            int trialCount = InputView.getTrialCount();

            RacingGame game = new RacingGame(carNamesInput, trialCount);
            game.start();
        } catch (IllegalArgumentException e) {
            // 예외 메시지 출력 없이 프로그램 종료
        }
    }
}
