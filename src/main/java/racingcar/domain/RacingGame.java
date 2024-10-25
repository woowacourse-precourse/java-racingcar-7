package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
// 라는 요구사항이 있어서 최대한 단일한 책임을 가지도록 만들어 봄.
// 하지만 오히려 더 보기 힘들다고 판단되면 내가 생각하기에 균형이 잡힌 만큼으로 고쳐봄
public class RacingGame {
    
    public void play() {
        
        // Console로 열린 scanner를 닫아주기 위해 try/finally
        try {
            String[] carNames = inputCarNames();
            int gameCount = inputGameCount();
            
            startGame(carNames, gameCount);
        } finally {
            Console.close();
        }
        
    }
    
    private void startGame(String[] carNames, int gameCount) {
        // 이전에 carNames, gameCount 이 값들의 검증을 마쳤으므로 바로 사용
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName.trim()));
        }
        
        System.out.println("\n실행 결과");
        
        for (int i = 0; i < gameCount; i++) {
            moveCars(carList);
            printCarsInfo(carList);
            
            System.out.println();
        }
    }
    
    private void printCarsInfo(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getGameCurrentStatus());
        }
    }
    
    private void moveCars(List<Car> carList) {
        
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            
            if (randomNumber >= 4) {
                car.plusDistance();
            }
        }
    }
    
    private int inputGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputGameCount = Console.readLine();
        return validateInputGameCount(inputGameCount);
    }
    
    private int validateInputGameCount(String inputGameCount) {
        // 중복 사용을 위한 메서드 화
        inputStringIsNullOrEmpty(inputGameCount);
        
        try {
            int gameCount = Integer.parseInt(inputGameCount);
            if (gameCount <= 0) {
                throw new IllegalArgumentException("시도할 정수는 1 이상이어야 합니다.");
            }
            return gameCount;
        } catch (Exception e) { // 어떤 에러로 들어오든 받기 위해서
            throw new IllegalArgumentException("시도할 횟수는 숫자 & 양의 정수로 입력해야합니다.");
        }
    }
    
    // CarNames를 입력받는 메서드
    private String[] inputCarNames() {
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        return validateInputCarNames(inputCarNames);
    }
    
    private String[] validateInputCarNames(String inputCarNames) {
        // 중복 사용을 위한 메서드 화
        inputStringIsNullOrEmpty(inputCarNames);
        
        // 이런 것도 메서드로 빼버리면 오히려 가독성이 떨어진다고 생각해서 아래처럼 작성
        String[] names = inputCarNames.split(",");
        validateEachName(names);
        return names;
    }
    
    private void inputStringIsNullOrEmpty(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("입력받는 값이 공백일 수 없습니다.");
        }
    }
    
    private void validateEachName(String[] names) {
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("5자 이하의 이름만 입력할 수 있습니다. : " + name);
            }
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
        }
    }
    
}
