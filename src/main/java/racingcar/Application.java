package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static List<String> car = new ArrayList<>();
    private static int count;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printInputCar();
        car = inputView.getInputCars();
        outputView.printInputTryCount();
        count = inputView.getInputCount();
        int[] forward = new int[car.size()];
        int Nmax = 0;
        
        for(int i = 0; i<count; i++){
            for(int j = 0; j<car.size(); j++) {
                int num = Randoms.pickNumberInRange(0, 9);
                if(num >= 4){
                    forward[j]++;
                }
                Nmax = Math.max(Nmax,forward[j]);
                System.out.print(car.get(j) + " : ");
                for(int h = 0; h<forward[j]; h++){
                    System.out.print("-");
                }
                System.out.println();
            }
        }
        System.out.print("최종 우승자 : ");
        for(int i = 0; i<car.size(); i++){
            if(forward[i] == Nmax){
                System.out.print(car.get(i) + ", ");
            }
        }
    }
}
