package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class GameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void executeGame() {
        // 사용자 입력 받기
        List<String> carNames = inputView.getCarNamesInput();
        int gameCount = inputView.getGameCountInput();
        System.out.println();

        // 사용자 입력 정보를 토대로 게임을 실행
        GameService gameService = new GameService(gameCount, carNames);
        gameService.runGame();

        // 게임 실행 결과를 출력
        List<Map<String, Integer>> record = gameService.getRecord();
        List<String> winners = gameService.getWinners();
        outputView.printRecord(record);
        outputView.printWinners(winners);
    }
}
