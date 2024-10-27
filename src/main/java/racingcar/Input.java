package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class Input {

    HashMap<String, Integer> map = new HashMap<>();
   Validator validator = new Validator();

    protected HashMap<String, Integer> getCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String temp[] = input.split(",");

        for (String name : temp) // car 목록 초기화
        {
            validator.fiveChar(name);
            validator.blankName(name);
            map.put(name, 0);
        }
        return map;
    }

    protected Integer getNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Integer input = Integer.valueOf(Console.readLine());
        validator.validMinus(input);
        return input;
    }
}
