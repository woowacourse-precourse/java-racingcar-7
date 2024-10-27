package racingcar.interfaces.input;

import java.util.List;

public interface InputHandler {

    List<String> getCarNames();

    int getRaceCount();

    String readLine();
}
