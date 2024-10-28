package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RandomRaceOrNot {
    public static void main(String[] args) {
        InputCarName CarNameInput = new InputCarName();
        String[] CarList = CarNameInput.getCarList();
        int carNum = CarList.length;

        List<StringBuilder> progressList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            progressList.add(new StringBuilder());
        }
        List<Integer> raceAmount = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            raceAmount.add(i, Randoms.pickNumberInRange(0, 9));

            if (raceAmount.get(i) >= 4){
                progressList.get(i).append("-");
            }
        }



    }
}
