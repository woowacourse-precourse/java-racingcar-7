package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final String SPLITTER = ",";

    public static void main(String[] args) {
        List<RacingCar> cars = getCarInput();
        Integer trial = getTrial();

    }

    //경주할 자동차 입력 받기
    public static List<RacingCar> getCarInput(){
        String input = Console.readLine();
        String[] racingCars = input.split(SPLITTER);
        //기능 분리하기
        List<RacingCar> racingCarList = new ArrayList<>();
        int numOfCars = racingCars.length;
        for(String carName : racingCars){
            RacingCar racingCar = new RacingCar(carName, numOfCars);
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

    //시도 횟수 입력 받기
    public static Integer getTrial(){
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
