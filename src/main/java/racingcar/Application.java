package racingcar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
// 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
// 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
public class Application {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            bw.write("자동차 대수는 몇 대인가요?\n");
            bw.flush();
            String carCountInput = br.readLine();
            int carCount = Integer.parseInt(carCountInput);

            bw.write("시도할 횟수는 몇 회인가요?\n");
            bw.flush();
            String attemptsInput = br.readLine();
            int attempts = Integer.parseInt(attemptsInput);

            List<Integer> carLists = new ArrayList<>();
            for(int i = 0; i < carCount; i++) {
                carLists.add(0);
            }

            Random random = new Random();

            for (int i = 0; i < attempts; i++) {
                for (int j = 0; j < carCount; j++) {
                    int randomNumber = random.nextInt(10);
                    if (randomNumber >= 4) {
                        carLists.set(j, carLists.get(j) + 1);
                    }
                }
            }

            for (int i = 0; i < carCount; i++) {
                bw.write("자동차 " + (i + 1) + "의 최종 위치: " + carLists.get(i) + "\n");
            }
            bw.flush();
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
