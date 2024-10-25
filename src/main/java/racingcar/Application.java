package racingcar;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] carNames = scanner.nextLine().split(",");

            System.out.println("시도할 횟수는 몇 회인가요?");
            int raceRounds = scanner.nextInt();

        } catch (IllegalArgumentException e) { // 잘못된 값 예외 처리
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

