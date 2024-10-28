package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingSnapshotProviderTest {
    private static RacingSnapshotProvider snapshotProvider = new RacingSnapshotProvider();

    @Test
    public void 거리가_0인_선수() throws Exception{
        Player player = new Player("a");
        Assertions.assertThat(snapshotProvider.getSnapshotOf(player)).isEqualTo(player.getName() +  " : ");
    }

    @Test
    public void 거리가_0이_아닌_선수() throws Exception{
        Player player = new Player("a");
        player.move();
        player.move();
        player.move();
        Assertions.assertThat(snapshotProvider.getSnapshotOf(player)).isEqualTo(player.getName() +  " : ---");
    }
}
