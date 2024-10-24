package racingcar.Model;

import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.Utils;
import racingcar.View.OutputView;

public class RacingCars {
    private final ArrayList<Car> racingCars = new ArrayList<>();

    public RacingCars(ArrayList<String> nameList){
        nameList.forEach(car -> racingCars.add(new Car(car)));
    }

    public void playRound() {
        simulation();
        OutputView.printRoundResult(new ArrayList<>(racingCars.stream()
                .map(Car::getRoundResult)
                .collect(Collectors.toList())));
    }
    private void simulation(){
        racingCars.forEach(Car::go);
    }

    public void printWinner() {
        ArrayList<Integer> carPositions = getPositions();
        OutputView.printWinners(new ArrayList<>(racingCars.stream()
                .filter(car -> car.checkWinner(Utils.getMax(carPositions)))
                .map(Car::getName)
                .collect(Collectors.toList())
        ));
    }
    private ArrayList<Integer> getPositions(){
        ArrayList<Integer> positions = new ArrayList<>();
        racingCars.forEach(car -> positions.add(car.getPosition()));
        return positions;
    }
}
