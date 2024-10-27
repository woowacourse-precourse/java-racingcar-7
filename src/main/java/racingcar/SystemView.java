package racingcar;

public class SystemView {


    static void printSystemNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static void printSystemInputTrialMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    static void printSystemRaceStartMessage() {
        System.out.println("실행 결과");
    }

    static void printSystemWinneMessage() {
        System.out.print("최종 우승 : ");
    }
}
