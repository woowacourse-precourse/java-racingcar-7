package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String[] names = Console.readLine().split(",");
        int attempts = Integer.parseInt(Console.readLine());
        String[] individualCarMovements = new String[names.length];
        Arrays.fill(individualCarMovements, ""); // 배열 생성시 빈 문자열로 초기화
        printCarMovements(individualCarMovements, names, attempts);
        List<Integer> checkWinner = checkWinner(individualCarMovements);
        printWinner(checkWinner, names);
    }

    public static void individualRandoms(String[] individualCarMovements, String[] names) { // 1회 이동 메서드
        for (int i = 0; i < names.length; i++) {
            if (Randoms.pickNumberInRange(0, 9) > 4) {
                individualCarMovements[i] += "-";
            }
        }
        for (int j = 0; j < names.length; j++) {
            System.out.println(names[j] + " : " + individualCarMovements[j]);
        }
        System.out.println();
    }

    public static void printCarMovements(String[] individualCarMovements, String[] names,
                                         int attempts) { // 시도
        for (int i = 0; i < attempts; i++) {
            individualRandoms(individualCarMovements, names);
        }
    }

    public static List<Integer> checkWinner(String[] individualCarMovements) {
        List<Integer> index = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < individualCarMovements.length; i++) {
            if (individualCarMovements[i].length() > max) {
                max = individualCarMovements[i].length();
                index.clear();
                index.add(i);
            } else if (individualCarMovements[i].length() == max) {
                index.add(i);
            }
        }
        return index;
    }

    public static void printWinner(List<Integer> checkWinner, String[] names) {
        System.out.print("최종 우승자는 : ");

        for (int i = 0; i < checkWinner.size(); i++) {
            System.out.print(names[checkWinner.get(i)]);
            if (i < checkWinner.size() - 1) {
                System.out.print(", "); // 마지막 요소일땐 쉼표 출력하지 않음
            }
        }
    }


}