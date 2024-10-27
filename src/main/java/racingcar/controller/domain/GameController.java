package racingcar.controller.domain;

import java.util.List;

public interface GameController {
    void run();

    List<String> process(String input);
}
