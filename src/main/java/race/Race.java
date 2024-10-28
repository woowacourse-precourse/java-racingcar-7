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


}
