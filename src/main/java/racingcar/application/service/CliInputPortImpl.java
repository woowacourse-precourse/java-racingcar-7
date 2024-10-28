package racingcar.application.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.port.inbound.InputPort;

public class CliInputPortImpl implements InputPort {
    @Override
    public String get() {
        return Console.readLine();
    }
}
