package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class RacingView {

    // 자동차 이름 입력 받기
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표로 구분)");
        return Console.readLine().trim().split(",");
    }

    // 시도 횟수 입력 받기
    public int getRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    // 각 차수별로 자동차 상태 출력
    public void printCarStates(Map<String, String> carStates) {
        for (Map.Entry<String, String> entry : carStates.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
