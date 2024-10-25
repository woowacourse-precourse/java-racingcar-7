package racingcar.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.mvc.validation.input.CarNameValidator;
import racingcar.mvc.view.InputView;

public class RacingGameController {
    private InputView inputView;
    private static RacingGameController racingGameController;

    private RacingGameController() {
    }

    public static RacingGameController getInstance() {
        if (racingGameController == null) {
            return new RacingGameController();
        }

        return racingGameController;
    }

    public void setInputView(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> names = getCarNames();
    }

    private List<String> getCarNames() {
        inputView.showInitMsg();

        String nameString = inputView.getUserInput();
        nameString = nameString.trim();

        CarNameValidator.isValid(nameString);

        List<String> names = new ArrayList<>();

        for (String name : nameString.split(",")) {
            names.add(name);
        }

        return names;
    }
}
