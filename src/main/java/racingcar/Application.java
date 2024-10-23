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

        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = br.readLine().trim();

            if (input.isEmpty() || input.startsWith(",") || input.endsWith(",") || input.contains(",,")){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            } else {
                List<String> cars = new ArrayList<>(List.of(input.split(",")));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        try{
            System.out.println("시도할 횟수는 몇 회인가요?");
            int moves = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
