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
                if (Randoms.pickNumberInRange(1, 9) > 4) {
                    carList.set(i, new Car(carList.get(i).getName(), carList.get(i).getPosition() + 1));
                }
            }

            printCarState();
        }
    }


    // 경주에 참여하는 차를 리스트에 넣음
    public void inputLane() {
        for (int i = 0; i < carArray.length; i++) {
            carList.add(new Car(carArray[i], 0));
        }

        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).getName() + ", " + carList.get(i).getPosition());
        }
    }

    // 현재 경주하는 차들의 상태 값 출력
    private void printCarState() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).getName() + ", " + carList.get(i).getPosition());
        }
    }


}
