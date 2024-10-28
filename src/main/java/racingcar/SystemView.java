package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class SystemView {


    static String printSystemNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    static String printSystemInputTrialMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    static void printSystemRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    static void printSystemWinneMessage() {
        System.out.print("최종 우승자 : ");
    }
}
