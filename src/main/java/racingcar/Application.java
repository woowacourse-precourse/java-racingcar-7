package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = scanner.nextLine().split(",");

        Map<String, Integer> cars = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() <= 5) {
                cars.put(input[i], 0);
            } else {
                throw new IllegalArgumentException("자동차의 이름은 5문자를 넘을 수 없습니다.");
            }
        }


    }


}
