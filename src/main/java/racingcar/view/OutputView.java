package racingcar.view;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printRacingProcess(List<String> carNames, Map<String, Integer> carProgress){
        System.out.println("실행 결과");
        for (String carName : carNames){
            System.out.print(carName + " : ");
            for (int i = 0; i < carProgress.get(carName); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

}
