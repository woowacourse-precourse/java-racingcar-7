package racingcar;

import com.sun.nio.sctp.AbstractNotificationHandler;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String car_nameList = scanner.nextLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int race_count = Integer.parseInt(scanner.nextLine());

        // 시도 횟수가 음수 일시 에러
        if (race_count < 0) {
            throw new IllegalArgumentException("시도 횟수는 반드시 양수를 입력해야 합니다.");
        }

        Map<String, Integer> raceScores = RacingCar.convertStringToMap(car_nameList);

        System.out.println("실행 결과");

        for (int i = 0; i < race_count; i++) {
            RacingCar.race(raceScores);
        }

        System.out.println("최종 우승자 : " + RacingCar.winner(raceScores));
        scanner.close();
    }
}
