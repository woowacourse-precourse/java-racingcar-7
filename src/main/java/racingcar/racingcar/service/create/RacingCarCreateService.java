package racingcar.racingcar.service.create;

import racingcar.racingcar.dto.RacingCarInfo;

import java.util.function.Function;

public interface RacingCarCreateService {
    RacingCarInfo create(Function<String, RacingCarInfo> function);
}
