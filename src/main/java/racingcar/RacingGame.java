package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private int rounds;


    private void inputRounds() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        try {
            rounds = Integer.parseInt(Console.readLine());
            validateRounds(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 숫자여야 합니다");
        }

    }

    public void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }

    private void race() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            Cars.moveAll();
            Cars.printStatus();
            System.out.println();
        }
    }
}
