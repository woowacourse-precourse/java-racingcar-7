package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Map<String,Integer> dictionary = new HashMap<>();

        for (String name : input.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
            }
            dictionary.put(name, 0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        for (int i = 0; i < attemptCount; i++) {
            carMove(dictionary);
        }
    }

    private static void carMove(Map<String, Integer> dictionary) {
        for (String name : dictionary.keySet()) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                dictionary.put(name, dictionary.get(name) + 1);
            }
        }
        printDictionary(dictionary);
    }

    public static void printDictionary(Map<String, Integer> dictionary) {
        for (String name : dictionary.keySet()) {
            System.out.println(name + " : " + "-".repeat(dictionary.get(name)));
        }
        System.out.println();
    }
}

