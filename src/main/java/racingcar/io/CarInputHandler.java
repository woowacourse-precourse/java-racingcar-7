package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class CarInputHandler extends InputHandler {

    private static final int NAME_LENGTH_LIMIT = 5;

    public String[] inputRacerNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        return splitNamesByComma(names);
    }

    public String[] splitNamesByComma(String names) {
        String[] splitNames = names.split(",");
        if (splitNames.length == 0) {
            throw new IllegalArgumentException("입력된 이름이 없습니다.");
        }
        for (String name : splitNames) {
            if (names.isBlank()) {
                throw new IllegalArgumentException("이름에 공백은 입력할 수 없습니다.");
            } else if (name.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException("이름은 5자 이하로만 입력할 수 있습니다.");
            }
        }
        return splitNames;
    }
}
