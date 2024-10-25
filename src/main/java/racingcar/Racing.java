package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    private final List<Car> cars;
    private final Output output;

    public Racing(List<Car> cars){
        this.cars = cars;
        this.output = new Output();
    }

    public void play(int rounds){
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++){
            playRound();
            output.printRoundResult(cars);
        }
    }

    public void playRound(){
        for (Car car : cars){
            if (canMove()){
                car.move();

            }
        }
    }

    public List<Car> getWinners(){
        int maxPosition = cars.stream()
                                .mapToInt(Car::getPosition)
                                .max()
                                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public boolean canMove(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

}
