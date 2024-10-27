package racingcar.racingcar.service;

import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.racingcar.validator.name.NameValidator;
import racingcar.util.ConvertorProcess;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarFactory {
    public static RacingCarInfo create(String carName) {
        List<String> carNameInfo = ConvertorProcess.splitByCommaToList(carName);
        RacingCarInfo racingCarInfo = carNameInfo.stream()
                .map(RacingCar::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCarInfo::new));
        NameValidator.isDuplicateName(racingCarInfo);
        return racingCarInfo;
    }
}
