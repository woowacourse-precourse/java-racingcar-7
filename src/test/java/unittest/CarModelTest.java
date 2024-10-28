package unittest;

import java.util.List;
import mvc.model.CarModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Car;

import static org.assertj.core.api.Assertions.*;

public class CarModelTest {

    private CarModel carModel;
    List<String> dummyNames = List.of("chc","lee","kim");

    @BeforeEach
    void initCarModel(){
        this.carModel = new CarModel();
    }

    void appendDummyCar(){
        dummyNames.forEach(name ->{
            Car newCar = this.carModel.createCar(name);
            this.carModel.insertCar(newCar);
        });
    }

    @DisplayName("CarModel은 데이터 생성기능을 제공해야한다.")
    @Test
    void shouldProvideCreate(){
        String name = "new";
        Car newCar = this.carModel.createCar(name);

        assertThat(newCar).isNotEqualTo(null);
        assertThat(newCar).isInstanceOf(Car.class);
    }

    @DisplayName("CarModel은 데이터 삽입 기능과 찾기 기능을 제공해야 한다")
    @Test
    void shouldProvideInsertAndFind(){
        this.appendDummyCar();

        String name = "new";
        Car newCar = this.carModel.createCar(name);

        this.carModel.insertCar(newCar);
        Car findCar = this.carModel.findCarByName(newCar.getName());

        assertThat(newCar.getName()).isEqualTo(findCar.getName());
        assertThat(newCar.getMove()).isEqualTo(findCar.getMove());
    }

    @DisplayName("repository에서 얻은 데이터는 복사본이어야 한다.")
    @ParameterizedTest
    @CsvSource({
            "fab"
    })
    void shouldCopiedReferenceTest(String name){
        Car newCar = this.carModel.createCar(name);
        this.carModel.insertCar(newCar);

        Car before = this.carModel.findCarByName(name);

        before.setMove(10);

        Car after = this.carModel.findCarByName(name);

        assertThat(before.getName()).isEqualTo(after.getName());
        assertThat(before.getMove()).isNotEqualTo(after.getMove());
        assertThat(before).isNotEqualTo(after);
    }

    @DisplayName("확률적으로 이동해야한다")
    @Test
    void shouldMoveCarRandomly(){
        this.appendDummyCar();
        final int totalRepeat = 1000;
        final double probability = 0.6;
        final int expectedMove = (int) Math.round(totalRepeat*probability);
        final double tolerance = 0.1;
        final int toleranceMove = (int) Math.round(totalRepeat*tolerance);

        for(int i = 0; i < totalRepeat; i++) {
            this.carModel.tryMoveAllCars();
        }

        this.dummyNames.forEach(name ->{
            Car target = this.carModel.findCarByName(name);
            assertThat(target.getMove()).isCloseTo(expectedMove,within(toleranceMove));
        });

    }



}
