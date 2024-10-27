package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();

        List<String> carNames = nameSpliter(inputNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNum = Integer.parseInt(Console.readLine());

        CarRaceSimulator simulator = new CarRaceSimulator(carNames, tryNum);
        for(int i = 0; i < tryNum; i++ ) {
            if(i == 0) {
                System.out.println("실행 결과");
            }
            simulator.runOneTime();
            simulator.printOneTimeResult();
        }
        simulator.printWinner();
    }

    public static List<String> nameSpliter(String inputNames) {
        String[] splittedNames = inputNames.split(",");
        List<String> carNames = Arrays.stream(splittedNames).collect(Collectors.toList()); //array를 list로 변환
        for (String name : carNames) {
            if(name.length() > 5) { //5자 초과 이름 예외 처리
                System.out.println("5자를 초과하는 이름입니다.");
                throw new IllegalArgumentException();
            }else if(name.trim().isEmpty()) { //빈 문자열 예외 처리
                throw new IllegalArgumentException();
            }else if(name.contains(":") || name.contains("-")) { //":"나 "-" 들어가는 이름 예외 처리
                throw new IllegalArgumentException();
            }
        }

        //중복된 이름 예외 처리
        Set<String> nameSet = new HashSet<>(carNames);
        if(nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }

        return carNames;
    }
}
