package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<String> winners = new ArrayList<>();
    int maxTurn = 0;

    public void runGame() {

        setGame();
        playGame();
        afterGame();
    }

    /// 레이싱게임 입력부분
    private void setGame() {
        //Todo: 한 가지 기능을 하는 함수로 나누기

        String[] carNameArray = inputCarName(); // 자동차 이름 입력받아서 배열에 저장
        validateCarName(carNameArray); // 자동차 입력부분 예외처리

        // 자동차 정보 저장
        for (String carName : carNameArray) {

            checkDuplicateCar(carName); // 자동차 이름 중복 예외처리
            cars.add(new Car(carName));
        }
        //Todo: 사용자로부터 maxTurn 입력받기
        inputMaxTurn();
    }

    /// 자동차 이름을 입력받아 문자열 배열을 리턴
    private String[] inputCarName() {

        String carNameString = Console.readLine(); // 사용자로부터 자동차 이름 입력받기
        carNameString = carNameString.trim();

        // 입력한 자동차 이름으로 생성한 배열 리턴
        return carNameString.split(",");
    }

    /// 자동차 입력부분 예외처리
    private void validateCarName(String[] carNameArray) {

        if (carNameArray.length > 8) {
            throw new IllegalArgumentException("자동차 이름은 최대 8개까지 입력 가능합니다.");
        }
        if (carNameArray.length < 2){
            throw new IllegalArgumentException("자동차 이름은 최소 2개 이상 입력해야합니다.");
        }

        for (String carName : carNameArray) {

            carName = carName.trim();


            if (carName.length() < 2) {
                throw new IllegalArgumentException("자동차 이름은 2자 이상으로 입력해야합니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야입니다.");
            }

            // 자동차 이름이 알파벳 대소문자로만 이루어져있는지 확인
            if (!carName.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳 대소문자만 가능합니다.");
            }

        }
    }

    ///자동차 이름 중복 예외처리
    private void checkDuplicateCar(String carName) {

        for (Car car : cars) {
            if (carName.equals(car.getCarName())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }



    private void playGame() {
        //Todo: maxTurn번 반복하기
        //Todo: 무작위 수를 이용하여 자동차 움직이기
        //Todo: 한 가지 기능을 하는 함수로 나누기
    }

    private void afterGame() {
        //Todo: 각 자동차별 최종 거리를 이용하여, 1등 거리 구하기
        //Todo: 1등 거리에 해당하는 자동차 이름을 winners 배열에 저장
        //Todo: winners 배열을 통해 우승자 출력하기
        //Todo: 한 가지 기능을 하는 함수로 나누기
    }

}
