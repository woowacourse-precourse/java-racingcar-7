package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.User.createUser;

public class RacingGame {

    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] nameList = names.split(",");
        List<User> users = new ArrayList<>();
        for (String name : nameList) {
            User user = createUser(name);
            users.add(user);
        }

        System.out.println("시도할 횟수는 몇 회 인가요?");
        String times = Console.readLine();
        boolean isNumeric = times.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException("숫자만 입력 해 주세요.");
        }
        long time = Long.parseLong(times);

        System.out.println("실행 결과");
        for (int i = 0; i < time; i++) {
            for (User user : users) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                int proceedScore = user.proceed(randomNumber);

                System.out.println(user.getName() + " : " + "-".repeat(proceedScore));
            }
            System.out.println();
        }

        List<String > winners = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (User user : users) {
            int score = user.getScore();
            if (score > max) {
                max = score;
                winners.clear();
                winners.add(user.getName());
            } else if (score == max) {
                winners.add(user.getName());
            }
        }
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
