package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // 이름 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();

        //입력 받은 차동차 이름들을 쉼표 기준으로 구분
        ArrayList<String> carNames = ToNameArray(names);
        //각 횟수 전진량(-)입력 리스트
        ArrayList<String> ResultsPerCount = new ArrayList<>(carNames);
        //각 차들의 전진량 횟수 기록 리스트
        ArrayList<Integer> count = new ArrayList<>(Collections.nCopies(carNames.size(), 0));
        int carNameSize = carNames.size();
        // 횟수 입력 받기
        System.out.println("시도할 횟수는 몇 회인가요?");
        String times = Console.readLine();
        int repeat = 0;

        try{
            repeat = Integer.parseInt(times);
            if (repeat < 0) {
                throw new IllegalArgumentException("숫자를 잘못 입력");
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("잘못입력");
        }

        // 각 실행 결과 값 출력 리스트 셋팅
        for (int i = 0; i < carNameSize; i++) {
            ResultsPerCount.set(i,ResultsPerCount.get(i)+" : ");
        }
        System.out.println();
        System.out.println("실행 결과");

        //전진량 기록 및 출력
        for (int i = 0; i < repeat; i++) {
            for (int j = 0; j < carNameSize; j++) {
                forwardRecording(ResultsPerCount,count,j);
                System.out.println(ResultsPerCount.get(j));
            }
            System.out.println();
        }

        //전진량값에 따라 이름,전진량 오름차순 정리
        for (int i = 0; i < carNameSize - 1; i++) {
            for (int j = i + 1; j < carNameSize; j++) {
                swap(carNames, count,i,j);
            }
        }

        int max = count.get(carNameSize - 1);
        String winners = carNames.get(carNameSize - 1);
        // 동시 우승자 발생 상황
        for (int i = carNameSize - 2; i >= 0; i--) {
            if (count.get(i) == max) {
                winners += ", " +  carNames.get(i);
            }
        }

        System.out.println("최종 우승자 : " + winners);
    }
    public static ArrayList<String> ToNameArray(String names){
        ArrayList<String> list = new ArrayList<>();
        Arrays.stream(names.split(","))
                .map(String::trim)
                .filter(name -> {
                    if (name.length() > 5 || name.isEmpty()) {
                        throw new IllegalArgumentException("잘못된 입력입니다");
                    }
                    return true;
                })
                .distinct()
                .forEach(list::add);
        if(list.isEmpty()) throw new IllegalArgumentException("잘못된 입력입니다");
        System.out.println(list);
        return list;
    }

    public static void swap(ArrayList<String> carNames, ArrayList<Integer> count, int i, int j) {
        if (count.get(i) > count.get(j)) {
            int tempN = count.get(i);
            count.set(i,count.get(j));
            count.set(j,tempN);
            String tempS = carNames.get(i);
            carNames.set(i,carNames.get(j));
            carNames.set(j,tempS);

        }
    }

    public static void forwardRecording(ArrayList<String> ResultsPerCount, ArrayList<Integer> count, int j) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            ResultsPerCount.set(j, ResultsPerCount.get(j) + "-");
            count.set(j, count.get(j) + 1);
        }

    }

}
