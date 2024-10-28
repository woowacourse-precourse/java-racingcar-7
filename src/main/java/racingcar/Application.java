package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력 요구 사항 1-1
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String[] names = input.split(",");

        if (names.length == 0) {// 구분자만 넣었을 경우
            throw new IllegalArgumentException("자동차의 이름을 1글자 이상 입력하세요.");
        }
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
            } else if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차의 이름을 1글자 이상 입력하세요.");
            } else if (name.isBlank()) {
                throw new IllegalArgumentException("공백으로만 이루어진 자동차의 이름은 불가능합니다.");
            }
        }

        // 입력 요구 사항 1-2
        System.out.println("시도할 횟수는 몇 회인가요?");

        String num = Console.readLine();

        int repeat = 0;
        try {
            repeat = Integer.parseInt(num);
            if (repeat < 1) {
                throw new IllegalArgumentException("1 이상의 숫자만 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }

        // 출력 요구 사항 1-1
        System.out.println("");
        System.out.println("실행 결과");

        // 기능 요구 사항
        int lengthOfNames = names.length;

        ArrayList<Integer> numOfGo = new ArrayList<>();
        for (int i = 0; i < lengthOfNames; i++) {
            numOfGo.add(0);
        }

        ArrayList<String> status = new ArrayList<>();
        for (int i = 0; i < lengthOfNames; i++) {
            status.add("");
        }

        for (int j = 0; j < repeat; j++) {
            for (int i = 0; i < lengthOfNames; i++) {
                System.out.print(names[i] + " : ");
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                    status.set(i, status.get(i) + "-");
                    numOfGo.set(i, numOfGo.get(i) + 1);
                }
                System.out.println(status.get(i));
            }
            System.out.println("");
        }

        int bestNumOfGo = 0;
        for (int i = 0; i < lengthOfNames; i++) {
            if (numOfGo.get(i) > bestNumOfGo) {
                bestNumOfGo = numOfGo.get(i);
            }
        }
        System.out.println(bestNumOfGo);

        int winnerCount = 0;
        for (int i = 0; i < lengthOfNames; i++) {
            if (numOfGo.get(i) == bestNumOfGo) {
                winnerCount += 1;
                if (winnerCount == 1) {
                    System.out.print("최종 우승자 : " + names[i]);
                } else {
                    System.out.print(", " + names[i]);
                }

            }
        }
    }
}
