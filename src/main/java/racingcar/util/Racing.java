package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Racing {
    public static boolean IS_INITIAL = false;
    private static Map<String, Integer> map = new HashMap<>();
    private static ArrayList<String> winnerArray = new ArrayList<>();
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
           increaseCar(key);
        }

        System.out.println();
        printCurrentStatus(map);

        return racing(carNames, tryNum - 1);
    }

    private static void increaseCar( String key) {
        if(getRamdom() >= 4) {
            map.put(key, map.get(key)+1);
        }
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

        winnerArray.clear();
        for (String name : map.keySet()) {
            int maxVal = map.get(name);

            minVal = Math.max(maxVal,minVal);
        }

        for (String name : map.keySet()) {
            addArray(map.get(name),name,minVal);
        }

        return winnerArray;
    }


    private static void addArray(int getVal, String name, int minVal) {

        if(minVal == getVal) {
            winnerArray.add(name);
        }
    }

}

