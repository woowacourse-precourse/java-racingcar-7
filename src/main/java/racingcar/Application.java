package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;

public class Application {

    static String[] names;
    static String repeat;
    static HashMap<String, Integer> car = new HashMap<>();
    static ArrayList<String> winner = new ArrayList<>();
    public static void main(String[] args) {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Application app = new Application();
        // 입력 받기
        app.init(input);
        int repeatTime = Integer.parseInt(repeat);
        for (int i = 0; i < repeatTime; ++i) {
            for (String name : names) {
                app.moveCar(name, (int) (Math.random() * 10));
            }
        }
        app.checkWinner();
        app.printWinner();
    }

    public void init(String input) {
        if (input == null || input.trim().isEmpty()) { throw new IllegalArgumentException("유효하지 않은 입력입니다. 자동차 이름을 입력해 주세요."); }

        String delimiters = ",";
        names = input.split(delimiters);

        if (names.length == 0) { throw new IllegalArgumentException("자동차 이름은 하나 이상 입력해야 합니다."); }

        for (String name : names) {
            if (name.trim().isEmpty()) { throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다."); }
            if (name.length() > 5) { throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다: " + name); }
            car.put(name, 0);
        }
        System.out.print("시도할 횟수는 몇 회인가요?");
        repeat = Console.readLine();
    }

    public void moveCar(String name, int randomValue) {
        if (randomValue >= 4) {
            car.put(name, car.get(name) + 1);
        }
        System.out.print(name + " : ");
        for (int i = 0; i < car.get(name); ++i) {
            System.out.print("-");
        }
        System.out.println();

    }

    public void checkWinner() {
        int maxi = 0;
        for (String name : names) {
            int curCnt = car.get(name);
            if (curCnt > maxi) {
                maxi = curCnt;
                winner.clear();
                winner.add(name);
            }
            else if (curCnt == maxi) { winner.add(name); }
        }
    }

    public void printWinner() {
        System.out.print("최종 우승자 : ");
        for (String winName : winner) {
            System.out.print(winName + " ");
        }
        System.out.println();
    }

    public HashMap<String, Integer> getCarPositions() {
        return car;
    }
}
