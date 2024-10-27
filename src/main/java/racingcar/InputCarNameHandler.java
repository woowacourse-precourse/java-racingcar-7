package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputCarNameHandler {
    public List<String> getCarNames(){
        List<String> carNames = new ArrayList<>();
        String inputCarNames;

        System.out.print("경주할 자동차 이름을 2대 이상 입력하세요. : ");
        inputCarNames = Console.readLine();

        String[] names = inputCarNames.split(",");

        for (String name : names) {
            String trimmedName = name.trim();
            isValidCarName(trimmedName, carNames);
            carNames.add(trimmedName);
        }

        if (carNames.size() < 2 || carNames.size() > 11) {
            throw new IllegalArgumentException("최소 2개부터 최대 10개까지 입력이 가능합니다.");
        }

        return carNames;
    }

    private void isValidCarName(String name, List<String> carNames) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 칸 혹은 공백은 사용이 불가합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 합니다.");
        }
        if (!name.matches("[a-zA-Z0-9가-힣]*")) {
            throw new IllegalArgumentException("특수기호는 사용이 불가합니다.");
        }
        if (carNames.contains(name)) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
    }
}

