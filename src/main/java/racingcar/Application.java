package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        try {
            String[] carNames = getCarNames();
            int numberOfAttempts = getNumberOfAttempts();
            int[] carDistances = startRace(carNames, numberOfAttempts);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 자동차 이름 입력받기
    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);
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
        validateAttempts(attempts);
        return attempts;
    }

    private static void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }

    // 경주 시작 로직
    private static int[] startRace(String[] carNames, int attempts) {
        int[] distances = new int[carNames.length];
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            runSingleRace(carNames, distances);
        }
        return distances;
    }

    // 한 번의 경주 시도
    private static void runSingleRace(String[] carNames, int[] distances) {
        for (int j = 0; j < carNames.length; j++) {
            if (canAdvance()) {
                distances[j]++;
            }
        }
    }

    // 전진 조건 체크
    private static boolean canAdvance() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
