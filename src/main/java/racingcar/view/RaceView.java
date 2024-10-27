package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.domain.Car;

public class RaceView {
    public ArrayList<String> inputCarsName(String... testInput) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 테스트 코드 작동을 위해 가변인자 testInput 사용
        String input;

        if (testInput.length != 0) {
            input = testInput[0];
        } else {
            input = Console.readLine();
        }

        ArrayList<String> carNames = new ArrayList<>();

        String[] tokens = input.split(",", -1);

        for (String token : tokens) {
            token = token.trim();

            if (!token.isEmpty() && token.length() <= 5 && validateNameToken(token)) {
                carNames.add(token);
            } else {
                throw new IllegalArgumentException("자동차 이름 형식이 올바르지 않습니다.");
            }
        }

        if (existDuplicateString(carNames)) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
        }

        return carNames;
    }

    // (,) 기준으로 분리된 자동차 이름 토큰의 형식을 검증
    private boolean validateNameToken(String input) {
        // 검증 기준 : 숫자, 영어, 한글만 허용, 공백 포함 특수문자 불허
        Pattern pattern = Pattern.compile("^[0-9a-zA-Z가-힣]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private boolean existDuplicateString(ArrayList<String> list) {
        Set<String> carSet = new HashSet<>(list);
        return carSet.size() != list.size();
    }

    public int inputTryTime(String... testInput) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int N;
        String input;

        // 테스트용 입력 설정
        if (testInput.length != 0) {
            input = testInput[0];
        } else {
            input = Console.readLine();
        }

        try {
            N = Integer.parseInt(input.trim());
            if (N <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return N;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public void printRace(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<Car> cars) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < cars.size() - 1; i++) {
            System.out.print(cars.get(i).getCarName() + ", ");
        }
        System.out.println(cars.getLast().getCarName());
    }


}
