package racingcar.view;

import racingcar.Domain.RacingCar;
import racingcar.Domain.RacingCars;

import java.util.List;

public class Output {
    private static final String RESULT = "실행결과\n";
    private static final String FINAL_RESULT = "가 최종 우승했습니다";
    public static void printResults(RacingCars racingCars){
        System.out.print(RESULT);
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        racingCarList.stream()
                .forEach(cars -> System.out.println(cars.getCarName() + " : " + "-".repeat( cars.getCarPosition())));
        System.out.println();
    }

    public static int findWinnersPosition(RacingCars racingCars){
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        int maxPosition = 0;
        for(int i = 0 ; i < racingCarList.size() ; i++){
            maxPosition = findBigger(racingCarList.get(i).getCarPosition(), maxPosition);
        }
        return maxPosition;
    }

    public static int findBigger(int n, int m){
        if(n > m){
            return n;
        }
        return m;
    }

    public static void printFinalResult(RacingCars racingCars){
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        int winnersPosition = findWinnersPosition(racingCars);
        for(int i = 0 ; i < racingCarList.size() ; i++){
            if(racingCarList.get(i).getCarPosition() == winnersPosition){
                System.out.print(racingCarList.get(i).getCarName() + ", ");
            }
        }
        System.out.print("\b\b" + FINAL_RESULT);
    }
}
