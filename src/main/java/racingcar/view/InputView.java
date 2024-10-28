package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String[] getCarNames() {
        String carNames =  Console.readLine();
        String[] carNameArray = carNames.split(",");

        for (int i = 0; i < carNameArray.length; i++) {
            String carName = carNameArray[i];

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }

            for (int j = i + 1; j < carNameArray.length; j++) {
                if (carName.equals(carNameArray[j])) {
                    throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
                }
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
