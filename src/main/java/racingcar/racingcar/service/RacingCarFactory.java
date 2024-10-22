package racingcar.racingcar.service;

import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.util.RacingCarConvertor;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarFactory {
    public static RacingCarInfo create(String carName) {
        List<String> carNameInfo = RacingCarConvertor.splitByCommaToList(carName);
        return carNameInfo.stream()
                .map(RacingCar::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCarInfo::new));
    }
}
