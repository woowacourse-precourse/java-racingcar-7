package race;

import racingcar.Car;
import racingcar.Round;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private List<Round> rounds;

    public Race(){
        setCars(new ArrayList<>());
        setRounds(new ArrayList<>());

    }

    public List<Car> getCars() {
        return cars;

    }

    private void setCars(List<Car> cars) {
        this.cars = cars;

    }

    public List<Round> getRounds() {
        return rounds;

    }

    private void setRounds(List<Round> rounds) {
        this.rounds = rounds;

    }

    public void addPlayer(Car car){
        this.cars.add(car);

    }

    public void playRound(){
        Round round = new Round();

        for(Car car : cars){
            car.moveCar();
            round.addResult(car);
        }

        rounds.add(round);
    }

    public String printFinalResult(){
        int maxBound = 0;
        List<String> winners = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for(Car car : cars)
            maxBound = fixFinalWinner(winners, car, maxBound);

        for(String winner : winners){
            result.append(winner).append(",");
        }

        result.deleteCharAt(result.length()-1);

        return result.toString();
    }

    private int fixMaxBound(Car car, int maxBound){
        return Math.max(car.getMoveCount(), maxBound);

    }

    private int fixFinalWinner(List<String> winners, Car car, int maxBound){
        if(car.getMoveCount() > maxBound){
            maxBound = fixMaxBound(car, maxBound);
            winners.clear();
            winners.add(car.getCarName());
        }else if(car.getMoveCount() == maxBound){
            winners.add(car.getCarName());
        }

        return maxBound;

    }

}
