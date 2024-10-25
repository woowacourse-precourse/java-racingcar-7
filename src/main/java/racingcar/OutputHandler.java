package racingcar;

import java.util.List;

public class OutputHandler {
    public static void runOutput(Racingcar[] racingcars){ // 실행 결과 출력
        for (int i = 0; i < racingcars.length; i++) {
            System.out.print(racingcars[i].getName()+" : ");
            for (int k = 0; k < racingcars[i].getMoveCount(); k++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void winnerOuput(List<Racingcar> winner){   // 최종 우승자 출력
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            if (i!=0) {
                System.out.print(", ");
            }
            System.out.print(winner.get(i).getName());
        }
    }
}
