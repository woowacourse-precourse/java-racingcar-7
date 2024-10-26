package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputConsole {
    public void run(){
        String carNames = readInput();
        Cars.createCarsFrom(carNames);
    }

    private String readInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }
}
