package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = getCarNames(br);
        int moves = getMovementCounts(br);

        startRace(cars, moves);

    }

    public static List<Car> getCarNames(BufferedReader br) {
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = br.readLine().trim();

            validateInput(input);
            List<Car> cars = new ArrayList<>();
            for (String name : input.split(",")) {
                cars.add(new Car(name));
            }
            validateNames(cars);
            return cars;
        } catch (IOException e){
            throw new IllegalArgumentException("입력 오류: 잘못된 입력입니다.");
        }
    }

    public static void validateInput(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException("입력 오류: 입력값이 없습니다.");
        }
        if (input.startsWith(",") || input.endsWith(",") || input.contains(",,")){
            throw new IllegalArgumentException("입력 오류: 잘못된 쉼표 사용입니다.");
        }
    }

    public static void validateNames(List<Car> cars) {
        Set<String> uniqueNames = new HashSet<>();

        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("입력 오류: 5글자를 초과한 이름이 있습니다.");
            }

            if (!uniqueNames.add(car.getName())) {
                throw new IllegalArgumentException("입력 오류: 중복된 이름이 있습니다.");
            }
        }
    }

    public static int getMovementCounts(BufferedReader br) {
        try{
            System.out.println("시도할 횟수는 몇 회인가요?");
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException("입력 오류: 잘못된 입력입니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 오류: 정수를 입력하세요.");
        }
    }

    public static void startRace(List<Car> cars, int moves) {
        System.out.println("실행 결과");
        for (int i = 0; i < moves; i++) {
            for(Car car : cars){
                car.move();
                car.printPosition();
            }
            System.out.println();
        }
    }
}
