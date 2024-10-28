package racingcar.view;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printRacingProcessHeader(){
        System.out.println("실행 결과");
    }

    public static void printRacingProcess(List<String> carNames, Map<String, Integer> carProgress){
        for (String carName : carNames){
            printCarProcess(carName, carProgress.get(carName));
        }
        System.out.println();
    }

    public static void printCarProcess(String carName, Integer carProgress){
        System.out.print(carName + " : ");
        for (int i = 0; i < carProgress; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(StringBuilder winners){
        System.out.println("최종 우승자 : " + winners);

    }
}
