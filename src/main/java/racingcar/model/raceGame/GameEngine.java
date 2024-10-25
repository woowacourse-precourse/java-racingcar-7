package racingcar.model.raceGame;

import racingcar.model.car.Car;
import racingcar.model.car.CarRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GameEngine {
    private final CarRepository carRepository;
    private final List<String> winners;
    private static final int PROGRESS_CONDITION = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;


    public GameEngine(CarRepository carRepository){
        this.carRepository = carRepository;
        this.winners = new ArrayList<>();
    }

    public void runSingleRound(){
        for(Car car: carRepository.getCarList()){
            updateCarProgress(car, generateRandomNumber());
        }
    }

    public void decideWinners(){
        int maxWin = calculateMaxWins();
        for(Car car : carRepository.getCarList()){
            decideIfWinner(car, maxWin);
        }
    }

    public List<String> getWinners(){
        return Collections.unmodifiableList(winners);
    }

    private int calculateMaxWins(){
        int maxWin = 0;
        for(Car car : carRepository.getCarList()){
            maxWin = getMaxWin(maxWin, car.getProgress());
        }
        return maxWin;
    }

    private int getMaxWin(int maxWin, int currentProgress){
        return Math.max(maxWin, currentProgress);
    }

    private void decideIfWinner(Car car, int maxWin){
        if(car.getProgress() == maxWin){
            addToWinner(car.getName());
        }
    }

    private void addToWinner(String name){
        winners.add(name);
    }

    private int generateRandomNumber(){
        return Randoms.pickNumberInRange(RANDOM_MIN,RANDOM_MAX);
    }

    private void updateCarProgress(Car car, int random){
        if(random >= PROGRESS_CONDITION){
            car.updateProgress();
        }
    }
}
