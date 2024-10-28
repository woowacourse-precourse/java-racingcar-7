package view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String NUMBER_OF_ATTEMPTS_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String carNameInput(){
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public int numberOfAttemptsInput(){
        System.out.println(NUMBER_OF_ATTEMPTS_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
