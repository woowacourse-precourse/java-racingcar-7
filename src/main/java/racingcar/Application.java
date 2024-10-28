package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tr = Integer.parseInt(Console.readLine());

        String[] Cars = input.split(",");
        for (String a : Cars) {
            if (a.length() > 5) {
                throw new IllegalArgumentException("이름이 6자이상임");
            }
        }

    }
}
