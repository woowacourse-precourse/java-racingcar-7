package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.race.Racer;
import racingcar.separator.Extractor;

public class UI {

    public UI() {}

    public static String[] getRacerName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉰표(,) 기준으로 구분)");

        return Extractor.extract(Console.readLine());
    }

    public static int getRacingTimes(){
        System.out.println("시도할 횟수는 몇 회인가요?");

        int times;

        try {
            times = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 형태의 숫자를 입력해주세요.");
        }

        return times;
    }

    public static void showProgress(List<Racer> racers) {
        for(Racer racer : racers) {
            System.out.print(racer.getName() + " : ");
            for(int i = 0; i<racer.getPosition(); i++){
                System.out.print("-");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void showResult(Racer[] racers) {
        System.out.print("최종 우승자 : ");

        for(int i = 0; i<racers.length; i++) {
            System.out.print(racers[i].getName());
            if(i < racers.length - 1){
                System.out.print(", ");
            }
        }
    }
}
