package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputView {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차 이름이 입력되지 않았습니다.");
        }

        String[] carNames = input.split(",");
        Set<String> uniqueCarNames = new HashSet<>();
        List<String> carList = new ArrayList<>();

        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
            }
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException(carName + "은 이미 존재하는 자동차 이름입니다.");
            }
            carList.add(carName);
        }

        return carList;
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        if (tryCount <= 0) {
            throw new IllegalArgumentException("1번 이상 시도해야 합니다.");
        }

        return tryCount;
    }
}
