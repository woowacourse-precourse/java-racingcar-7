package racingcar;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

            String[] cars = getCars();
            int attempts = getAttempts();
            int[] racingNum = race(cars, attempts);
            
    }   
    // 자동차 이름 입력받기
    private static String[] getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc = new Scanner(System.in);
        String[] cars = sc.nextLine().split(",");
        validateCarNames(cars);
        return cars;
    }

    // 자동차 이름 유효성 검사
    private static void validateCarNames(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5 || car.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 설정해야 합니다.");
            }
        }
    }

     // 이동 횟수 입력받기
     private static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner sc = new Scanner(System.in);
        int attempts = sc.nextInt();
        if (attempts <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
        return attempts;
    }

    // 경주 로직
    private static int[] race(String[] cars, int attempts) {
        Random random = new Random();
        int[] racingNum = new int[cars.length];

        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < cars.length; j++) {
                if (shouldAdvance(random)) {
                    racingNum[j]++;
                }
            }
        }
        return racingNum;
    }

    // 전진 조건 체크
    private static boolean shouldAdvance(Random random) {
        return random.nextInt(10) >= 4;
    }
}
