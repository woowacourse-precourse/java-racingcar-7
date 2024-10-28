package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Winner;

import java.util.List;

public class OutputView {
    private static final String RESULT_COMMAND = "\n실행 결과";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String HYPHEN = "-";
    private static final String WINNER = "최종 우승자";

    public static void printResultCommand(){
        System.out.println(RESULT_COMMAND);
    }

    public static void printRoundResult(List<Car> carList){
        for (Car car : carList) {
            System.out.println(car.getName() + COLON + repeatHyphen(car.getPosition()));
        }
    }

    public static void printWinner(Winner winnerList){
        var winnerNameList = winnerList.getWinnerNameList();
        System.out.println(WINNER + COLON + String.join(COMMA, winnerNameList));
    }

    private static String repeatHyphen(int position){
        return HYPHEN.repeat(position);
    }
}
