package racingcar.view;
import  camp.nextstep.edu.missionutils.Console;
import racingcar.validation.RaceValidator;

public class InputView {
    private String participantList;
    private int tryTo;

    private String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public String inputCarNames() {
        participantList = input("경주할 자동차 이름을 입력하세요.");
        return participantList;
    }

    public int inputTryTo() {
        String input = input("시도할 횟수는 몇 회인가요?");
        if(RaceValidator.validateTryCount(input)){
            return tryTo = Integer.parseInt(input);
        }
        return tryTo;
    }


}
