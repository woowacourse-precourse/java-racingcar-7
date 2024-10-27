package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static ArrayList<Integer> racingDistance = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputRacingCnt = Console.readLine();
        race(inputCar, inputRacingCnt);
    }

    public static void race(final String textFirst, final String textSecond) {
        String[] nameList = textFirst.split(",");

        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        final int numberOfCar = nameList.length;

        // racintCnt가 정수 값인지 확인해야 함
        int racingCnt = Integer.parseInt(textSecond);

        for (int i = 0; i < numberOfCar; i++) {
            racingDistance.add(0);
        }

        for (int i = 0; i < racingCnt; i++) {
            moveCar(numberOfCar);
            viewRace(numberOfCar, nameList);
        }

        viewWinner(numberOfCar, nameList);
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

    public static void viewWinner(final int numberOfCar, final String[] name) {
        int winnerDistance = Collections.max(racingDistance);

        ArrayList<String> winner = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            if (racingDistance.get(i) == winnerDistance) {
                winner.add(name[i]);
            }
        }
        System.out.println("최종 우승자 : " + String.join(",", winner));
    }
}
