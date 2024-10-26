package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service { // TODO: 이름 더 명확하게 개선
    CarManager carManager = new CarManager(); // TODO: composition으로??

    public void operate(List<String> names, int attemptNumber) {
        List<Boolean> initialRandoms = getRandom(names.size() * attemptNumber);
        List<List<Boolean>> randoms = cutRandom(initialRandoms, names.size());
        initialize(names);
        move(randoms);
    }

    public List<Car> getWinner() {
        return carManager.findWinners();
    }

    private List<Boolean> getRandom(int randomSize){
        List<Boolean> moveOrNot = new ArrayList<>(); // TODO: 이름 개선
        for (int i = 0; i < randomSize; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) { // TODO: 랜덤 추출 로직 함수로 추출
                moveOrNot.add(true);
                continue;
            }
            moveOrNot.add(false);
        }
        return moveOrNot;
    }

    // TODO: 생성과 cut을 분리하는 게 나은지 합치는 게 나은지?
    private List<List<Boolean>> cutRandom(List<Boolean> randoms, int pivot) {
        List<List<Boolean>> dividedRandoms = new ArrayList<>();
        for (int i = 0; i < randoms.size(); i += pivot) {
            dividedRandoms.add(new ArrayList<>(randoms.subList(i, i + pivot)));
        }
        return dividedRandoms;
    }

    private void initialize(List<String> names) {
        carManager.initialize(names);
    }

    private void move(List<List<Boolean>> randoms) { // TODO: 내가 다른데 move라는 이름의 메서드 만들었던가?
        for (int i = 0; i < randoms.size(); i++) {
            carManager.advanceCars(randoms.get(i));
            // TODO: OutputView Service에 있는 게 맞나?
            OutputView.printResult(carManager.getCars()); // TODO: 파라미터로 전달하는 게 최선인가?
        }
    }
}
