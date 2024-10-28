package model;

import camp.nextstep.edu.missionutils.Randoms;
import view.OutputView;

import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car>cars){
        this.cars = cars;
    }

    public void proceedRace(int attempts){ //사용자로부터 입력받은 총 이동 시도 횟수(n값)
        for (int i=0;i<attempts;i++){
            playRound(); //무작위 값을 생성하고, 이 무작위 값이 조건을 만족하면 자동차를 이동
            OutputView.printRoundResult(cars); //한 라운드가 지나고 자동차의 위치
        }
    }

    private void playRound() {
       cars.forEach(this::moveCar);
    }

    private void moveCar(Car car) {
        int randomValue = Randoms.pickNumberInRange(0,9);
        car.move(randomValue);
    }

    public List<Car> getWinners(){
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0); //가장 멀리 이동한 자동차의 position을 반환
        return cars.stream().filter(car->car.getPosition()==maxPosition).toList(); //반환된 position값을 바탕으로 그 위치와 같은 자동차를 리스트로 필터링
    }
}
