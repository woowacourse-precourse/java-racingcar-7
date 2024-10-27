package racingcar.view;

public class OutputView {

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(String carName, int distance) {
        StringBuilder visualizeDistance = new StringBuilder();
        for (int d = 0; d < distance; d++) {
            visualizeDistance.append("-");
        }
        System.out.println(carName + " : " + visualizeDistance);

    }
}