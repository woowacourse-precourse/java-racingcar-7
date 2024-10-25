package racingcar.adapters.output;

import racingcar.application.dto.response.Response;
import racingcar.application.port.output.OutputPort;

public class CliOutputAdapter implements OutputPort {

    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void writeNewLine() {
        System.out.println();
    }

    @Override
    public void writeResponse(Response response) {
        System.out.println(response);
    }
}
