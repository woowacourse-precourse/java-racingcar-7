package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class RacingCarInput {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> list = Arrays.asList(input.split(","));
        if (list.size() < 2) throw new IllegalArgumentException("자동차의 개수는 2개 이상이어야 합니다.");
        return list;
    }

    public int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        if (count < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1번 이상이어야 합니다.");
        }
        return count;
    }
}
