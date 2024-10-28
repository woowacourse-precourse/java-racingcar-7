package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RandomRaceOrNot {
    private final List<StringBuilder> progressList = new ArrayList<>();
    private String[] carList;

    public void performRace() {
        InputCarName CarNameInput = new InputCarName();
        carList = CarNameInput.getCarList();
        int carNum = carList.length;

        for (int i = 0; i < carNum; i++) {
            progressList.add(new StringBuilder());
        }

        List<Integer> raceAmount = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            raceAmount.add(i, Randoms.pickNumberInRange(0, 9));
            if (raceAmount.get(i) >= 4) {
                progressList.get(i).append("-");
            }
        }
    }
    public List<StringBuilder> getProgressList() {
        return progressList;
    }
    public String[] getCarList() {
        return carList;
    }
}
