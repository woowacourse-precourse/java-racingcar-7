package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class Input {

    HashMap<String, Integer> map = new HashMap<>();

    protected HashMap<String, Integer> getCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        String temp[] = input.split(",");

        for (int i = 0; i < temp.length; i++) // car 목록 초기화
        {
            map.put(temp[i], 0);
        }

        // HashMap의 key만 출력
//        for (String key : map.keySet())
//            System.out.println(key);

        return map;
    }

    protected Integer getNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.valueOf(Console.readLine());
    }
}
