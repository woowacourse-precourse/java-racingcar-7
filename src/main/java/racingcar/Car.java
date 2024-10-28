package racingcar;

public class Car {
    // 필드
    public String name;
    public int dashCount;

    // 생성자
    public Car(String name) {
        this.name = name;
        this.dashCount = 0;     // "-" 개수 0으로 초기화
    }

    public String getName() {
        return name;
    }

    public void move() {
        moveDashCount();
        printDash(dashCount);
    }

    public void stop() {
        stopDashCount();
        printDash(dashCount);
    }

    public int moveDashCount() {
        dashCount++;
        return dashCount;   // 증가된 "-" 개수 반환
    }

    public int stopDashCount() {
        return dashCount;   // 변화 없음 (현재 "-" 개수 반환)
    }

    public void printDash(int dashCount) {
        for (int i = 0; i < dashCount; i++) {
            System.out.print("-");      // dashCount 개수만큼 "-" 출력
        }
    }
}