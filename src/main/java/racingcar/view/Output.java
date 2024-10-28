package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.List;

public class Output {
    public static final String RESULT = "\n실행결과\n";
    private static final String FINAL_RESULT = "최종 우승자 : ";
    public static void printResults(RacingCars racingCars){
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        racingCarList.stream()
                .forEach(cars -> System.out.print(cars.getCarName() + " : " + "-".repeat( cars.getCarPosition())+"\n"));
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
        System.out.println();
        System.out.print(FINAL_RESULT);
        for(int i = 0 ; i < racingCarList.size() ; i++){
            if(racingCarList.get(i).getCarPosition() == winnersPosition){
                System.out.print(racingCarList.get(i).getCarName() + ", ");
            }
        }
        System.out.print("\b\b");
    }
}
