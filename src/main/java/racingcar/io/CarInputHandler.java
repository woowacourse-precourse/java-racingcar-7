package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class CarInputHandler extends InputHandler {

    private static final int NAME_LENGTH_LIMIT = 5;

    public String[] inputRacerNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] splitNames = names.split(",");
        for (String name : splitNames) {
            if (name.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException("이름은 5자 이하로만 입력 가능합니다.");
            }
        }
        return splitNames;
    }
}
