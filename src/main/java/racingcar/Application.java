package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> cars = getCarNames();
        int rounds = getRounds();
    }

    // 자동차 이름 입력
    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        List<String> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(name.trim());
        }
        return cars;
    }

    private static int getRounds(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
