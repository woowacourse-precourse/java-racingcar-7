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

        System.out.println( OUTPUT_MSG_A );

        Map<String, Integer> stageStatus = new HashMap<>();
        RacingCarIO.printResult( new StatusDTO( stageStatus ) );
    }
}
