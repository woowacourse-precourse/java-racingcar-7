package racingcar;

public class OutputHandler {
    public static void runOutput(Racingcar[] racingcars){ // 실행 결과 출력
        for (int i = 0; i < racingcars.length; i++) {
            System.out.print(racingcars[i].getName()+" : ");
            for (int k = 0; k < racingcars[i].getMoveCount(); k++) {
                System.out.print("-");
            }
        }
    }

    public static void winnerOuput(Racingcar[] racingcars,int racingRound){   // 최종 우승자 출력
        int winnerCount = 0;
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < racingcars.length; i++) {
            if (winnerCount!=0) {
                System.out.print(", ");
            }
            if (racingcars[i].getMoveCount()==racingRound) {
                System.out.println(racingcars[i].getName());
            }
        }
    }
}
