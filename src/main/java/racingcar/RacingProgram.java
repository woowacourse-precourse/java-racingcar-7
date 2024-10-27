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

    List<Car> splitName(String input) {
        List<Car> cars = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();
        String[] results = input.split(",", -1);

        for (String result : results) {
            validateCarName(result);  // 유효성 검사 분리
            validateDuplication(uniqueNames, result);  //차 이름 중복되는지 검사
            cars.add(createCar(result));  // 객체 생성 로직 분리
        }
        return cars;
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
        if(!cars.add(name)){
            throw new IllegalArgumentException();
        }
    }

    private Car createCar(String name) {
        return new Car(name);
    }





}
