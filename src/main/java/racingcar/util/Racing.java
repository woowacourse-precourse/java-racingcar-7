package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Racing {
    private final static Map<String, Integer> map = new HashMap<>();
    private static boolean IS_INITIAL = false;

//  [모델]
//  [] 1. 0에서 9의 수를 랜덤으로 뽑는 경우
    public static int getRamdom() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 시도 횟수만큼 각자동차 모두 시행 해야함.
    // add - 업데이트가 안됨.. 이걸 찾아서 지우고 갱신한다? ->

    public static  void isInitialRacingHashMap(ArrayList<String> carNames) {
        for (String carName : carNames) {
            map.put(carName, 0);
            IS_INITIAL = true ;
        }
    }

    public static  Map<String, Integer> racing (ArrayList<String> carNames, int tryNum) {
        if(!IS_INITIAL) {
            isInitialRacingHashMap(carNames);
        }

        if(tryNum == 0) {
            return new HashMap<>();
        }

        for (String key : carNames) {
            if (getRamdom() >= 4) {
                System.out.print(("* :"+key + ":" + map.get(key))+" ");
                map.put(key, map.get(key)+1);
            }

        }

        System.out.println();
        for (String key : map.keySet()) {
            System.out.print(key + ":" + map.get(key)+" ");
        }
        System.out.println();

        return racing(carNames, tryNum-1);

    }


//    public static ArrayList<String> judgementWhoIsWin() {
//
//
//
//        return
//    }
}
