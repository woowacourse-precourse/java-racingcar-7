package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameView {

    public void carNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void trialCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String getCarNames(){
        return Console.readLine();
    }

    public int getTrialCount(){
        return Integer.parseInt(Console.readLine());
    }

    public void showTrialResultsMessage(){
        System.out.println("\n실행 결과\n");
    }
}
