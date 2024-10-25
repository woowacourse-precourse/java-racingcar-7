package racingcar.config;

import racingcar.io.*;
import racingcar.io.view.OutPutView;
import racingcar.io.view.RacePositionConsoleView;
import racingcar.io.view.WinnerConsoleView;

public class ConsoleCarRaceConfig extends CarRaceConfig {
    private static final OutPutView OUT_PUT_VIEW = new OutPutView(RacePositionConsoleView.getInstance(), WinnerConsoleView.getInstance());
    private static final InputReceiver INPUT_RECEIVER = new ConsoleInputReceiver();
    private static final ConsoleCarRaceConfig INSTANCE = new ConsoleCarRaceConfig(OUT_PUT_VIEW, INPUT_RECEIVER);

    private ConsoleCarRaceConfig(OutPutView outPutView, InputReceiver inputReceiver) {
        super(outPutView, inputReceiver);
    }

    public static ConsoleCarRaceConfig getInstance() {
        return INSTANCE;
    }
}
