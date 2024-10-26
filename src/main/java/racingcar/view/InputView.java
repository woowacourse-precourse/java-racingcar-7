package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarString() {
        String carString = Console.readLine();
        if (carString.isBlank()) {
            throw new IllegalArgumentException("[ERROR] : 값이 입력되지 않았습니다.");
        }
        return carString;
    }

    public String readTryCount() {
        String tryCount = Console.readLine();
        if (tryCount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] : 값이 입력되지 않았습니다.");
        }
        try {
            Integer.parseInt(tryCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] : 숫자를 입력해주세요.");
        }
        return tryCount;
    }
}
