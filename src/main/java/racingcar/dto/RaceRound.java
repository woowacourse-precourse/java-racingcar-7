package racingcar.dto;

import camp.nextstep.edu.missionutils.Console;

public class RaceRound {
    private final int rounds;

    public RaceRound(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
        this.rounds = rounds;
    }

    public int getRounds() {
        return rounds;
    }

    public static RaceRound inputRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int rounds;
        try {
            rounds = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
        return new RaceRound(rounds);
    }
}
