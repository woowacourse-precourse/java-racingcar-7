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
import static racingcar.view.InputView.getNumberOfRaceFromUser;
import static racingcar.view.OutputView.*;

public class RacingCarController {
    public static void run(){

        // DTO 객체 생성 (View - Controller - Util)
        RacingCarDTO racingCarDTO = new RacingCarDTO(getRacingCarNameFromUserInController(), getNumberOfRaceFromUser());

        // N회차 반복 실행 (Controller - Service)
        RaceNTimeInController(racingCarDTO);

        // 최종 우승자 출력 (Controller - View)
        printWinnerOfRacing(racingCarDTO);

    }

    // 사용자에게 이름을 입력받고, 올바른지 확인
    static String getRacingCarNameFromUserInController(){
        String racingCarNameString = getRacingCarNameFromUser();
        checkRacingCarNameListIsAvailable(racingCarNameString);
        return racingCarNameString;
    }

    // 사용자에게 실행 횟수를 입력받고, 올바른지 확인
    static String getNumberOfRaceFromUserInController(){
        String numberOfRacingString = getNumberOfRaceFromUser();
        checkNumberOfRacingIsAvailable(numberOfRacingString);
        return numberOfRacingString;
    }

    // 사용자가 입력한 실행 횟수를 기반으로 반복 실행
    static void RaceNTimeInController(RacingCarDTO racingCarDTO){
        for (int i = 0; i < racingCarDTO.getNumberOfRacing(); i++) {
            moveRacingCarByRandom(racingCarDTO);
            printEachDistanceByRandomMovement(racingCarDTO);
        }
    }
}
