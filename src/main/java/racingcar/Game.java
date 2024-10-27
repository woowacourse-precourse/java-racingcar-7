package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final private String[] carNameArray;
    private int attemptCount;
    List<Car> carList = new ArrayList<>();


    public Game(String[] carNameArray, int attemptCount) {
        this.carNameArray = carNameArray;
        this.attemptCount = attemptCount;
    }

    public void play() {
        System.out.println("\n실행 결과");
        while (attemptCount-- > 0) {
            for (int i = 0; i < carList.size(); i++) {
                randomNumberTriggerAndStoreList(i);
            }
            printCarPosition();
        }
    }

    private void randomNumberTriggerAndStoreList(int i) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carList.set(i, new Car(carList.get(i).getName(), carList.get(i).getPosition() + 1));
        }
    }

    public void addArrayToList() {
        for (int i = 0; i < carNameArray.length; i++) {
            if (carNameArray[i].length() > 5) {
                throw new IllegalArgumentException();
            }

            carList.add(new Car(carNameArray[i], 0));
        }
    }

    private void printCarPosition() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName() + " : ");

            for (int j = 0; j < carList.get(i).getPosition(); j++) {
                System.out.print("-");
            }

            System.out.println();
        }
        System.out.print("\n");
    }
}
