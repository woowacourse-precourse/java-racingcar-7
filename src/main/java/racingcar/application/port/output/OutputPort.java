package racingcar.application.port.output;

import racingcar.application.dto.response.Response;

public interface OutputPort {
    void writeMessage(String message);
    void writeNewLine();
    void writeResponse(Response response);
}
