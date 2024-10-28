package racingcar;

import camp.nextstep.edu.missionutils.*;

public class Racing {

    public void run(){
        InputView input = new InputView();
        OutputView output = new OutputView();

        Car[] cars = input.getCars();
        int rounds = input.getNumberOfRounds();

        System.out.println("\n실행 결과");

        for(int i = 0; i < rounds; i++){
            playGround(cars);
            output.printRoundResult(cars);
        }

        output.printWinners(findWinners(cars));
    }

    private void playGround(Car[] cars){
        for(Car car : cars){
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    private String findWinners(Car[] cars) {
        int maxDistance = 0;
        StringBuilder winners = new StringBuilder();

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
                winners.setLength(0);  // 기존 우승자 목록을 초기화
                winners.append(car.getName());
            } else if (car.getDistance() == maxDistance) {
                winners.append(", ").append(car.getName());
            }
        }

        return winners.toString();
    }

}
