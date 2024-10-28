package racingcar.controller;

import racingcar.model.Game;
import racingcar.util.Convertor;
import racingcar.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final View view;

    private final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    private Controller(View view) {
        this.view = view;
    }

    public static Controller run(View view) {
        return new Controller(view);
    }

    public void gameStart() {
        List<String> carNames = splitCarNames(inputCarNames());
        int round = Convertor.convertStringToInt(inputRound());

        Game game = Game.start(carNames, round);
        while (!game.isGameEnd()) {
            game.play();
            printStatus(game.getStatus());
        }
        printWinner(game.findWinners());
    }

    private void printStatus(List<String> stats) {
        for (String stat : stats) {
            view.print(stat);
        }
    }

    private void printWinner(List<String> winners) {
        view.print(FINAL_WINNER_MESSAGE + String.join(", ", winners));
    }

    private String inputRound() {
        view.print(ROUND_INPUT_MESSAGE);
        return view.read();
    }

    private String inputCarNames() {
        view.print(CAR_NAME_INPUT_MESSAGE);
        return view.read();
    }

    private List<String> splitCarNames(String carName) {
        return Arrays.stream(carName.split(","))
                .collect(Collectors.toList());
    }
}
