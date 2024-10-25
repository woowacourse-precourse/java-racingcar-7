package racingcar;

import racingcar.model.Car;
import racingcar.model.Dice;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final Dice dice = new Dice();

    public static void main(String[] args) {
        List<Car> raceCars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String allMembers = Console.readLine();
        String[] carNames = allMembers.split(",");

        // 각 이름에 대해 Car 객체를 생성하여 리스트에 추가
        for (String name : carNames) {
            if(name.trim().length() > 5) {
                throw new IllegalArgumentException("이름은 5글자 이하로 설정해야 합니다.");
            }
            raceCars.add(new Car(name.trim()));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        Integer attempt = Integer.valueOf(Console.readLine());

    }

}

