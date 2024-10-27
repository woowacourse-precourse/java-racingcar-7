package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarView {

    public String getCarNameInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String getTryCount() {

        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void printResult(String result, String winnerInfo) {

        StringBuilder resultBuilder = new StringBuilder()
                .append("실행 결과").append("\n")
                .append(result)
                .append("최종 우승자 : ").append(winnerInfo);

        System.out.println(resultBuilder.toString());

        Console.close();
    }
}
