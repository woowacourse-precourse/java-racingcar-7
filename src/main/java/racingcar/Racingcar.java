package racingcar;
/*
* TDD도전[o]
* */
/*
* HashMap사용
* */

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;

public class Racingcar {
    // 자동차 이름 입력받기
    public static List<String> readNamesInput(String nameInput){
        //String nameInput = Console.readLine();
        List<String> names = List.of(nameInput.split(","));
        return names;
    }
    // 총 이동횟수 입력받기
    public static int readNumInput(int numInput){
        // int numInput = Integer.parseInt(Console.readLine()); // 나중에 분리
        return numInput;
    }
    // 랜덤 정수 받기
    public static int getRandomnum(){
        return Randoms.pickNumberInRange(0, 9);
    }
    // 4이상일때 자동차 이름에 따라 전진 출력
    public static String goCar(String carName, int randomNumber) {
        if (randomNumber >= 4) {
            return carName + " : " + "-";
        }
        return "no";
    }

}
