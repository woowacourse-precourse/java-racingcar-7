package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showCarNamesPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void showAttemptCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void showRoundResultHeader() {
        System.out.println("실행 결과");
    }

    @Override
    public void showRoundResult(String result) {
        System.out.println(result);
    }

    @Override
    public void showWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
        Console.close();
    }
}
