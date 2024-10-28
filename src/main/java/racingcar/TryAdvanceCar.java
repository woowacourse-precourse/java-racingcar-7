package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class TryAdvanceCar {
    public static void carMove(int count, String[] cars_list, ArrayList<Integer> advanceCountList){
        // 전진을 시도할 횟수
        while (count > 0) {
            tryAdvance(cars_list,advanceCountList);
            count --;
        }
    }
    // 각 자동차의 전진 체크
    public static void tryAdvance(String[] car_list, ArrayList<Integer> advance_list) {
        for(int i = 0; i< car_list.length; i++) {
            int random_number = Randoms.pickNumberInRange(0, 9);
            if (random_number >= 4){
                advance_list.set(i, advance_list.get(i) + 1);
            }
            System.out.println(car_list[i] + " : " + "-".repeat(advance_list.get(i)));
        }
        System.out.println("\n");
    }
}

