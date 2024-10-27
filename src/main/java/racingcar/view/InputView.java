package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {

    }

    public String[] inputCarNameGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return seperatePlayers(Console.readLine());
    }

    public String[] seperatePlayers(String players) {
        validEndWithComma(players);
        return players.split(",");
    }

    public static void validEndWithComma(String players) {
        if(players.endsWith(",")) {
            throw new IllegalArgumentException(",를 마지막으로 입력하면 안됩니다");
        }
    }

    public int inputRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int round = Integer.parseInt(Console.readLine());
        roundException(round);
        return round;
    }

    public void roundException(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("시도횟수는 최소 한번 이상이어야 합니다");
        }
    }

}
