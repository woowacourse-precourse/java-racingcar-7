package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

// 5. 마지막 경주 이후 최종 우승자를 출력한다.
//    * 단독 우승자와 공동 우승자로 내용을 구분하여 출력한다.
//    * 공동 우승자일 경우 쉼표(,)를 이용하여 구분한다.
public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException("이름은 쉼표(,) 기준으로 구분하여 입력해주세요.");
        } // end if

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
            } // end if
        } // end for

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputTimes = Console.readLine();
        if (!inputTimes.matches("^[0-9]+$")) {
//            throw new NumberFormatException("숫자를 입력해주세요.");
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        } // end if
        int times = Integer.parseInt(inputTimes);

        System.out.println();
        System.out.println("실행 결과");

        Map<String, List<String>> cars = new HashMap<>();

        for (String name : names) {
            List<String> positions = new ArrayList<>();
            cars.put(name, positions);
        } // end for

        for (int i = 0; i < times; i++) {
            Set<String> carNames = cars.keySet();
            for (String name : carNames) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber > 4) {
                    cars.get(name).add("-");
                } // end if
                System.out.println(name + " : "  + cars.get(name));
            } // end for
            System.out.println();
        } // end for

        Map<String, Integer> lastPositions = new HashMap<>();
        for (String name : cars.keySet()) {
            lastPositions.put(name, cars.get(name).size());
        } // end for

        List<String> keySet = new ArrayList<>(cars.keySet());
        keySet.sort(((o1, o2) -> lastPositions.get(o2) - lastPositions.get(o1)));
        int maxPosition = lastPositions.get(keySet.getFirst());
        StringBuilder winner = new StringBuilder();

        for (String name : lastPositions.keySet()) {
            if (lastPositions.get(name) == maxPosition) {
                winner.append(name).append(", ");
            } // end if
        } // end for

        String winnerNames = winner.toString();
        if (winnerNames.endsWith(", ")) {
            winnerNames = winnerNames.substring(0, winnerNames.length() - 2);
        } // end if

        System.out.println("최종 우승자 : " + winnerNames);
    } // main
} // class