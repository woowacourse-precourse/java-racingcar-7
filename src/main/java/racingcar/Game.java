package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String[] carArray;
    private int attemptCount;
    List<Car> carList = new ArrayList<>();


    public Game(String[] carList, int count) {
        this.carArray = carList;
        this.attemptCount = count;
    }

    public void play() {
        System.out.println("\n실행 결과");
        while (attemptCount-- > 0) {
            for (int i = 0; i < carList.size(); i++) {
                randomNumberTriggerAndStoreList(i);
            }
            printCarState();
        }
    }

    private void randomNumberTriggerAndStoreList(int i) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carList.set(i, new Car(carList.get(i).getName(), carList.get(i).getPosition() + 1));
        }
    }

    public void inputLane() {
        for (int i = 0; i < carArray.length; i++) {
            if (carArray[i].length() > 5) {
                throw new IllegalArgumentException();
            }

            carList.add(new Car(carArray[i], 0));
        }
    }

    private void printCarState() {
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
