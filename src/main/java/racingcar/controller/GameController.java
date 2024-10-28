package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.game.GameResult;
import racingcar.dto.request.GameStartRequest;
import racingcar.dto.response.Winners;
import racingcar.exception.InputException;
import racingcar.exception.game.GameException;
import racingcar.service.GameService;

public class GameController {
    private static final String READ_NAMES_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_ROUNDS_MESSAGE =
            "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_HEADER = "\n실행 결과";
    private static final String WINNERS_FORMAT = "최종 우승자 : %s";
    private static final String NAME_DELIMITER = ",";
    private static final String FORWARD_SYMBOL = "-";
    private static final String POSITION_FORMAT = "%s : %s%n";

    private final GameService gameService;
    private final Scanner scanner;

    public GameController(GameService gameService) {
        this.gameService = gameService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        try {
            GameStartRequest request = createRequest();
            executeGame(request);
        } catch (GameException e) {
            System.out.println(e.getMessage());
        }
    }

    private GameStartRequest createRequest() {
        List<String> names = readNames();
        int rounds = readRounds();
        return new GameStartRequest(names, rounds);
    }

    private List<String> readNames() {
        System.out.println(READ_NAMES_MESSAGE);
        String input = scanner.nextLine();
        return parseNames(input);
    }

    private List<String> parseNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InputException.InvalidNameFormatException();
        }
        return Arrays.asList(input.split(NAME_DELIMITER));
    }

    private int readRounds() {
        System.out.println(READ_ROUNDS_MESSAGE);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InputException.InvalidRoundInputException();
        }
    }

    private void executeGame(GameStartRequest request) {
        gameService.initialize(request);
        playRounds();
        announceWinners();
    }

    private void playRounds() {
        System.out.println(RESULT_HEADER);

        while (gameService.hasNextRound()) {
            GameResult result = gameService.playRound();
            displayResult(result);
        }
    }

    private void displayResult(GameResult result) {
        result.results().forEach(this::displayStatus);
        System.out.println();
    }

    private void displayStatus(GameResult.PlayerResult result) {
        String position = FORWARD_SYMBOL.repeat(result.position());
        System.out.printf(POSITION_FORMAT, result.name(), position);
    }

    private void announceWinners() {
        Winners winners = gameService.getWinners();
        System.out.printf("최종 우승자 : %s%n", winners.getNames());
    }
}