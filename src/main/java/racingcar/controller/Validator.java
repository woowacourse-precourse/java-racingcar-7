package racingcar.controller;

import java.util.List;

public class Validator {
    public List<String> validateCarName(String input) {

        checkDelimiter(input);

        List<String> carNameList = List.of(input.split(","));

        for (String name : carNameList) {
            checkNameLength(name);
        }
        return carNameList;
    }

    public void checkDelimiter(String name) {
        if (!name.contains(",")) {
            throw new IllegalArgumentException("(,)로 구분하여 입력해주세요.");
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
        }
    }

    public int validateGameCount(int gameCount) {
        if (gameCount <= 0) {
            throw new IllegalArgumentException("게임횟수는 1부터 입력 가능합니다");
        }
        return gameCount;
    }
}
