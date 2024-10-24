package racingcar.handler;

import java.util.List;

public class PrintHandler {
    private static final String RACING_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RACING_RESULT_START_MESSAGE = "실행 결과";


    public void racingStartMessage() {
        System.out.println(RACING_START_MESSAGE);
    }

    public void racingNumberMessage() {
        System.out.println(RACING_NUMBER_MESSAGE);
    }

    public void racingResultStartMessage() {
        System.out.println(RACING_RESULT_START_MESSAGE);
    }

    public void printCurrentPositions(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            int position = positions.get(i);
            System.out.println(carName + " : " + "-".repeat(position));
        }
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}