package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    static final int MAXIMUM_ATTEMPTS = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<RacingCar> carList = splitToCarList(Console.readLine());

        System.out.printf("시도할 횟수는 몇 회인가요? (최대 가능 횟수: %d회)\n", MAXIMUM_ATTEMPTS);
        int numberOfAttempts = parseNumber(Console.readLine());

        System.out.println("\n실행 결과");
        RacingGame racingGame = new RacingGame(carList, numberOfAttempts);
        racingGame.startRace();

        Console.close();
    }

    public static List<RacingCar> splitToCarList(String carNames) {
        List<RacingCar> carList = new ArrayList<>();
        Set<String> carSet = new HashSet<>();

        for (String carName : carNames.split(",")) {
            carName = carName.trim();
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException(String.format("자동차 이름(%s)은 1자 이상 5자 이하만 가능합니다.", carName));
            }
            if (!carSet.add(carName)) {
                throw new IllegalArgumentException(String.format("중복된 자동차 이름(%s)을 입력하셨습니다.", carName));
            }

            carList.add(new RacingCar(carName));
        }
        return carList;
    }

    public static int parseNumber(String attempts) {
        int number;

        try {
            number = Integer.parseInt(attempts);
            if (number > MAXIMUM_ATTEMPTS) {
                throw new IllegalArgumentException(String.format("최대 시도 횟수(%d)를 초과하였습니다.", MAXIMUM_ATTEMPTS));
            }
            if (number <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("유효한 숫자(%d 이하의 자연수)를 입력하여 주세요.", MAXIMUM_ATTEMPTS));
        }

        return number;
    }
}
