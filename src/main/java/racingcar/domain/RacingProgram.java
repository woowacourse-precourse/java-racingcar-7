package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.util.Validator.*;

public class RacingProgram {

    private List<Car> cars;
    private int attempts;

    public void play(){
        getCarNamesFromUser();
        getAttemptFromUser();
        gameStart();
        gameResult();
    }

    void getCarNamesFromUser(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = Console.readLine();
        cars = splitName(carList);
    }

    void getAttemptFromUser(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptNum = Console.readLine();
        attempts = parseStringToNumber(attemptNum);
    }

    List<Car> splitName(String input) {
        List<Car> cars = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();
        String[] carList = input.split(",", -1);

        for (String carName : carList) {
            String withoutSpaceName = carName.trim(); //입력받은 문자열에 대해 공백이 있는 경우 삭제
            validateCarName(withoutSpaceName);  //입력 형식 유효성 검사
            validateDuplication(uniqueNames, withoutSpaceName);  //차 이름 중복되는지 검사
            cars.add(createCar(withoutSpaceName));  // 객체 생성 로직 분리
        }
        return cars;
    }

    void gameStart(){
        System.out.println("실행 결과");
        for(int i = 0; i < attempts; i++){
            moveCars();
            System.out.println();
        }
    }

    void gameResult(){
        int maxDistance = getMaxDistance();//가장 많이 이동한 거리를 구하기 위해
        System.out.print("최종 우승자 : ");
        int check = 0;
        for(int i = 0; i < cars.size(); i++){
            check = getWinnerIfMaxDistance(maxDistance, check, i);
        }
    }

    public int parseStringToNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.", e);
        }
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    //랜덤으로 번호 부여 후 차 이동
    private void moveCars() {
        for (Car car : cars) {
            car.playCar();
        }
    }

    private int getWinnerIfMaxDistance(int maxDistance, int check, int i) {
        if(cars.get(i).getInstance() == maxDistance){
            check = printWinnerName(check, i);
        }
        return check;
    }

    private int printWinnerName(int check, int j) {
        if(check == 0){
            check = 1;
            System.out.print(cars.get(j).getCarName());
        }else{
            System.out.print(", " + cars.get(j).getCarName());
        }
        return check;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for(int j = 0; j < cars.size(); j++){
            maxDistance = calculateMaxDistance(maxDistance, j);
        }
        return maxDistance;
    }

    private int calculateMaxDistance(int maxDistance, int j) {
        if(cars.get(j).getInstance() > maxDistance){
            maxDistance = cars.get(j).getInstance();
        }
        return maxDistance;
    }

    //테스트를 위한 setter 메서드
    void setCars(List<Car> cars){
        this.cars = cars;
    }

}
