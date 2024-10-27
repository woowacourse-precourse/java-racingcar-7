package racingcar.controller;

import java.util.List;
import racingcar.domain.MoveCount;
import racingcar.dto.GameResultDto;
import racingcar.service.GameService;
import racingcar.utility.Calculator;
import racingcar.view.OutputView;

public class GameController {
    private final GameService gameService;
    private final OutputView outputView;

    public GameController(GameService gameService, OutputView outputView) {
        this.gameService = gameService;
        this.outputView = outputView;
    }

    public void executeRace(MoveCount moveCount) {
        showStartMessage();
        GameResultDto gameResultDto = null;

        while (moveCount.canMove()) {
            moveCars(moveCount);
            gameResultDto = getGameResult();
            showCurrentStatus(gameResultDto);
        }

        displayFinalResults(gameResultDto);
    }

    private void moveCars(MoveCount moveCount) {
        gameService.moveCarsRandomly();
        moveCount.decreaseCount();
    }

    /**
     * 게임의 현재 결과를 가져옵니다.
     *
     * @return 현재 게임 상태를 담은 DTO
     */
    private GameResultDto getGameResult() {
        return gameService.getGameData();
    }

    private void showCurrentStatus(GameResultDto gameResultDto) {
        outputView.showCurrentStatus(gameResultDto);
    }

    private void showStartMessage() {
        outputView.showStartMessage();
    }

    /**
     * 최종 게임 결과를 계산하고 출력합니다.
     *
     * @param gameResultDto 최종 게임 상태를 담은 DTO
     */
    private void displayFinalResults(GameResultDto gameResultDto) {
        validateGameResult(gameResultDto);
        List<String> winners = Calculator.findWinners(gameResultDto);
        outputView.showWinner(winners);
    }

    private void validateGameResult(GameResultDto gameResultDto) {
        if (gameResultDto == null) {
            throw new IllegalArgumentException("게임 결과가 유효하지 않습니다.");
        }
    }
}
