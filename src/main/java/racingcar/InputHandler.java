package racingcar;

import camp.nextstep.edu.missionutils.*;

public class InputHandler {
    public static String[] InputCarsName() { // 레이싱카 n대의 이름을 한줄로 입력받아 쉼표로 구분해 반환한다.
        String carsName = Console.readLine();
        return carsName.split(",");
    }

    public static int InputRacingRound(){ // 사용자가 몇 번을 이동할 것인지를 입력받는다.
        String racingRound = Console.readLine();
        Validator.validateRacingRound(racingRound);
        return Integer.parseInt(racingRound);
    }
}
