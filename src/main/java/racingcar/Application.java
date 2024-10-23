package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class Application {

    public static void validateCharacters(List<String> names) {
        final String englishRegex = "a-zA-Z";
        final String koreanRegex = "가-힣";

        if (!names.stream().allMatch(name -> name.matches("^[" + englishRegex + koreanRegex + "]*$"))) {
            throw new IllegalArgumentException("이름에 허용되지 않는 문자가 들어가 있습니다 (한국어+영어만 가능).");
        }
    }

    public static void validateLength(List<String> names) {
        final int MAX_NAME_LENGTH = 5;

        if (!names.stream().allMatch(name -> name.length() <= MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("각 이름의 길이는 " + MAX_NAME_LENGTH + "자를 넘길 수 없습니다.");
        }
    }

    public static void printWinners(LinkedHashMap<String, Integer> cars) {
        List<String> winners = new ArrayList<>();

        for (Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() == Collections.max(cars.values())) {
                winners.add(car.getKey());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
    public static void moveCars(LinkedHashMap<String, Integer> cars) {
        for (Entry<String, Integer> car : cars.entrySet()) {
            if (canMove()) {
                cars.put(car.getKey(), car.getValue() + 1);
            }
            System.out.println(car.getKey() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }

    public static boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = Arrays.asList(Console.readLine()
                .replace(" ", "")
                .split(","));

        validateCharacters(names);
        validateLength(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int totalMoves = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        LinkedHashMap<String,Integer> cars = new LinkedHashMap<>();

        for (String name: names) {
            cars.put(name, 0);
        }

        for (int indexMoves = 0; indexMoves < totalMoves; indexMoves++) {
            moveCars(cars);
        }

        printWinners(cars);
    }
}
