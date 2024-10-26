package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    private static final String START_COMMAND="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNTS="시도할 횟수는 몇 회인가요?";
    private static final String RACING_PROCESS="실행 결과";
    private static final String RACING_WINNER="최종 우승자 : %s";

    public static void printCarsInputCommand(){
        System.out.println(START_COMMAND);
    }

    public static void printGameCountsCommand(){
        System.out.println(RACING_COUNTS);
    }

    public static void printRacingProcessCommand(){
        System.out.println();
        System.out.println(RACING_PROCESS);
    }

    public static void printRacingWinner(String result){
        System.out.printf(RACING_WINNER,result);
    }

    public void printCarsState(Cars cars) {
        List<Car> carList=cars.getClonedCars();

        for (Car car:carList){
            System.out.println(String.join(" : ",car.getName(),car.getState()));
        }
    }
}
