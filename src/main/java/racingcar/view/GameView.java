package racingcar.view;

import racingcar.domain.Game;
import racingcar.service.GameService;

public class GameView {
    private static Game game;
    private static GameService gameService;

    public GameView(GameService gameService) {
        this.gameService = gameService;
    }

    public static void displayGameProgress(int count, GameService gameService) {
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            System.out.println(gameService.runCarGame());
        }
    }
}
