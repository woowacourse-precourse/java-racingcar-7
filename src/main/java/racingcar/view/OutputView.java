package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Utils;

public class OutputView {
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void inputMessage(){
        System.out.println(Utils.INPUT_MESSAGE);
    }

    public void inputCountMessage(){
        System.out.println(Utils.INPUT_COUNT_MESSAGE);
    }

    public void printAdvance(List<Car> cars){
        for (Car car : cars) {
            car.printStatus();
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerNames){
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winnerNames));
    }
}
