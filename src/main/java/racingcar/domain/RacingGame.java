package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

// 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
// 라는 요구사항이 있어서 최대한 단일한 책임을 가지도록 만들어 봄.
// 하지만 오히려 더 보기 힘들다고 판단되면 내가 생각하기에 균형이 잡힌 만큼으로 고쳐봄
public class RacingGame {
    
    public void play() {
        
        // Console로 열린 scanner를 닫아주기 위해 try/finally
        try{
            // 경주할 자동차 이름 입력 받기
            String[] carNames = inputCarNames();
        } finally {
            Console.close();
        }
        
    }
    
    // CarNames를 입력받는 메서드
    private String[] inputCarNames() {
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        return validateInputCarNames(inputCarNames);
    }
    
    private String[] validateInputCarNames(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.isEmpty()) {
            throw new IllegalArgumentException("입력받는 값이 공백일 수 없습니다.");
        }
        
        // 이런 것도 메서드로 빼버리면 오히려 가독성이 떨어진다고 생각해서 아래처럼 작성
        String[] names = inputCarNames.split(",");
        validateEachName(names);
        return names;
    }
    
    private void validateEachName(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이하의 이름만 입력할 수 있습니다. : " + name);
            }
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
        }
    }

}
