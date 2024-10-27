package racingcar.view;

import static racingcar.view.ViewMessages.REQUIRE_CARS_NAME;
import static racingcar.view.ViewMessages.REQUIRE_NUMBER_OF_ATTEMPTS;

public class OutputView {
    public static void requireCarsName(){
        System.out.println(REQUIRE_CARS_NAME);
    }

    public static void requireNumberOfAttempts(){
        System.out.println(REQUIRE_NUMBER_OF_ATTEMPTS);
    }
}