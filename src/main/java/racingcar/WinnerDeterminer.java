package racingcar;

public class WinnerDeterminer {

    // 가장 높은 위치의 자동차를 찾아 우승자를 반환
    public static Car[] determineWinners(Car[] cars) {
        int maxPosition = getMaxPosition(cars);
        return filterWinners(cars, maxPosition);
    }

    // 모든 자동차 중 가장 높은 위치를 계산
    private static int getMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    // 최대 위치와 같은 위치를 가진 자동차만 필터링하여 우승자를 결정
    private static Car[] filterWinners(Car[] cars, int maxPosition) {
        int count = 0;
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                count++;
            }
        }

        Car[] winners = new Car[count];
        int index = 0;
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners[index++] = car;
            }
        }
        return winners;
    }
}
