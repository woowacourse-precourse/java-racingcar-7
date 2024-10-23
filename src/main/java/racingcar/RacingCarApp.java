package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class RacingCarApp {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<String> winnerList = new ArrayList<>();

    public void run() {
        String inputData = getCarInput();
        int attemptCount = getAttemptCount();
        makeCar(inputData);
        System.out.println("실행 결과");
        while (attemptCount > 0) {
            carsMove();
            attemptCount--;
        }
        printWinners();
    }

    public void carsMove() {
        for (Car car : cars) {
            car.move();
        }
        System.out.println();
    }

    public String getCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        }catch (Exception e){ // 정수 변환 실패시
            throw new IllegalArgumentException();
        }
    }

    public void makeCar(String inputData) {
        for (String carName : inputData.split(",")) {
            validateCarName(carName);
            cars.add(new Car(carName));
        }
    }

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition,car.getCurrentPosition());
        }
        return maxPosition;
    }

    public void winnerCheck(Car car,int maxPosition) {
        if (car.getCurrentPosition() == maxPosition) {
            winnerList.add(car.getCarName());
        }
    }

    public void printWinners() {
        int maxPosition = findMaxPosition();
        for (Car car : cars) {
            winnerCheck(car,maxPosition);
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winnerList));
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
