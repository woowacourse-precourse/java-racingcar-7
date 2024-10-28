package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
class ParticipatingCarsTest {
    @Test
    public void 참가_자동차_생성_성공() {
        String[] carNames = {"pobi", "woni", "com"};

        ParticipatingCars participatingCars = new ParticipatingCars(carNames);

        assertThat(participatingCars).isNotNull();
    }

    @Test
    public void 참가_자동차_중복_예외발생() {
        String[] carNames = {"pobi", "pobi"};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ParticipatingCars(carNames))
                .withMessage("[ERROR] 중복되는 자동차 이름이 있습니다");
    }

    @Test
    public void getWinner_우승자_반환_성공() {
        String[] carNames = {"pobi", "wodi", "com"};

        ParticipatingCars participatingCars = new ParticipatingCars(carNames);

        for(int i = 0 ; i < 2; i++){
            Car car =  participatingCars.getParticipatingCars().get(i);
            int initialPosition = car.getPosition();
            while (car.getPosition() == initialPosition) {
                car.forward(); // 위치가 증가할 때까지 계속 전진
            }
        }
        List<String> winners = participatingCars.getWinner();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "wodi");
    }
}