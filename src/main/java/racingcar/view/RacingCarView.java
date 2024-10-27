package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingCarView {
    public List<String> getCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameList = Console.readLine();
        return List.of(carNameList.split(","));
    }
    public int getTryCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
