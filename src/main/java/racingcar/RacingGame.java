package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final InputHandler inputHandler = new InputHandler();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<User> users = inputHandler.getCarNameFromUser();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int moveCount = inputHandler.getMoveCountFromUser();


        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            for (User user : users) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                int proceedScore = user.proceed(randomNumber);

                System.out.println(user.getName() + " : " + "-".repeat(proceedScore));
            }
            System.out.println();
        }

        List<String> winners = new ArrayList<>();
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
