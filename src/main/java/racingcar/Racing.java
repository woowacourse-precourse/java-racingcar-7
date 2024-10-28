package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public void run() {
        // # 1. 경주할 자동차 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // # 2. 시도할 횟수 입력받기
        System.out.println("시도할 횟수는 몇 회인가요?");
        int repeat = Integer.parseInt(Console.readLine());

        String[] racer = spliter(input);
        int[] racerMoved = new int[racer.length];

        // # 4. 생성된 랜덤수를 통한 전진여부 판단하기
        System.out.println("실행 결과");
        for (int i = 0; i < repeat; i++) {
            defineMove(racer, racerMoved);
        }

        // #5. 최종 우승자 확인 후 출력하기
        List<String> winners = findWinner(racer, racerMoved);
        int size = winners.size();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < size; i++) {
            printWinner(winners, size, i);
        }
    }

    // 랜덤수 생성 후 전진여부 판단
    public void defineMove(String[] racer, int[] racerMoved) {
        for (int j = 0; j < racer.length; j++) {
            if (isMove(randomGenerator())) racerMoved[j]++;
            System.out.println(racer[j] + " : " + "-".repeat(racerMoved[j]));
        }
        System.out.println();
    }

    // 출력분리
    public void printWinner(List<String> winners, int size, int idx) {
        if (size == 1) {
            System.out.println(winners.get(idx));
        } else {
            if (idx < size - 1) {
                System.out.print(winners.get(idx) + ", ");
            } else {
                System.out.println(winners.get(idx));
            }
        }
    }

    // 최종 우승자 찾기
    public List<String> findWinner(String[] racer, int[] racerMoved) {
        List<String> winners = new ArrayList<>();
        int MAX = findMax(racerMoved);
        for (int i = 0; i < racer.length; i++) {
            if (racerMoved[i] == MAX) winners.add(racer[i]);
        }
        return winners;
    }

    // 최대값 찾기
    public int findMax(int[] racerMoved) {
        int max = 0;
        for (int racer : racerMoved) {
            max = Math.max(racer, max);
        }
        return max;
    }

    // , 기준으로 분리하기
    public String[] spliter(String input) {
        return input.split(",");
    }

    // # 3. 무작위 값 생성하기
    public int randomGenerator() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isMove(int num) {
        return num >= 4;
    }

}
