package racingcar;

import camp.nextstep.edu.missionutils.*;

public class InputView {

    public Car[] getCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] names = input.split(",");

        Car[] cars = new Car[names.length];

        for(int i = 0; i < names.length; i++){
            String name = names[i];

            if(name.isEmpty() || name.length() > 5 || !isAlphabetic(name)){
                throw new IllegalArgumentException("잘못 입력 하셨습니다.");
            }

            if (isDuplicateName(names, i, names[i])) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }

            cars[i] = new Car(names[i]);
        }

        return cars;
    }

    public int getNumberOfRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String rounds = Console.readLine();
        int numRounds;

        try {
            numRounds = Integer.parseInt(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }

        if (numRounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }

        return numRounds;
    }

    private boolean isAlphabetic(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isAlphabetic(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicateName(String[] names, int currentIndex, String name) {
        for (int j = 0; j < currentIndex; j++) {
            if (name.equals(names[j])) {
                return true;
            }
        }
        return false;
    }

}
