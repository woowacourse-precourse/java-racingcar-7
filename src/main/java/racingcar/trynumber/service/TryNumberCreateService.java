package racingcar.trynumber.service;

import racingcar.trynumber.domain.TryNumber;

import java.util.function.Function;

public interface TryNumberCreateService {
    TryNumber create(Function<String, TryNumber> function);

}
