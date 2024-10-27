package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {
    private final InputChecker inputChecker = new InputChecker();
    private final GameService gameService;

    public GameController(MoveStrategy moveStrategy) {
        this.gameService = new GameService(moveStrategy);
    }

    public void run() {
        List<String> carNames = inputCarNames();
        int attempts = inputAttempts();

        Game game = gameService.createGame(carNames, attempts);
        gameService.playGame(game);

        List<String> winners = game.getWinners();
        View.printWinners(winners);
    }

    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return inputChecker.checkAndParseCarNames(input);
    }

    private int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return inputChecker.checkAndParseAttempts(input);
    }
}
