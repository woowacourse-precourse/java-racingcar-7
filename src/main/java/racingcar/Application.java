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
        List<String> cars = getCarNames(br);
        int moves = getMovementCounts(br);

    }

    public static List<String> getCarNames(BufferedReader br) {
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = br.readLine().trim();

            validateInput(input);
            List<String> cars = new ArrayList<>(List.of(input.split(",")));
            validateNames(cars);
            return cars;
        } catch (IOException e){
            throw new IllegalArgumentException("입력 오류: 잘못된 입력입니다.");
        }
    }

    public static void validateInput(String input) {
        if (input.isEmpty() || input.startsWith(",") || input.endsWith(",") || input.contains(",,")){
            throw new IllegalArgumentException("입력 오류: 쉼표를 확인하세요.");
        }
    }

    public static void validateNames(List<String> cars) {
        Set<String> uniqueNames = new HashSet<>();

        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("입력 오류: 5글자를 초과한 이름이 있습니다.");
            }

            if (!uniqueNames.add(car)) {
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
}
