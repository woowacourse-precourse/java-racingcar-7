package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class InputHandler {
    static final char COMMA = ',';

    public static LinkedHashMap<String, StringBuffer> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",", -1);
        LinkedHashMap<String, StringBuffer> cars = new LinkedHashMap<>();
        for (String name : names) {
            if (name.indexOf(COMMA) != -1) { // 이름에 ,가 포함된 경우
                throw new IllegalArgumentException();
            }
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException();
            }

            cars.put(name, new StringBuffer());
        }
        return cars;
    }

    public static int getNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
