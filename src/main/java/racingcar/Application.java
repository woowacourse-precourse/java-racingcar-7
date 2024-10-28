package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        StringTokenizer tokenizer = new StringTokenizer(Console.readLine(), ",");
        String car1 = tokenizer.nextToken();
        String car2 = tokenizer.nextToken();
        String car3 = tokenizer.nextToken();
        String[] cars = new String[]{car1, car2, car3};
        System.out.println("시도할 홧수는 몇 회인가요?");
        int trial = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");

        //전진 멈추는 방법(4이상일때만 전진)
        for (int i = 0; i < trial; i++) {
            for (String car : cars) {
                int value = Randoms.pickNumberInRange(0, 9);
                if (value >= 4) {
                    car.go();
                }
            }
        }
        //우승자를 뽑는 방식
        private static void winner(List<Car> cars){
            int maxDistatnce = 0;
            for (Car car : cars) {
                if (car.getDistance() >= maxDistatnce) {
                    maxDistatnce = car.getDistance();
                }
            }
            List<String> winners = new ArrayList<>();
            for (Car car : cars) {
                if (car.getDistance() == maxDistatnce) {
                    winners.add(car.getName());
                }
            }
            //우승자 출력
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }

    }
}
