package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        /**
         * 1. 자동차 이름 입력 및 검증
         *   - 쉼표로 구분된 자동차 이름 입력받기
         *   - 5자 이하인지 검증하고 5자를 초과하는 경우 IllegalArgumentException을 발생
         *   - 이름 리스트 반환
         * */
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputNames = Console.readLine();
        List<String> validateNames = InputValidator.validateNames(inputNames);

        /**
         * 2. 이동 횟수 입력 및 검증
         *    - 이동 횟수 입력받기
         *    - 입력 값이 숫자인지 검증하고 아닌 경우 IllegalArgumentException을 발생
         *    - 이동 횟수 반환
         * */
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputMoveCnt = Console.readLine();
        int validateMoveCnt = InputValidator.validateMoveCnt(inputMoveCnt);
    }
}
