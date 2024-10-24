package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class RacingCarController {

    private List<String> nameParse(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
