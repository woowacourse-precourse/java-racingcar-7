package racingcar.view;
import  camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String participantList;
    private String tryTo;

    private String input(String message) {
        System.out.println(message);
        return Console.readLine(); // 입력 메시지를 인자로 받아 출력하고 값을 반환
    }
    public void inputCarNames() {
        participantList = input("경주할 자동차 이름을 입력하세요.");
    }
    public void inputTryTo(){
        tryTo = input("시도할 횟수는 몇 회인가요?");
    }


}
