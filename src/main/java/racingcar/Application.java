package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) {
        // 경주할 자동차 이름 입력(참가자 수)
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        // 사용자 입력에서 공백을 제거하고 쉼표로 구분해서 가변 컬렉션인 ArrayList에 저장
        List<String> inputList = new ArrayList<>(Arrays.asList(Console.readLine().split("\\s*,\\s*")));

        try {
            validateInput(inputList);
            System.out.println(inputList);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    // 사용자 입력에서 빈 문자열을 제거 하고 특수 문자가 있는지 확인하는 메서드
    private static void validateInput(List inputList) {
        ListIterator<String> iterator = inputList.listIterator();

        while (iterator.hasNext()) {
            String str = iterator.next();

            // 공백을 제거한 후 빈 문자열이 되면 List에서 제거하고 다음 인덱스로 넘어감
            if (str.trim().isEmpty()) {
                iterator.remove();
                continue;
            }

            // List에 저장된 문자열에 특수 문자가 있는지 정규 표현식을 사용해 검증
            if (str.matches(".*[`~!@#$%^&*()\\-_=+{}\\[\\];:'\",.<>/?|\\\\].*")) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }
}
