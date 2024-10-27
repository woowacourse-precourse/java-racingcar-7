package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.InputDTO;
import racingcar.dto.StatusDTO;
import racingcar.io.RacingCarIO;

import java.util.*;

import static racingcar.constant.RacingCarConstant.OUTPUT_MSG_A;
import static racingcar.constant.RacingCarError.INVALID_INPUT_ERR;

public class Race {
    private List<Car> participants;
    private int tryCnt;
    private Map<String, Integer> currentStatus;

    public Race( InputDTO inputs ) {
        this.participants = inputs.cars();
        this.tryCnt = inputs.tryCnt();
        this.currentStatus = new HashMap<>();
    }
}
