package racingcar.service;

import racingcar.service.validation.TimesValidation;

public class TimesParser {
    public static int parseTimes(String input) {
        int times = Integer.parseInt(input.trim());
        TimesValidation.validateZeroOrNegative(times);
        return times;
    }
}
