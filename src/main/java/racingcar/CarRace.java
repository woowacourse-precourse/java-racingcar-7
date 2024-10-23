package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class CarRace {

    public static List<String> start(String cars, int moveAttempts){
        String[] carNames = cars.split(",");

        // 입력값에 포함될 수 있는 공백 제거
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }

        Map<String, String> carMap  = new HashMap<>();
        for (int i = 0; i < carNames.length; i++) {
            carMap.put(carNames[i], "");
        }

        for (int i = 0; i < moveAttempts; i++) {
            move(carMap, carNames);
            printRaceStaus(carMap);
        }

        return new ArrayList<>(); // 임시
    }

    private static void move(Map<String, String> carMap, String[] carNames){
        for (int i = 0; i < carNames.length; i++) {
            if (canMove()) {
                carMap.put(carNames[i], carMap.get(carNames[i]) + "-");
            }
        }
    }

    private static boolean canMove(){
        return Randoms.pickNumberInRange(0, 9) > 4;
    }

    private static void printRaceStaus(Map<String, String> playerMap){
        System.out.println("실행 결과");
        for (String str : playerMap.keySet()) {
            System.out.println(str + " : " + playerMap.get(str));
        }
        System.out.println();
    }

    public static void printFinalWinners(List<String> winner){

    }
}
