package racingcar.racingcarController;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.racingcarModel.Car;
import racingcar.racingcarView.CarView;

public class Controller {
    private final CarView carView;
    private final ExceptionController exceptionController;

    public Controller(CarView carView, ExceptionController exceptionController) {
        this.carView = carView;
        this.exceptionController = exceptionController;
    }

    public void run() {
        carView.printNameInputMessage();
        String nameInput = carView.readInput();
        carView.printTryInputMessage();
        String beforeTryInput = carView.readInput();

        //예외 검사
        exceptionController.exceptionCheck(nameInput, beforeTryInput);

        int tryInput = Integer.parseInt(beforeTryInput);
        List<Car> cars = carList(nameInput);

        startRace(tryInput, cars);

        String winner = winnerCar(cars, maxValue(cars));
        carView.printWinners(winner);
    }

    private void startRace(int tryInput, List<Car> cars) {
        carView.printStartResults();
        for (int i = 0; i < tryInput; i++) {
            for (Car car : cars) {
                car.setCarMove(isForward(car.getCarMove()));
                carView.printResults(car.getCarName(), car.getCarMove());
            }
            System.out.println();
        }
    }

    // nameInput 분리해서 리스트 대입
    public List<Car> carList(String nameInput) {
        List<Car> cars = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(nameInput, ",");
        while (st.hasMoreTokens()) {
            cars.add(new Car(st.nextToken()));
        }
        return cars;
    }

    // 랜덤값에 따라 전진 여부를 결정하는 메서드
    public int isForward(int currentValue) {

        int i = Randoms.pickNumberInRange(0, MAX_RANDOM_NUMBER);

        if (i >= FORWARD_NUMBER) {
            return currentValue + 1;
        }
        return currentValue;
    }

    private static final int FORWARD_NUMBER = 4;
    private static final int MAX_RANDOM_NUMBER = 9;

    // 맵 내 최대 value를 구하는 메서드
    private int maxValue(List<Car> cars) {
        int maxValue = 0;

        for (Car car : cars) {
            if (car.getCarMove() > maxValue) {
                maxValue = car.getCarMove();
            }
        }
        return maxValue;
    }

    // 맵 내 최대 value를 지닌 값의 key를 구해서 String으로 합하는 메서드
    private String winnerCar(List<Car> cars, int maxValue) {
        StringBuilder winner = new StringBuilder();

        for (Car car : cars) {
            if (maxValue <= car.getCarMove()) {
                appendWinner(winner, car.getCarName());
            }
        }

        return winner.toString();
    }

    // 승자가 두 명 이상이면 사이에 콤마를 붙여주는 메서드
    private void appendWinner(StringBuilder winner, String carName) {
        if (!winner.isEmpty()) {
            winner.append(", ");
        }
        winner.append(carName);
    }


}
