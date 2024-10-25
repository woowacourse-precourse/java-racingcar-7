package racingcar.controller;

import racingcar.dto.RacingCarDTO;
import racingcar.service.RacingCarServiceImpl;
import racingcar.util.RacingCarNameValidator;
import racingcar.util.RacingNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.service.RacingCarServiceImpl.*;
import static racingcar.util.RacingCarNameValidator.*;
import static racingcar.util.RacingNumberValidator.*;
import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingCarController {
    public static void run(){

        // 사용자의 이름을 입력받고, 올바른지 확인
        String racingCarNameString = getRacingCarNameFromUser();
        checkRacingCarNameListIsAvailable(racingCarNameString);

        // 사용자의 실행 횟수를 입력받고, 올바른지 확인
        String numberOfRacingString = getNumberOfRaceFromUser();
        checkNumberOfRacingIsAvailable(numberOfRacingString);

        // DTO 인스턴스 생성
        RacingCarDTO racingCarDTO = new RacingCarDTO(racingCarNameString, numberOfRacingString);

        // 사용자가 입력한 실행 횟수를 기반으로 반복 실행
        for (int i = 0; i < racingCarDTO.getNumberOfRacing(); i++) {
            moveRacingCarByRandom(racingCarDTO);
            printEachDistanceByRandomMovement(racingCarDTO);
        }

        // 최종 우승자 출력
        printWinnerOfRacing(racingCarDTO);

    }
}
