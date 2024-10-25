package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class Race {


    private static int goalCnt;

    public static void startRace(List<RacingCar> racingCars, int tryNumber) {

        goalCnt = tryNumber;

        while(true) {
            for(RacingCar car : racingCars) {
                tryStepForward(car);
                printStep(car);
            }
            System.out.println();

            if(isRaceEnd(racingCars))
                break;
        }

        endRace(racingCars);
    }

    private static void tryStepForward(RacingCar car) {

        // 0에서 9까지의 정수 중 한 개의 정수 반환
        int selectNum = Randoms.pickNumberInRange(0, 9);
        if (selectNum >= 4)
            car.increaseCnt();
    }

    private static boolean isRaceEnd(List<RacingCar> racingCars) {

        for(RacingCar car : racingCars)
            if (car.getCnt() == goalCnt)
                return true;

        return false;
    }

    private static void printStep(RacingCar car) {

        System.out.print(car.getCarName() + " : ");
        for(int i = 0; i < car.getCnt(); i++)
            System.out.print("-");
        System.out.println();
    }

    private static void endRace(List<RacingCar> racingCars){

        List<String> winner = new ArrayList<>();
        for(RacingCar car : racingCars)
            if(car.getCnt() == goalCnt)
                winner.add(car.getCarName());

        System.out.println("최종 우승자 : "+ String.join(", ", winner) );
    }
}
