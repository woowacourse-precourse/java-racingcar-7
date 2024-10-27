package controller;

import racingcar.Car;
import racingcar.CarList;
import view.InputView;
import view.OutputView;

public class RaceController {
    private CarList carList = new CarList(); // CarList를 추가

    public void start() {
        setCars();
        setTryNumber();
    }

    public void setCars() {
        while (true) {
            try {
                String carNames = InputView.printSetCarMessage(); // 자동차 이름 입력받기
                carList.add(carNames); // 자동차 추가
                break; // 유효한 이름이 입력되면 반복 종료
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
                // 재입력은 반복문으로 처리
            }
        }
    }

    public void setTryNumber() {
        while (true) {
            try {
                String input = InputView.printGetTryNumberMessage(); // 시도 횟수 입력받기
                int tries = Integer.parseInt(input); // 문자열을 정수로 변환
                for (Car car : carList.getCars()) {
                    car.setTryNumber(tries); // 각 자동차의 시도 횟수 설정
                }
                break; // 유효한 시도 횟수가 입력되면 반복 종료
            } catch (NumberFormatException e) {
                OutputView.printErrorMessage(new IllegalArgumentException("시도 횟수는 숫자여야 합니다.")); // 숫자가 아닐 경우 예외 발생
                // 재입력은 반복문으로 처리
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
                // 재입력은 반복문으로 처리
            }
        }
    }
}
