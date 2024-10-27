package racingcar.views;

import camp.nextstep.edu.missionutils.Console;

public class IOView {
    private static final String CAR_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String RESULTS_HEADER = "\n실행 결과";
    private static final String WINNERS_PREFIX = "최종 우승자 : ";

    public String getCarInput() {
        System.out.println(CAR_PROMPT);
        return Console.readLine().strip();
    }

    public String getRoundInput() {
        System.out.println(ROUND_PROMPT);
        return Console.readLine().strip();
    }

    public void printResultsHeader() {
        System.out.println(RESULTS_HEADER);
    }

    public void printWinners(String winners) {
        System.out.println(WINNERS_PREFIX + winners);
    }
}
