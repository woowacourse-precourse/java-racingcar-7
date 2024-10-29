package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputController {
    public static List<String> getName(){
        String inputCarNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputCarNames.split(",", -1));
        return carNames;
    }

    public static Integer getNum(){
        int tryNum = Integer.parseInt(Console.readLine());
        return tryNum;
    }

    public static void checkNameLimit(List<String> carNames){
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

}
