package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarRace;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Service { // TODO: 이름 더 명확하게 개선
    private final CarRace carRace;

    public Service(CarRace carRace) {
        this.carRace = carRace;
    }

    public void operate(List<String> names, String attemptNumber) {
        List<Boolean> initialRandoms = getRandom(names.size() * convertType(attemptNumber));
        List<List<Boolean>> randoms = cutRandom(initialRandoms, names.size());
        initialize(names);
        move(randoms);
    }

    public List<Car> getWinner() {
        return carRace.findWinners();
    }

    private int convertType(String attemptNumber) {
        return Integer.parseInt(attemptNumber);
    }

    private List<Boolean> getRandom(int randomSize){
        List<Boolean> isAdvance = new ArrayList<>();
        for (int i = 0; i < randomSize; i++) {
            if (pickRandom() >= 4) {
                isAdvance.add(true);
                continue;
            }
            isAdvance.add(false);
        }
        return isAdvance;
    }

    private List<List<Boolean>> cutRandom(List<Boolean> randoms, int pivot) {
        List<List<Boolean>> dividedRandoms = new ArrayList<>();
        for (int i = 0; i < randoms.size(); i += pivot) {
            dividedRandoms.add(new ArrayList<>(randoms.subList(i, i + pivot)));
        }
        return dividedRandoms;
    }

    private void initialize(List<String> names) {
        carRace.initialize(names);
    }

    private void move(List<List<Boolean>> randoms) {
        for (int i = 0; i < randoms.size(); i++) {
            carRace.advanceCars(randoms.get(i));
            OutputView.printResult(carRace.getCars()); // TODO: 외부에서 출력하도록 리팩토링
        }
    }

    private int pickRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
