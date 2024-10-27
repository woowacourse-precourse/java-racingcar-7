package racingcar.config;

import racingcar.io.*;
import racingcar.io.view.RaceInputView;
import racingcar.io.view.View;
import racingcar.io.view.RacePositionConsoleView;
import racingcar.io.view.WinnerConsoleView;

public class ConsoleCarRaceConfig extends CarRaceConfig {
    private static final View OUT_PUT_VIEW = new View(RacePositionConsoleView.getInstance(), WinnerConsoleView.getInstance(), RaceInputView.getInstance());
    private static final InputReceiver INPUT_RECEIVER = new ConsoleInputReceiver();
    private static final ConsoleCarRaceConfig INSTANCE = new ConsoleCarRaceConfig(OUT_PUT_VIEW, INPUT_RECEIVER);

    private ConsoleCarRaceConfig(View view, InputReceiver inputReceiver) {
        super(view, inputReceiver);
    }

    public static ConsoleCarRaceConfig getInstance() {
        return INSTANCE;
    }
}
