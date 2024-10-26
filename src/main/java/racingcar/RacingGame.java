package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_ATTEMPTS = 1;

    private Car[] cars; // 경주 차량
    private int totalAttempts;

    public RacingGame() {

    }

    public void inputCars(String carNames){
        String[] carNameArray = carNames.split(",");
        cars = new Car[carNameArray.length];
        for(int i = 0; i < carNameArray.length; i++){
            validateCarName(carNameArray[i]);
            cars[i] = new Car(carNameArray[i]);
        }
    }

    private void validateCarName(String carName){
        if (carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
        }
    }

    public void inputAttempts(int totalAttempts){
        if (totalAttempts < MIN_ATTEMPTS) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        this.totalAttempts = totalAttempts;
    }

    public void start(){
        for(int i = 0; i < totalAttempts; i++){
            playRound();
        }
    }

    private void playRound(){
        for(Car car : cars){
            car.move();
        }
        printResult();
    }


    public void printResult(){
        for(Car car : cars){
            printCarPosition(car);
        }
        System.out.println();
    }

    private void printCarPosition(Car car){
        System.out.print(car.getName() + " : ");
        for(int i = 0; i < car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = getWinners(maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> getWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }


    // 최대 위치를 계산하는 메소드
    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
