package racingcar.view;
import  camp.nextstep.edu.missionutils.Console;
import racingcar.validation.RaceValidator;

public class InputView {
    private String participantList;
    private int tryTo;
    private final RaceValidator raceValidator;

    public InputView(){
        this.raceValidator = new RaceValidator();
    }

    private String input(String message) {
        System.out.println(message);
        return Console.readLine(); // 입력 메시지를 인자로 받아 출력하고 값을 반환
    }

    public String inputCarNames() {
        participantList = input("경주할 자동차 이름을 입력하세요.");
        raceValidator.validateCarName(participantList);
        return participantList;
    }

    public int inputTryTo() {
        String input = input("시도할 횟수는 몇 회인가요?");
        if(raceValidator.validateTryCount(input)){
            return tryTo = Integer.parseInt(input);
        }
        return tryTo;
    }


}
