package racingcar.input.car.name;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleCarNameInput implements CarNameInputHandler {
    @Override
    public String readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = Console.readLine();
        // 입력 유효성 검증 로직 추가 예정
        return carNameString;
    }
}
