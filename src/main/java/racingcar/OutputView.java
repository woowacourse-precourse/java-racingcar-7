package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public void notifyEnterNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void notifyEnterTryingNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void notifyPrintResult() {
        System.out.println("실행 결과");
    }

    // list에 있는 차들의 이름과 현재 위치 출력
    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printCurrentPos(car.getCurrentPos());
            System.out.print("\n");
        }
    }

    // 위치만큼 "-" 출력
    public void printCurrentPos(int currentPos) {
        for (int i = 0; i < currentPos; i++) {
            System.out.print("-");
        }
    }

    // 우승자 출력
    public void printWinner(List<Car> cars) {
        List<String> winnerCarsNames = findWinner(cars);

        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winnerCarsNames.size(); i++) {
            System.out.print(winnerCarsNames.get(i));
            if (i != winnerCarsNames.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    // 우승자 찾아내기
    public List<String> findWinner(List<Car> cars) {
        List<String> winnerCarsNames = new ArrayList<>();

        Collections.sort(cars);
        winnerCarsNames.add(cars.getFirst().getName());
        int winnerPos = cars.getFirst().getCurrentPos();

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getCurrentPos() != winnerPos) {
                break;
            }
            winnerCarsNames.add(cars.get(i).getName());
        }
        return winnerCarsNames;
    }
}
