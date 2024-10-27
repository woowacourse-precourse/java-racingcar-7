package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import java.util.List;

public class OutputView {
    private static final String START_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER_NAME = "최종 우승자 : ";
    private static int count = 0;
    public void printGameStart(){
        System.out.println(START_COMMENT);
    }
    public void printTryInput(){
        System.out.println(INPUT_TRY_COUNT);
    }
    public void printResult(){
        System.out.println(GAME_RESULT);
    }
    public void printExecuteResult(Cars cars){
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println(car.getCarName() + " : "+"-".repeat(car.getDistance()));
        }
        System.out.println();
    }
    public void printWinner(Cars cars, int maxDistance,int winnerCount){
        List<Car> carList = cars.getCars();
        System.out.print(WINNER_NAME);
        for(Car car : carList){
            printWinnerName(car, maxDistance, winnerCount);
        }
    }
    public void printWinnerName(Car car, int maxDistance, int winnerCount){
        if(maxDistance == car.getDistance()){
            System.out.print(car.getCarName());
            if (winnerCount > count){
                System.out.print(", ");
                count += 1;
            }
        }
    }
}
