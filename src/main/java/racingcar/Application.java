package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            List<Car> cars = getCarsFromInput();
            int rounds = getRoundsFromInput();

            RacingGame game = new RacingGame(cars, rounds);
            game.startRace();
            game.printFinalResults();
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    private static List<Car> getCarsFromInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(Car::new)  // 각 이름으로 Car 객체를 생성
                .collect(Collectors.toList());
    }

    private static int getRoundsFromInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int rounds = Integer.parseInt(Console.readLine());
        validateRounds(rounds);
        System.out.println();
        return rounds;
    }

    private static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("이동 횟수는 양의 정수만 가능합니다.");
        }
    }
}
