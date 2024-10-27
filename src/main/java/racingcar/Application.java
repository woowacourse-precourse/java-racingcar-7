package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    Scanner scan = new Scanner(System.in);
    String[] nameList = null;
    int count = 0;
    ArrayList<Integer> moveList = new ArrayList<>();

    void run() {
        getName();
        getCount();
        resetMoveList();
        output();
    }

    void getName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scan.next();
        nameList = input.split(",");
        for (String s : nameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    void getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        count = scan.nextInt();
    }

    void resetMoveList() {
        for (int i = 0; i < nameList.length; i++) {
            moveList.add(0);
        }
    }

    void output() {
        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            doRace();
        }
    }

    void doRace() {
        for (int j = 0; j < nameList.length; j++) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                moveList.set(j, moveList.get(j) + 1);
            }
        }
        printCurrentRace();
        System.out.println();
    }

    void printCurrentRace() {
        for (int k = 0; k < nameList.length; k++) {
            System.out.printf("%s : ", nameList[k]);
            for (int l = 0; l < moveList.get(k); l++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();
    }
}
