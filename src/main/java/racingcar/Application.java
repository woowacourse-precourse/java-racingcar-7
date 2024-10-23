package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> cars = getCarNames(br);
        int moves = getMovementCounts(br);

        System.out.println(cars);
        System.out.println(moves);
    }

    public static List<String> getCarNames(BufferedReader br) {
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = br.readLine().trim();

            validateInput(input);
            return new ArrayList<>(List.of(input.split(",")));
        } catch (IOException e){
            throw new IllegalArgumentException("입력 오류: 잘못된 입력입니다.");
        }
    }

    public static void validateInput(String input) {
        if (input.isEmpty() || input.startsWith(",") || input.endsWith(",") || input.contains(",,")){
            throw new IllegalArgumentException("입력 오류: 쉼표를 확인하세요.");
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
