package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//출력문 상수화하기!
//주석 필요없는 건 지우기!

// 사용자 입력을 담당하는 클래스
public class Input {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요 (쉼표로 구분):";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 횟수를 입력하세요:";

    public List<String> getCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int getAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
