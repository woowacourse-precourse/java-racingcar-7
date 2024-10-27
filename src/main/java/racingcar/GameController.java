package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 게임의 Controller
 * 사용자 입력을 받고 게임 진행을 제어
 */
public class GameController {
    private final InputChecker inputChecker = new InputChecker();
    private final GameService gameService;

    /**
     * @param moveStrategy 게임에서 사용할 이동 전략
     */
    public GameController(MoveStrategy moveStrategy) {
        this.gameService = new GameService(moveStrategy);
    }

    //사용자 입력, 게임 진행, 결과 출력
    public void run() {
        List<String> carNames = inputCarNames();
        int attempts = inputAttempts();

        Game game = gameService.createGame(carNames, attempts);
        gameService.playGame(game);

        List<String> winners = game.getWinners();
        View.printWinners(winners);
    }

    /**
     * @return 입력받은 자동차 이름 리스트
     */
    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return inputChecker.checkAndParseCarNames(input);
    }

    /**
     * @return 입력받은 시도 횟수
     */
    private int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return inputChecker.checkAndParseAttempts(input);
    }
}
