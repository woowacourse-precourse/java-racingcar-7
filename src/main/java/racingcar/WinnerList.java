package racingcar;

import java.util.ArrayList;

public class WinnerList {
    // 최종 우승자 리스트 반환
    public static ArrayList<String> winnerList(ArrayList<Integer> advanceCountList, String[] cars_list, int max_advance_count){
        ArrayList<String> winnerList = new ArrayList<>();

        for (int i =0; i < cars_list.length; i++) {
            if (advanceCountList.get(i) == max_advance_count) {
                winnerList.add(cars_list[i]);
            }
        }
        return winnerList;
    }
}
