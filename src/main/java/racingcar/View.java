package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    // 자동차 입력
    public static String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    // 시도 횟수
    public static int enterNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(readLine());
    }

    // 실행 결과 멘트
    public static void outputExecutionResultComment() {
        System.out.println("실행 결과");
    }

    // 경기 진행 상황 출력
    public static void gameProgressOutput(Car car) {
        System.out.print(car.getCar() + " : " + car.getTravelDistance());
        System.out.println();
    }

    // 단독 우승자 발표
    public static void soloWinnerAnnouncement(List<Car> winner) {
        System.out.print("최종 우승자 : ");
        System.out.println(winner.get(0).getCar());
    }

    // 공동 우승자 발표
    public static void jointWinnersAnnounced(List<Car> winner) {
        System.out.print("최종 우승자 : ");
        for(int count = 0; count < winner.size(); count++) {
            if(count == winner.size() - 1) {
                System.out.println(winner.get(count).getCar());
            } else {
                System.out.print(winner.get(count).getCar() + ", ");
            }
        }
    }
}
