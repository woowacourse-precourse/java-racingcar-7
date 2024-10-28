package racingcar.domain;

import java.util.List;

public class CarMover {
    private static boolean isMoveAllowed(int randomNumber) {
        return randomNumber >= 4;
    }
}