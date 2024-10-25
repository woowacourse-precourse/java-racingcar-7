package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    public void run(){
        List<Car> cars = makeCars(InputView.inputCarNames());
        int numberOfRounds = InputView.inputNumberOfRounds();
        playGame(cars, numberOfRounds);
        // Todo. OutView 에서 List<String> Winners 을 형식에 맞게 출력하는 코드 구현해서 추가
    }

    private List<Car> makeCars(String[] carNames){
        ArrayList<Car> cars = new ArrayList<>();
        for(String name : carNames){
            cars.add(new Car(name));
        }
        return cars;
    }

    private void playOneRound(List<Car> cars){
        for(Car car : cars){
            if(Randoms.pickNumberInRange(0, 9) >= 4){
                car.move();
            }
        }
        // Todo. OutputView 에서 각 라운드 종료 이후 각 car 의 position 을 형식에 맞게 출력하는 코드 구현해서 추가
    }

    private void playGame(List<Car> cars, int numberOfRounds){
        for(int i = 0; i < numberOfRounds; i++){
            playOneRound(cars);
        }
    }

    private List<String> findWinnersName(List<Car> cars){
        int maxPosition = 0;
        for(Car car : cars){
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }

        List<String> Winners = new ArrayList<>();

        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                Winners.add(car.getName());
            }
        }

        return Winners;
    }
}
