package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public List<String> getCarNames() {
        String[] carNamesInput = Console.readLine().split(",");

        Arrays.stream(carNamesInput).forEach(carName -> {
            if (carName.equals("null") || carName == null) {
                throw new IllegalArgumentException("자동차 이름에 null이 포함되어 있습니다.");
            } else if (carName.isEmpty() || carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
            } else if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        });

        List<String> carNames = Arrays.stream(carNamesInput)
            .map(String::trim)
            .collect(Collectors.toList());

        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
        return carNames;
    }

    public int getTryNum() {
        int tryNum = Integer.parseInt(Console.readLine());
        return tryNum;
    }

}
