package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] getCarNames() {
        String carNames =  Console.readLine();
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }

        return carNameArray;
    }

    public static int getMovementCount() {
        try {
            int count = Integer.parseInt(Console.readLine());
            if (count <= 0) {
                throw new IllegalArgumentException("아동 횟수는 1 이상이여야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
        }
    }
}
