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
}
