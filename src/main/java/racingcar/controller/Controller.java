package racingcar.controller;

import racingcar.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final View view;

    private final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private Controller(View view) {
        this.view = view;
    }

    public static Controller run(View view) {
        return new Controller(view);
    }

    public void gameStart() {
        List<String> carNames = splitCarNames(inputCarNames());
        validateCarNames(carNames);
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
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
