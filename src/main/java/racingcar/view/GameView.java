package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public final class GameView {
    public String getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Console.readLine().trim();
    }

    public String getTotalRoundInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return Console.readLine().trim();
    }

    public void displayGameStart() {
        System.out.println("실행 결과");
    }

    public void displayCarPosition(String carPosition) {
        System.out.println(carPosition);
    }

    public void displayNewLine() {
        System.out.println();
    }
}