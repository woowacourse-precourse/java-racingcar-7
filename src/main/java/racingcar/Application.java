package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int n = Integer.parseInt(Console.readLine());
    }

    public static List<String> splitWithComma(String input) {

        // 콤마로 분리, 불필요한 공백 제거, 리스트에 담기
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

    }
}
