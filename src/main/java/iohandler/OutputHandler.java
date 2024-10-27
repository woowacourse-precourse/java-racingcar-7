package iohandler;

import domain.Car;

import java.util.List;

public class OutputHandler {

    public void printResult(List<Car> cars){
        for (Car car : cars) {
            printPosition(car);;
        }
        System.out.println();
    }

    private void printPosition(Car car){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++){
            sb.append("-");
        }
        System.out.println(car.getName() + " : " + sb.toString());
    }

    public void printWinners(List<Car> cars){
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }

        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition){
                if(!winners.isEmpty()){
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + winners);

    }


}
