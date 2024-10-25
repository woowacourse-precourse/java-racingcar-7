package racingcar.view;

import racingcar.model.car.Car;

import java.util.List;

public class OutputView {
    private static final String SEPARATOR = " : ";
    private static final String PROGRESS_BAR = "-";
    private static final String END_LINE = "\n";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void printCarProgress(List<Car> carList){

        for(Car car : carList){
            printSingleCarProgress(car);
        }
        printEndLine();
    }

    public static void printWinner(String winners){
        System.out.println(FINAL_WINNER + winners);
    }

    private static void printSingleCarProgress(Car car){
        System.out.println(car.getName() + SEPARATOR + PROGRESS_BAR.repeat(car.getProgress()));
    }

    private static void printEndLine(){
        System.out.println(END_LINE);
    }
}
