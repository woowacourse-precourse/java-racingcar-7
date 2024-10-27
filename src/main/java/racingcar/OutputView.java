package racingcar;

public class OutputView {
    static void StartRace() {
        System.out.println();
        System.out.println("실행 결과");
    }

    static void CurrentPosition(String currentPosition){
        System.out.println(currentPosition);
    }

    static void RaceWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }
}
