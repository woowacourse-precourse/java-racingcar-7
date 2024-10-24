package racingcar.Model;

import java.util.ArrayList;
import java.util.stream.Collectors;
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
}
