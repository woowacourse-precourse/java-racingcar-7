package racingcar.view;
import  camp.nextstep.edu.missionutils.Console;
import racingcar.validation.RaceValidator;

public class InputView {
    private String participantNames;
    private int attempts;

    private String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public String inputParticipantNames() {
        participantNames = input("경주할 자동차 이름을 입력하세요.");
        return participantNames;
    }

    public int inputAttempts() {
        String input = input("시도할 횟수는 몇 회인가요?");
        if(RaceValidator.validateTryCount(input)){
            return attempts = Integer.parseInt(input);
        }
        return attempts;
    }


}
