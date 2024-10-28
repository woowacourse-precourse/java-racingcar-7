package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarCollectionFactoryTest {

    @Test
    void create() {
        // given
        Processor processor = new SimpleDelimiterProcessor();
        AbstractCarFactory carFactory = new RandomCarFactory();
        CarCollectionFactory carCollectionFactory = new CarCollectionFactory(processor, carFactory);

        // when
        CarCollection carCollection = carCollectionFactory.create("a,b,c");

        // then
        assertEquals(3, carCollection.getCars().size());
    }
}