package racingcar.racingcarView;


import camp.nextstep.edu.missionutils.Console;
import java.util.Map.Entry;

public class CarView {

    public String readInput() {
        return Console.readLine();
    }

    public void printNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printStartResults() {
        System.out.println("실행 결과");
        System.out.println();
    }

    public void printResults(Entry<String, Integer> entry) {
        System.out.println(entry.getKey()+ " : " + "-".repeat(entry.getValue()) );
    }



    public void printWinners(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

}
