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
        this.participants = inputs.carNames().stream()
                .map( RacingCarIO::createCar )
                .toList();

        this.tryCnt = inputs.tryCnt();
        this.currentStatus = new HashMap<>();
    }

    public void start() {
        System.out.println( OUTPUT_MSG_A );

        for ( int stage = 0; stage < tryCnt; stage++ ) {
            currentStatus.clear();
            this.getCarLocs( currentStatus );
            RacingCarIO.printStatus( new StatusDTO( currentStatus ) );
        }
    }

    private void getCarLocs( Map<String, Integer> stageStatus ) {
        for ( Car car: this.participants ) {
            stageStatus.put( car.getName(), car.run() );
        }
    }

    public void end() {
        RacingCarIO.printResult( new StatusDTO( this.currentStatus ) );
    }
}
