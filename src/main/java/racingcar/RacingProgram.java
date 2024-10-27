package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingProgram {

    private List<Car> cars;
    private int attempts;

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
            validateCarName(withoutSpaceName);  // 유효성 검사 분리
            validateDuplication(uniqueNames, withoutSpaceName);  //차 이름 중복되는지 검사
            cars.add(createCar(withoutSpaceName));  // 객체 생성 로직 분리
        }
        return cars;
    }

    int parseStringToNumber(String num){
        int resultNum; //String 타입의 변수

        try {
            resultNum = Integer.parseInt(num);
            validatePositive(resultNum);
        } catch (NumberFormatException e){
            //정수 형태의 문자열이 아닌 경우
            throw new IllegalArgumentException(e);
        }
        return resultNum;
    }

    void gameStart(){
        System.out.println("실행 결과");
        for(int i = 0; i < attempts; i++){
            moveCars();
            System.out.println();
        }
    }


    private void validateCarName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("차 이름은 공백일 수 없습니다");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름의 글자수는 5자를 초과할 수 없습니다.");
        }
    }

    private void validateDuplication(Set<String> cars, String name){
        //Set을 활용해 중복 여부 확인
        if(!cars.add(name)){
            throw new IllegalArgumentException();
        }
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    private void validatePositive(int resultNum){
        //우승자는 한 명 이상일 수 있다
        if(resultNum <= 0){
            throw new IllegalArgumentException("게임 횟수는 0이하가 될 수 없습니다.");
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.playCar();
        }
    }

}
