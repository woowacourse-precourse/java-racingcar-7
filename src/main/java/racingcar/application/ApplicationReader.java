package racingcar.application;

import racingcar.config.RaceConfig;
import racingcar.presentation.io.Input;
import racingcar.presentation.io.View;

public class ApplicationReader {
    private static ApplicationReader INSTANCE;
    private final Input input;
    private final View view;

    private ApplicationReader(Input input, View view) {
        this.input = input;
        this.view = view;
    }

    public static ApplicationReader getInstance(Input input, View view) {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationReader(input, view);
        }
        return INSTANCE;
    }

    public RaceConfig readRaceConfig() {
        view.printCarNamesGuide();
        String carNames = input.carNames();

        view.printRoundsGuide();
        Integer rounds = Integer.parseInt(input.rounds());

        return new RaceConfig(carNames, rounds);
    }
}
