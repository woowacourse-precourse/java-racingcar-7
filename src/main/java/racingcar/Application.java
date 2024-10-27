package racingcar;

import java.util.*;

import racingcar.domain.Car;
import racingcar.dto.InputDTO;
import racingcar.dto.StatusDTO;
import racingcar.io.RacingCarIO;


import static racingcar.constant.RacingCarConstant.OUTPUT_MSG_A;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputDTO inputs = RacingCarIO.getInput();
        List<Car> cars = inputs.cars();
        int tryCnt = inputs.tryCnt();

        System.out.println( OUTPUT_MSG_A );

        Map<String, Integer> stageStatus = new HashMap<>();
        for ( int stage = 0; stage < tryCnt; stage++ ) {
            stageStatus.clear();
            for ( Car car: cars ) {
                stageStatus.put( car.getName(), car.run() );
            }
            RacingCarIO.printStatus( new StatusDTO( stageStatus ) );
        }

        RacingCarIO.printResult( new StatusDTO( stageStatus ) );
    }
}
