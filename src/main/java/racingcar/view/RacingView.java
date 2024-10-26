package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.dto.RaceResponse;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingView {

    private final String regex = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";

    // 자동차 이름 입력 받기
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표로 구분)");
        String[] carName = Console.readLine().trim().split(",");
        Pattern pattern = Pattern.compile(regex);

        for (String car : carName) {
            Matcher matcher = pattern.matcher(car);

            if (car.contains(" ")) { // 이름에 공백이 포함된 경우
                System.out.println("공백이 포함된 이름 : " + car);
                throw new IllegalArgumentException("공백은 허용하지 않습니다. : " + car);
            }else if (matcher.find()) { // 특수 문자가 있는 경우
                System.out.println("한국어, 영어가 아닐 때 : " + car);
                throw new IllegalArgumentException("한글 또는 영어만 허용합니다. : " + car);
            } else if (car.length() > 5) { // 길이가 5 초과인 경우
                System.out.println("차 이름 글자 수 5 이상 : " + car.length());
                throw new IllegalArgumentException("자동차 이름이 5자가 넘습니다 : " + car + " : " + car.length());
            }
        }
        return carName;
    }


    // 시도 횟수 입력 받기
    public int getRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int parseInt = Integer.parseInt(Console.readLine());
        if (parseInt < 0){
            throw new IllegalArgumentException("음수는 허용 하지 않습니다 : " + parseInt);
        }
        return parseInt;
    }

    // 각 차수별로 자동차 상태 출력
    public void printCarStates(List<Car> carStates) {
        for (Car car : carStates) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
    }

    // 최종 우승자 출력
    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public void printRaceResult(RaceResponse response){
        printCarStates(response.getCarStates());
        printCarStates(response.getCarStates());
    }
}


