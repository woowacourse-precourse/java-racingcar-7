package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가?";
	
    public static void main(String[] args) {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        String [] carNames = input.split(",");
        
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        int count = Integer.parseInt(Console.readLine());
    }
}
