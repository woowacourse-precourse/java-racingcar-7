package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class RacingCar {

    static HashSet<String> hashSet = new HashSet<>();

    public static void startRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine();

        for (final String carName : carNames.split(",")) {
            if(carName.length() >= 5){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            hashSet.add(carName);
        }
    }
}
