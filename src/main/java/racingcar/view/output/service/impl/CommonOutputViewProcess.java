package racingcar.view.output.service.impl;

import racingcar.constant.separator.SeparatorConstant;
import racingcar.racingcar.domain.RacingCar;
import racingcar.racingcar.dto.RacingCarInfo;
import racingcar.trynumber.domain.TryNumber;
import racingcar.view.output.service.CommonOutputService;

import java.util.stream.Collectors;

public class CommonOutputViewProcess implements CommonOutputService {
    @Override
    public void carOutputView(RacingCarInfo racingCarInfo) {
        String racingCarInfoToString = racingCarInfo.getRacingCarInfo().stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(SeparatorConstant.COMMA));
        System.out.println(racingCarInfoToString);
    }

    @Override
    public void tryNumberOutputView(TryNumber tryNumber) {
        System.out.println(tryNumber);
        nextLine();
    }
    private void nextLine() {
        System.out.println();
    }
}

