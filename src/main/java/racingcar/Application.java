package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String[] carNames = getCarNames();
        int numberOfAttempts = getNumberOfAttempts();  // 시도 횟수 입력받기
    }

    // 자동차 이름 입력받기
    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);  // 이름 유효성 검사 호출
        return carNames;
    }

    // 자동차 이름 유효성 검사
    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (isInvalidCarName(name)) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 설정해야 합니다.");
            }
        }
    }

    // 이름이 유효하지 않은지 확인하는 메소드
    private static boolean isInvalidCarName(String name) {
        return name.trim().length() > 5 || name.trim().isEmpty();
    }

    // 시도 횟수 입력받기
    private static int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());
        validateAttempts(attempts);  // 시도 횟수 유효성 검사
        return attempts;
    }

    // 시도 횟수 유효성 검사
    private static void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }
}
