package racingcar.racingcarView;


import camp.nextstep.edu.missionutils.Console;

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

    public void printRunResults() {
        System.out.println("실행 결과");
        System.out.println();
    }

    public void printResults() {
        System.out.println();
    }



    public void printWinners(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

}
