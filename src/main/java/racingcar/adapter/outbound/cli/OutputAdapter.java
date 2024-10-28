package racingcar.adapter.outbound.cli;

import racingcar.application.port.outbound.OutputPort;

public class OutputAdapter implements OutputPort {
    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }
}
