package racingcar;

import java.util.ArrayList;

public class CreateAdvanceCount {
    // 각각의 자동차에 대한 전진 횟수를 저장하는 리스틑 생성
    public static ArrayList<Integer> createAdvanceCount(String[] cars_list){
        ArrayList<Integer> advanceCountList = new ArrayList<>();
        for (int num = 0; num < cars_list.length; num++) {
            advanceCountList.add(0);
        }
        return advanceCountList;
    }
}
