package racingcar.view;

import java.util.Set;

public class OutputWriter {

    public void printCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRaceCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceResultsMessage() {
        System.out.println("실행 결과");
    }

    public void getRaceResults(String name, int randomValue) {
        System.out.print(name + " : ");
        for (int i = 0; i < randomValue; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
