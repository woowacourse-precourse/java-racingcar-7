package iohandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputHandler {

    public static final String inputCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String inputRacingCountMessage = "시도할 횟수는 몇 회인가요?";

    public void showInputCarNameMessage() {
        System.out.println(inputCarNameMessage);
    }

    public void showInputRacingCountMessage() {
        System.out.println(inputRacingCountMessage);
    }
}
