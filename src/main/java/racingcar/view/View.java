package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.RacingCar;

public class View {
    public void Message() {
        System.out.println("자동차 대수는 몇 대 인가요?(쉼표(,)를 기준으로 구분)");
    }

    public static void RoundAskMessage() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public String userInput() {
        return Console.readLine();
    }

    public void executeMoveMessage() {
        System.out.println("실행 결과");
    }

    public void RoundResultMessage() {
        System.out.println(RacingCar.getName() + " : " );
        for(int i = 0; i < RacingCar.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
