package racingcar;

public class Winner {
    public static void who() {
        int maxLength = -1;
        for (String carName : Application.carNamesList) {
            carName = carName.trim();
            Car car = Application.carStates.get(carName);
            int carStateLength = car.getState().length();

            // 누가 더 멀리 갔는지 비교하고 우승자 정하기
            if (carStateLength > maxLength) {
                maxLength = carStateLength;
                Application.winners.clear(); // 더 멀리 간 차 찾으면 리스트 초기화
                Application.winners.add(car.getName()); // 우승자 갱신
            } else if (carStateLength == maxLength) {
                Application.winners.add(car.getName());   // 같은 길이의 우승자 추가
            }
        }
    }

    public static void print() {
        // 우승자 출력
        if (Application.winners.size() == 1) {
            System.out.println("최종 우승자 : " + Application.winners.get(0));
        } else {
            // 쉼표로 구분
            String winnersList = String.join(", ", Application.winners);
            System.out.println("최종 우승자 : " + winnersList);
        }
    }
}
