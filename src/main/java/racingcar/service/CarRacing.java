package racingcar.service;

import racingcar.domain.Car;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class CarRacing {

    public void raceOneTurn(List<Car> cars){

        for(Car car : cars){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            car.move(randomNumber);
        }
    }

    public void printRoundResult(List<Car> cars){

        System.out.println("실행 결과");
        for(Car car : cars){
            String output = car.getName() + " : ";

            for (int i = 0; i < car.getPosition(); i++) {
                output += "-";
            }
            System.out.println(output);
        }
    }

    public List<Car> findWinners(List<Car> cars){

        List<Car> winners = new ArrayList<>();
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars){
            if (car.getPosition() > maxPosition){
               maxPosition = car.getPosition();
            }
        }

        for (Car car : cars){
            if (car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }
}
