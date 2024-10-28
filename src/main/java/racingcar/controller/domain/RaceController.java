package racingcar.controller.domain;

import java.util.List;

public interface RaceController {
    void run();

    List<String> splitToNames(String input);
}
