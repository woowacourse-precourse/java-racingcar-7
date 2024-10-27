package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameInputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return validateCarNames(input);
    }

    public List<String> validateCarNames(String input) {
        String[] names = input.split(",");
        Set<String> uniqueNames = new HashSet<>();

        List<String> validNames = new ArrayList<>();
        for (String name : names) {
            name = name.trim();
            if (name.length() == 0) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("동일한 이름의 자동차가 있을 수 없습니다.");
            }
            validNames.add(name);
        }
        return validNames;
    }

}
