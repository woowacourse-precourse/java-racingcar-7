package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    private String input = "";
    private int NUMBER;
    private String[] inputCars;
    private List<Car> carList = new ArrayList<>();
    private int MAX_POSITION;
    private List<String> names = new ArrayList<>();


    RacingManager(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.input = Console.readLine(); // 사용자 입력을 받는 메소드
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            this.NUMBER = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력하지 않았습니다.");
        }
        splitInputCars();
    }

    private void splitInputCars() {
        this.inputCars = input.split(",");
    }

    private void createCar() {
        for(int i = 0; i < inputCars.length; i++){
            Car car = new Car(inputCars[i], 0);
            carList.add(car);
        }
    }

    private void startRacing() {
        System.out.println();
        System.out.println("실행 결과");
        while(NUMBER > 0){
            startMove(carList);
            System.out.println();
            NUMBER -= 1;
        }
    }

    private void startMove(List<Car> carList) {
        int RANDOM_NUM;
        for(int i = 0; i < carList.size(); i++) {
            String position = "";
            Car car = carList.get(i);
            checkMove(car);
            printPosition(car, position);
        }
    }

    private void checkMove(Car car) {
        int RANDOM_NUM = Randoms.pickNumberInRange(0, 9);
        int MOVE_FORWARD_NUM = 4;
        if(RANDOM_NUM >= MOVE_FORWARD_NUM) {
            car.moveForword();
        }
    }

    private void printPosition(Car car, String position) {
        for(int j = 0; j < car.getPosition(); j++) {
            position += '-';
        }
        System.out.println(car.getName() + " : " + position);
    }

    public void getMaxPosition() {
        MAX_POSITION = carList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElse(-1);
    }

    public void getMaxPostionCars() {
        // 최대 position을 가진 모든 객체의 name을 리스트로 추출
        names = carList.stream()
                .filter(o -> o.getPosition() == MAX_POSITION)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printMaxPositionCars() {
        String result = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }

    public void runRacing() {
        createCar();
        startRacing();
        getMaxPosition();
        getMaxPostionCars();
        printMaxPositionCars();
    }
}
