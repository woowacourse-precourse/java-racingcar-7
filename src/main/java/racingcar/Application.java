package racingcar;

import java.util.ArrayList;

/**
 * 프로그램 진입 부분
 */
class Application {
    /**
     * 차 이름과 횟수를 입력받아 경주를 진행하고 우승자를 출력
     * @param args main 함수 구성요소로 동작과 무관
     */
    public static void main(String[] args) {
        Print.nameInputMessage();
        Input nameInput = new Input();
        ArrayList<String> carNames = Input.splitInput(nameInput.string);
        ArrayList<Car> cars = Racing.generateCars(carNames);

        Print.numberInputMessage();
        Input numberInput = new Input();
        int num = Input.getNumber(numberInput.string);

        for (int i = 0; i < num; i++) {
            Racing.race(cars);
        }

        ArrayList<String> winners = Racing.getWinners(cars);
        Print.winners(winners);
    }
}
