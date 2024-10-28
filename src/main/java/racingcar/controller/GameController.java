package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.service.GameService;
import racingcar.view.InputGameView;
import racingcar.view.ResultGameView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final GameService gameService=new GameService();
    public void startGame(){
        List<String> carNames= InputGameView.carNames();
        int tryNum=InputGameView.tryNum();

        RacingGame game= gameService.createGame(carNames,tryNum);
        System.out.print("\n실행 결과");

        while (!game.isFinished()){
            gameService.playGame(game);
            ResultGameView.midPrint(game.getCars());
        }

        ResultGameView.finalPrint(game.getWinner());

    }
}
