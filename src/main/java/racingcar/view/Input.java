package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<String> getCarNames() {
        String input = Console.readLine();
        if (input == null || input.contains("null")) {
            throw new IllegalArgumentException("자동차 이름에 null이 포함되어 있습니다.");
        }
        if (input.matches("[,]+")) {
            throw new IllegalArgumentException("입력값에 ','만 존재합니다.");
        }

        String[] carNamesInput = input.split(",");
        List<String> carNames = new ArrayList<>();

        Arrays.stream(carNamesInput).forEach(carName -> {
            carName = carName.trim();
            if (carName.isEmpty() || carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
            } else if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }

            carNames.add(carName);
        });

        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
        return carNames;
    }

    public int getTryNum() {
        int tryNum = 0;
        try {
            tryNum = Integer.parseInt(Console.readLine());
            if (tryNum <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 숫자가 입력되었습니다.", e);
        }

        return tryNum;
    }
}
