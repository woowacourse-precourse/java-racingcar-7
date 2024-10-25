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

    private Controller(View view) {
        this.view = view;
    }

    public static Controller run(View view) {
        return new Controller(view);
    }

    public void gameStart() {
        List<String> carNames = splitCarNames(inputCarNames());
        validateCarNames(carNames);
        int round = Convertor.convertStringToInt(inputRound());
        validateRound(round);

        Game game = Game.start(carNames, round);
        while (!game.isGameEnd()) {
            game.play();
        }
    }

    private void validateRound(int round) {
        if (round < 1) {
            throw new IllegalArgumentException();
        }
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

    private void validateCarNames(List<String> carNames) {
        validateDuplicatedCarName(carNames);
        for (String carName : carNames) {
            validateCarNameLength(carName);
            validateCarNameEmpty(carName);
        }
    }

    private static void validateCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicatedCarName(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
