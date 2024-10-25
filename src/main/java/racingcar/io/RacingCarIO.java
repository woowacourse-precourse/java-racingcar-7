 package racingcar.io;

import static racingcar.constant.RacingCarConstant.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.dto.InputDTO;

import java.util.Arrays;
import java.util.List;

public class RacingCarIO {

    /**
     * 문제형식을 준수하여 입력값을 가져와 입력표준DTO로 전달합니다
     * @return 입력표준DTO
     * @throws IllegalArgumentException 부적절한 값이 입력된 경우
     */
    public static InputDTO getInput() {

        System.out.println( INPUT_MSG_A );
        String carNames = Console.readLine();

        List<Car> cars = Arrays.stream( carNames.split( "," ) )
                .map( Car::new )
                .toList();

        System.out.println( INPUT_MSG_B );
        int tryCnt = Integer.parseInt( Console.readLine() );

        return new InputDTO( cars, tryCnt );
    }
}
