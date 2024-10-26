package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"); // 프로그램 시작
        List<String> carNames = getCarNames(); // 1번 기능: 자동차 이름 입력 및 검증
        System.out.println("입력된 자동차 이름: " + carNames); // 입력된 자동차 이름 출력 (디버깅 용도)
        
        int attempts = getAttempts(); // 2번 기능: 시도할 횟수 입력 및 검증
        System.out.println("입력된 시도 횟수: " + attempts); // 입력된 시도 횟수 출력 (디버깅 용도)
        // 이후 기능 구현 예정
    }
     /**
    /**
     * 사용자로부터 자동차 이름을 입력받고 유효성을 검사하는 메서드
     * @return 유효성 검사를 통과한 자동차 이름 목록
     */
    private static List<String> getCarNames() {
        String input = Console.readLine(); // 자동차 이름 입력
        String[] names = input.split(","); // 쉼표를 기준으로 이름 분리

        List<String> carNames = new ArrayList<>(); // 유효성 검사
        for (String name : names) {
            name = name.trim();  // 이름 앞뒤 공백 제거

            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 빈 값이거나 5자를 초과할 수 없습니다: " + name); // 이름이 빈 값이거나 5자를 초과할 경우 예외 발생
            }

            carNames.add(name);
        }

        return carNames;
    }
    /**
     * 사용자로부터 시도할 횟수를 입력받고 유효성을 검사하는 메서드
     * @return 유효성 검사를 통과한 시도 횟수
     */
    private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine(); // 시도 횟수 입력
        
        try {
            int attempts = Integer.parseInt(input); // 문자열을 정수로 변환
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다. 시도 횟수는 정수여야 합니다.");
        }
    }
}
