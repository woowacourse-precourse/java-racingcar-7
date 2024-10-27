package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자 입력 받기
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carNames = inputView.getCarNames();
        int rounds = inputView.getRounds();

        // 입력받은 이름 파싱
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            String trimmedName = name.trim();
            if(trimmedName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }

        //자동차 게임 시작
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
            outputView.displayRoundResults(cars);
        }
        // 결과 출력
        outputView.displayWinners(getWinners(cars));
    }
    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
