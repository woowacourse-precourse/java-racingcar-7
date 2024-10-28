package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            String[] names = validateNames();
            int attempts = validateNumber();
            String[] individualCarMovements = new String[names.length];
            Arrays.fill(individualCarMovements, ""); // 배열 생성시 빈 문자열로 초기화
            printCarMovements(individualCarMovements, names, attempts);
            List<Integer> checkWinner = checkWinner(individualCarMovements);
            printWinner(checkWinner, names);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            throw e;
        }
    }

    public static void individualRandoms(String[] individualCarMovements, String[] names) { // 1회 이동 메서드
        for (int i = 0; i < names.length; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
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
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < checkWinner.size(); i++) {
            System.out.print(names[checkWinner.get(i)]);
            if (i < checkWinner.size() - 1) {
                System.out.print(", "); // 마지막 요소일땐 쉼표 출력하지 않음
            }
        }
    }

    public static String[] validateNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        HashSet<String> checkDuplication = new HashSet<>(Arrays.asList(names));
        if (names.length == 1) {
            throw new IllegalArgumentException("2명 이상 입력해야 합니다.");
        }
        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("공백인 이름이 있습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("5글자를 초과한 이름이 있습니다.");
            }
        }
        if (checkDuplication.size() != names.length) {
            throw new IllegalArgumentException("중복된 이름이 있습니다");
        }
        return names;
    }

    public static int validateNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        int attempts = Integer.parseInt(input); // 숫자임을 보장

        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        return attempts;

    }
}