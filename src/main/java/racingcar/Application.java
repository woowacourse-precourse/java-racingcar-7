package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요,(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<String> carNameList = getCarName(input);
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attempts = readLine();
        playGame(carNameList, attempts);
    }

    public static List<String> getCarName(String input){
        List<String> carNameList = Arrays.asList(input.split(","));
        validateCarName(carNameList);
        return carNameList;
    }

    public static void validateCarName(List<String> carNameList){
        for(String carName : carNameList){
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 정해주세요.");
            }
            if(carName.isBlank()){
                throw new IllegalArgumentException("자동차 이름을 1자 이상으로 정해주세요.");
            }
        }
    }

    public static void playGame(List<String> carNameList, String attempts){
        int round = validateAttempts(attempts);
        HashMap<String, String> carPositions = start(carNameList, round);
        winner(carPositions);
    }

    public static int validateAttempts(String attempts){
        try{
            if(Integer.parseInt(attempts) < 1){
                throw new IllegalArgumentException("음수나 0은 입력이 안됩니다.");
            }
            return Integer.parseInt(attempts);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자 외에는 입력이 안됩니다.");
        }
    }

    public static HashMap<String, String> start(List<String> carNameList, int round){
        HashMap<String, String> carPositions = new HashMap<>();
        for(String carName : carNameList){
            carPositions.put(carName, "");
        }
        System.out.println("실행 결과");
        for(int i = 0; i < round; i++){
            for(String carName : carNameList){
                int random = pickNumberInRange(0, 9);
                if(random >= 4){
                    carPositions.put(carName, carPositions.get(carName) + "-");
                }
                System.out.println(carName + " : " + carPositions.get(carName));
            }
            System.out.println("");
        }
        return carPositions;
    }

    public static void winner(HashMap<String, String> carPositions){
        int max = carPositions.values().stream().mapToInt(String::length).max().orElse(0);

        List<String> winner = carPositions.entrySet().stream()
                .filter(entry -> entry.getValue().length() == max)
                .map(Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
