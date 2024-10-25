package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class RacingCar {

    static HashSet<String> hashSet = new HashSet<>();

    public static void startRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        final String tryCount = Console.readLine();
        final int tryCountNumber = Integer.parseInt(tryCount);

        for (final String carName : carNames.split(",")) {
            if (carName.length() >= 5){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            if (hashSet.contains(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름을 입력했습니다.");
            }

            hashSet.add(carName);
        }

        for (int i = 0; i < tryCountNumber; i++) {
            for (String carName : hashSet) {
                final int randomInt = Randoms.pickNumberInRange(0, 9);
                final String moveDistance = "-".repeat(randomInt);
                System.out.println(carName + " : " + moveDistance);
            }
            System.out.println("");
        }
    }


}
