package racingcar;

import java.io.*;
import java.util.*;

// 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
// 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
// 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

// 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
// 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
// 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
public class Application {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            bw.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
            bw.flush();
            String carNamesInput = br.readLine();
            String[] carNamesArray = carNamesInput.split(",");
            List<Car> cars = new ArrayList<>();

            for (String name : carNamesArray) {
                cars.add(new Car(name));
            }

            if (cars.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
            }

            bw.write("시도할 횟수는 몇 회인가요?\n");
            bw.flush();
            int attempts = Integer.parseInt(br.readLine());

            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }

            bw.write("\n실행 결과\n");
            bw.flush();

            // 게임 실행
            for (int i = 0; i < attempts; i++) {
                for (Car car : cars) {
                    car.move();
                    bw.write(car.getName() + " : " + car.getProgress() + "\n");
                }
                bw.write("\n");
                bw.flush();
            }

        } catch (NumberFormatException e) {
            bw.write("숫자를 입력해주세요.\n");
            bw.flush();
        } catch (IllegalArgumentException e) {
            bw.write(e.getMessage() + "\n");
            bw.flush();
        } finally {
            bw.close();
            br.close();
        }
    }
}
