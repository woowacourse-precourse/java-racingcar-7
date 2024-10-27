package racingcar.view.output.service;

import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.trynumber.domain.TryNumber;

public interface CommonOutputService {
    void carOutputView(RacingCarInfo racingCarInfo);
    void tryNumberOutputView(TryNumber tryNumber);

}
