package racingcar.factory;

import racingcar.Race;
import racingcar.handler.InputHandlerImpl;
import racingcar.handler.OutputHandlerImpl;

public class RaceFactory {
    public static Race create() {
        return new Race(new InputHandlerImpl(), new OutputHandlerImpl());
    }
}
