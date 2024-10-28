package racing;
import racing.game.RacingController;

public class Application {
    public static void main(String[] args) {

        // todo : n회, 수행 레이싱 참가 차량 k개에 대해서 구현
        RacingController racingController = new RacingController();
        racingController.startRacingGame();
    }
}
