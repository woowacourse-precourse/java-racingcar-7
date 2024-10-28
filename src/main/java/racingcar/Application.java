package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        List<String> carNames = getCarNames();
    }

    // 자동차 이름 입력
    // 입력 값 검사
    private static void validateCarNames(String input) {
        if (!input.matches("(\\b\\w{1,5}\\b)(,\\b\\w{1,5}\\b)*")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        // 정규 표현식 검사
        validateCarNames(input); // 검사 메서드 호출

        String[] nameArray = input.split(",");
        return new ArrayList<>(List.of(nameArray)); // 배열을 리스트로 변환
    }



}
