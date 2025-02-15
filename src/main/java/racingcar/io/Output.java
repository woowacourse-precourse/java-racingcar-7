package racingcar.io;

import java.util.List;

public class Output {

    public void printInputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printExecuteCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacingResult() {
        System.out.println("\n실행 결과");
    }

    public void printRaceProcess(List<String> process) {
        process.forEach(System.out::println);
        System.out.println();
    }

    public void printWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

}
