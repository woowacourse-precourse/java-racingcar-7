package racingcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Output {
    private static final String CAR_NAME_REQUEST_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_REQUEST_MESSAGE =
            "시도할 횟수는 몇 회인가요?";
    private static final String RUN_RESULT_MESSAGE =
            "실행 결과";
    private static final String FINAL_WINNER_MESSAGE =
            "최종 우승자 : ";

    public static void printCarNameRequestMessage(){
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    public static void printNumberRequestMessage(){
        System.out.println(NUMBER_REQUEST_MESSAGE);
    }

    public static void printRunResultMessage(){
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public static void printRunResult(List<Car> carList){
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    public static void printFinalWinner(List<Car> winnerCarList){
        System.out.println(FINAL_WINNER_MESSAGE + joinCarName(winnerCarList));
    }

    public static void printBlankLine(){
        System.out.println();
    }

    private static StringJoiner joinCarName(List<Car> carList){
        StringJoiner finalWinner = new StringJoiner(", ");
        for (Car car : carList) {
            finalWinner.add(car.getName());
        }
        return finalWinner;
    }
}
