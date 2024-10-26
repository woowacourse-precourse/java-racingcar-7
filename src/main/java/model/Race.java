package model;

import service.MoveStrategy;
import service.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private final List<Car> cars;
    private final int attempts;
    private final MoveStrategy moveStrategy;
    public Race(List<String> carNames, int attempts, MoveStrategy moveStrategy) {
        if(attempts < 0) {
            throw new IllegalArgumentException("attempts can't be less than 0");
        }
        this.cars = new ArrayList<>(carNames.size());
        this.attempts = attempts;
        this.moveStrategy = moveStrategy;
        for(String name : carNames) {
            this.cars.add(new Car(name));
        }
    }

    public void startRace(){
        Random rand = new Random();
        for(int i = 0; i < attempts; i++) {
            for(Car car : cars) {
                car.move(moveStrategy.canMove());
            }
            printRaceStatus();
        }
    }

    private void printRaceStatus() {
        for(Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public List<String> getWinner(){
       List<String> winners = new ArrayList<>();
       int winnerPosition = cars.stream().mapToInt(Car::getPositon).max().orElse(0);
       for (Car car: cars) {
           if(car.getPositon() == winnerPosition) {
               winners.add(car.toString());
           }
       }
       return winners;
    }

    public void printWinner(){
        List<String> winners = getWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}