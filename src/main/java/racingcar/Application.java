package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Map<String, Integer> race = new HashMap<>();
        try {
            getNames(race, input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num;
        try {
            num = parseNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        System.out.println("실행 결과");

        for (int i = 0; i < num; i++) {
            for(Map.Entry<String, Integer> entry : race.entrySet()){
                int r = randomNum();
                move(entry, goStop(r));
            }
            printRace(race);
        }

        List<String> winners = getWinners(race);
        printWinner(winners);
    }

    public static void getNames(Map<String, Integer> race, String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다.");
        }
        String[] names = input.split(",");
        if (names.length <= 1) {
            throw new IllegalArgumentException("자동차는 2개 이상이어야 합니다.");
        }
        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("이름은 한 글자 이상이어야 합니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            race.put(name, 0);
        }
    }

    public static int parseNumber(String input) throws IllegalArgumentException {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return num;
    }

    public static int randomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean goStop(int n) {
        return n >= 4;
    }

    public static void move(Map.Entry<String, Integer> element, boolean goStop) {
        if(goStop) {
            element.setValue(element.getValue() + 1);
        }
    }

    public static void printRace(Map<String, Integer> race) {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Integer> entry : race.entrySet()) {
            result.append(entry.getKey()).append(" : ");
            result.append("-".repeat(entry.getValue()));
            result.append("\n");
        }
        System.out.print(result.toString());
        System.out.println();
    }

    public static List<String> getWinners(Map<String, Integer> race) {
        int maxDistance = Collections.max(race.values());
        List<String> winners = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : race.entrySet()) {
            if (entry.getValue() == maxDistance) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }

    public static void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
