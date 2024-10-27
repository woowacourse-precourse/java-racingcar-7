package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static final int NAME_HANDLING_CRITERIA = 5;
    public static final int RANDOM_CONDITIONS = 4;
    public static final String BAR = "-";

    public static void main(String[] args) {
        // 자동차 이름 받기
        // String => String[] 을 위한 split
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.replaceAll(" ", "").split(",");

        // 시도할 횟수 입력 받기
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();
        int count = Integer.parseInt(inputCount);
    }
}
