package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarController {
    public void run(){
        List<Car> cars = makeCars(InputView.inputCarNames());
        int numberOfRounds = InputView.inputNumberOfRounds();
        checkIfnumberOfRoundsIsValid(numberOfRounds);
        playGame(cars, numberOfRounds);
        List<String> winnersName = findWinnersName(cars);
        OutputView.printWinners(winnersName);
    }

    private void checkIfnumberOfRoundsIsValid(int numberOfRounds){
        if(numberOfRounds < 0) throw new IllegalArgumentException("횟수는 양수를 입력하세요.");
    }

    private void checkIfLengthOfNameIsValid(String name){
        if(name.isBlank() || name == null) throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        if(name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
    }

    private List<Car> makeCars(String[] carNames){
        List<Car> cars = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();

        for(String name : carNames){
            name = name.trim();
            checkIfLengthOfNameIsValid(name);

            if(!uniqueNames.add(name)){
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }

            cars.add(new Car(name));
        }
        return cars;
    }

    private void playOneRound(List<Car> cars){
        List<String> roundResults = new ArrayList<>();
        for(Car car : cars){
            if(Randoms.pickNumberInRange(0, 9) >= 4){
                car.move();
            }
            roundResults.add(car.getName() + " : " + car.displayPosition());
        }
        OutputView.printRoundResults(roundResults);
    }

    private void playGame(List<Car> cars, int numberOfRounds){
        OutputView.printResultMessage();
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
