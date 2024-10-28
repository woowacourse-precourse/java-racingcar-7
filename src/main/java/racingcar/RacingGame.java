package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private int rounds;
    private Cars cars;


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
            cars.moveAll();
            cars.printStatus();
            System.out.println();
        }
    }

    private void announceWinners() {
        String winners = cars.getWinners();
        System.out.println("최종 우승자 : " + winners);
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        cars = new Cars(carNames);
    }

    public void start() {
        inputCarNames();   // 자동차 이름 입력받기
        inputRounds();     // 라운드 수 입력받기
        race();           // 경주 진행
        announceWinners(); // 우승자 발표
    }
}
