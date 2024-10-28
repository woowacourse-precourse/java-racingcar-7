package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public static void readRacingInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameString = readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryCount = Integer.parseInt(readLine());
        } catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException();
        }

    }
}