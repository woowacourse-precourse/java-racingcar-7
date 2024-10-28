package racing;
import racing.game.RacingController;

public class Application {
    public static void main(String[] args) {

        // todo : 관심사 분리
        RacingController racingController = new RacingController();
        racingController.startRacingGame();
    }
}
