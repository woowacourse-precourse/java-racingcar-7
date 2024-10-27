package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = readLine();
        String[] carList = carName.split(",");
        int carListLength = carList.length;
        for (int q = 0; q < carListLength; q++) {
            if (carList[q].length() > 5) {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String countStr = readLine();
        for (int p = 0; p < countStr.length(); p++) {
            if (!Character.isDigit(countStr.charAt(p))) {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }
        }
        int count = Integer.parseInt(countStr);
        System.out.println();

        int[] moveList = new int[carListLength];

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < carListLength; j++) {
                int goNum = Randoms.pickNumberInRange(0, 9);
                if (goNum >= 4) {
                    moveList[j] += 1;
                }
            }
            for (int k = 0; k < carListLength; k++) {
                System.out.print(carList[k] + " : ");
                for (int l = 0; l < moveList[k]; l++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }


        int maxMove = 0;
        for (int m = 0; m < carListLength; m++) {
            if (moveList[m] > maxMove) {
                maxMove = moveList[m];
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (int n = 0; n < carListLength; n++) {
            if (moveList[n] == maxMove) {
                list.add(carList[n]);
            }
        }

        System.out.print("최종 우승자 : ");
        for (int o = 0; o < list.size() - 1; o++) {
            System.out.print(list.get(o));
            System.out.print(", ");
        }
        System.out.print(list.get(list.size() - 1));
    }
}
