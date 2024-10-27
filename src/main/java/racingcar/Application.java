package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        try {
            String[] cars = getCars();
            int attempts = getAttempts();
            int[] racingNum = race(cars, attempts);
            printWinners(cars, racingNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 자동차 이름 입력받기
    private static String[] getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");
        validateCarNames(cars);
        return cars;
    }

    // 이동 횟수 입력받기
    private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());
        if (attempts <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
        return attempts;
    }

    // 자동차 이름 유효성 검사
    private static void validateCarNames(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5 || car.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 설정해야 합니다.");
            }
        }
    }

    // 경주 로직
    private static int[] race(String[] cars, int attempts) {
        int[] racingNum = new int[cars.length];

        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < cars.length; j++) {
                if (shouldAdvance()) {
                    racingNum[j]++;
                }
            }
            printRaceStatus(cars, racingNum);
        }
        return racingNum;
    }

    // 전진 조건 체크
    private static boolean shouldAdvance() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

    // 경주 상태 출력
    private static void printRaceStatus(String[] cars, int[] racingNum) {
        for (int j = 0; j < cars.length; j++) {
            System.out.print(cars[j] + " : ");
            for (int k = 0; k < racingNum[j]; k++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 우승자 출력
    private static void printWinners(String[] cars, int[] racingNum) {
        int maxDistance = Arrays.stream(racingNum).max().orElse(-1);
        ArrayList<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            if (racingNum[i] == maxDistance) {
                winners.add(cars[i]);
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
