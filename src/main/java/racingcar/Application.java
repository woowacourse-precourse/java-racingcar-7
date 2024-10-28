package racingcar;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 받기
        String[] carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();

        // 게임 시작
        RacingGame game = new RacingGame(carNames, rounds);
        game.start();
    }
}


