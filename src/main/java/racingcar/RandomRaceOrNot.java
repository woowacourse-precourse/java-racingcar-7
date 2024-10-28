package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RandomRaceOrNot {
    private final List<StringBuilder> progressList = new ArrayList<>();
    private String[] carList;
    private int raceAmount;

    public void performRace(String[] carList, int raceAmount) {
        this.carList = carList;
        this.raceAmount = raceAmount;

        int carNum = carList.length;

        for (int i = 0; i < carNum; i++) {
            progressList.add(new StringBuilder());
        }

        for (int t = 0; t < raceAmount; t++) {
            for (int i = 0; i < carNum; i++) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                if (randomValue >= 4) {
                    progressList.get(i).append("-");
                }
            }
            printCurrentResult();
        }
    }

    private void printCurrentResult() {
        for (int i = 0; i < carList.length; i++) {
            System.out.println(carList[i] + " : " + progressList.get(i).toString());
        }
        System.out.println();
    }

    public List<StringBuilder> getProgressList() {
        return progressList;
    }
    public String[] getCarList() {
        return carList;
    }
}
