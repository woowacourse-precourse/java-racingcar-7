package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Racing {
    private static Map<String, Integer> map = new HashMap<>();
    public static boolean IS_INITIAL = false;
    private static String MESSAGE = "실행 결과";


    public static int getRamdom() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void isInitialRacingHashMap(ArrayList<String> carNames) {
        map.clear();
        for (String carName : carNames) {
            map.put(carName, 0);
            IS_INITIAL = true;
        }
    }

    public static Map<String, Integer> racing(ArrayList<String> carNames, int tryNum) {

        if (tryNum == 0) {
            return new HashMap<>();
        }

        if (!IS_INITIAL) {
            isInitialRacingHashMap(carNames);
            System.out.print(MESSAGE);
        }

        for (String key : carNames) {
            if (getRamdom() >= 4) {
                map.put(key, map.get(key)+1);
            }
        }

        System.out.println();
        printCurrentStatus(map);

        return racing(carNames, tryNum - 1);
    }


    public static void printCurrentStatus(Map<String, Integer> map) {

        for (String key : map.keySet()) {
            System.out.print(key + " : ");
            printCurrentStatusHipen(map.get(key));
        }
    }

    public static void printCurrentStatusHipen(Integer count) {

        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    public static ArrayList<String> judgementWhoIsWin() {

        int minVal = -1;
        ArrayList<String> winnerArray = new ArrayList<>();

        for (String temp : map.keySet()) {
            int maxVal = map.get(temp);

            if (maxVal > minVal) {
                minVal = maxVal;
            }
        }

        for (String temp : map.keySet()) {
            if (minVal == map.get(temp)) {
                winnerArray.add(temp);
            }
        }
        return winnerArray;
    }
}
