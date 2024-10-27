package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static ArrayList<Integer> racingDistance = new ArrayList<>();

    public static void main(String[] args) {
        race("AA,B,CCC", 5);
    }

    public static void race(final String text, final int racingCnt) {
        String[] name = text.split(",");
        // 이름은 5자 이하만 가능하게 해야 함
        final int numberOfCar = name.length;

        for (int i = 0; i < numberOfCar; i++) {
            racingDistance.add(0);
        }

        for (int i = 0; i < racingCnt; i++) {
            moveCar(numberOfCar);
            viewRace(numberOfCar, name);
        }
    }

    public static void moveCar(final int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            if (Randoms.pickNumberInRange(0, 9) < 4) {
                continue;
            }
            racingDistance.set(i, racingDistance.get(i) + 1);
        }
    }

    // 뭔가가.. 불편하다. for문 2개가 중첩돼 있고 매개변수 name도 배열로 주기 보다 더 좋은 방법이 있을 것 같다. print도 너무 지저분하다.
    // 클래스 분리에 대해 찾아보고, print를 개선할 수 있는 방법을 찾아보자.
    public static void viewRace(final int numberOfCar, final String[] name) {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfCar; i++) {
            System.out.print(name[i] + " : ");
            for (int j = 0; j < racingDistance.get(i); j++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
