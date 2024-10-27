package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    static ArrayList<Integer> moveCounts = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> carNames = new ArrayList<>();
        parseCarNames(carNames);
        for (int i = 0; i < carNames.size(); i++) {
            moveCounts.add(0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());
        System.out.println("실행 결과");
        canMove(carNames, attempts);

        printWinners(carNames);
    }

    public static void parseCarNames(ArrayList<String> carNames) {
        String[] names = Console.readLine().split(",");
        for (String name : names) {
            name = name.trim();
            if (name.length() <= 5) {
                carNames.add(name);
            } else {
                throw new IllegalArgumentException("5자 이하로 해주세요.");
            }
        }
    }

    public static void canMove(ArrayList<String> carNames, int attempts) {
        if (attempts == 0) {
            throw new IllegalArgumentException();
        }
        carNames.replaceAll(s -> s + " : ");

        for (int i = 0; i < attempts; i++) {
            moveCar(carNames);
            printRaceState(carNames);
        }
    }

    public static void moveCar(ArrayList<String> carNames) {
        for (int j = 0; j < carNames.size(); j++) {
            int ranNum = Randoms.pickNumberInRange(0, 9);
            if (ranNum >= 4) {
                String updateName = carNames.get(j) + "-";
                carNames.set(j, updateName);
                moveCounts.set(j, moveCounts.get(j) + 1);
            }
        }
    }

    public static void printRaceState(ArrayList<String> carNames) {
        for (String name : carNames) {
            System.out.println(name);
        }
        System.out.println();
    }

    public static void printWinners(ArrayList<String> carNames) {
        int maxMove = 0;
        for (int count : moveCounts) {
            if (count > maxMove) {
                maxMove = count;
            }
        }

        ArrayList<String> winners = new ArrayList<>();
        for (int i = 0; i < moveCounts.size(); i++) {
            if (moveCounts.get(i) == maxMove) {
                winners.add(carNames.get(i).split(" : ")[0]);
            }
        }
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

}