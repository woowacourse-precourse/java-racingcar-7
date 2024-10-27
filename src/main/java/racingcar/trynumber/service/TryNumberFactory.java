package racingcar.trynumber.service;

import racingcar.trynumber.domain.TryNumber;
import racingcar.util.ConvertorProcess;

public class TryNumberFactory {
    public static TryNumber create(String input) {
        int count = ConvertorProcess.stringToInt(input);
        return TryNumber.of(count);
    }
}
