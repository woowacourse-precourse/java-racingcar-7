package racingcar;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        HashMap<String, Integer> cars = Racingcar.cars_names(names);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int n = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        Racingcar.racing(n, cars);
        Racingcar.winner(cars);
    }
}
