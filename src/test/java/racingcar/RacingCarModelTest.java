//package racingcar;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//import org.junit.jupiter.api.Test;
//import racingcar.raceDto.RacingRequest;
//import racingcar.raceDto.RacingResponse;
//
//public class RacingCarModelTest {
//
//    @Test
//    public void testStartRace_withValidInput() {
//        // Given
//        String names = "pobi,woni,jun";
//        int times = 5;
//        RacingRequest request = new RacingRequest(names, times);
//        RacingCarModel model = new RacingCarModel();
//
//        // When
//        RacingResponse response = model.startRace(request);
//
//        // Then
//        Assert.assertNotNull(response);
//        String result = response.res();
//        Assert.assertTrue(result.contains("최종 우승자"));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testStartRace_withNullRequest() {
//        // Given
//        RacingRequest request = null;
//        RacingCarModel model = new RacingCarModel();
//
//        // When
//        model.startRace(request);
//
//        // Then
//        // IllegalArgumentException이 발생해야 합니다.
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testStartRace_withEmptyName() {
//        // Given
//        String names = "";
//        int times = 5;
//        RacingRequest request = new RacingRequest(names, times);
//        RacingCarModel model = new RacingCarModel();
//
//        // When
//        model.startRace(request);
//
//        // Then
//        // IllegalArgumentException이 발생해야 합니다.
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testStartRace_withLongName() {
//        // Given
//        String names = "pobi123456";
//        int times = 5;
//        RacingRequest request = new RacingRequest(names, times);
//        RacingCarModel model = new RacingCarModel();
//
//        // When
//        model.startRace(request);
//
//        // Then
//        // IllegalArgumentException이 발생해야 합니다.
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testStartRace_withNegativeTimes() {
//        // Given
//        String names = "pobi,woni,jun";
//        int times = -1;
//        RacingRequest request = new RacingRequest(names, times);
//        RacingCarModel model = new RacingCarModel();
//
//        // When
//        model.startRace(request);
//
//        // Then
//        // IllegalArgumentException이 발생해야 합니다.
//    }
//}