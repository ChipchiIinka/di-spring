package ru.egar.dispring.di;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.egar.dispring.TestConfig;
import ru.egar.dispring.di.annotation.InjectRandomInt;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(TestConfig.class)
@ExtendWith(SpringExtension.class)
class InjectRandomIntAnnotationProcessorTest {

    @InjectRandomInt(min = 12, max = 35)
    int randomInt = 0;

    @Autowired
    InjectRandomIntAnnotationProcessor processor;

    @Test
    void testInjectRandomInt() {
        processor.postProcessBeforeInitialization(this, "injectRandomIntTest");
        assertTrue(randomInt >= 12 && randomInt <= 35, "Repeat value should be between 12 and 35");
    }

    @Test
    void testInjectRandomIntMultipleTimes() {
        boolean foundDifferentValues = false;
        int previousValue = 0;
        for (int i = 0; i < 10; i++) {
            processor.postProcessBeforeInitialization(this, "injectRandomIntTest");
            int currentValue = randomInt;
            if (i > 0 && currentValue != previousValue) {
                foundDifferentValues = true;
            }
            previousValue = currentValue;
            System.out.println(currentValue);
            assertTrue(currentValue >= 12 && currentValue <= 35, "Repeat value should be between 12 and 35");
        }
        assertTrue(foundDifferentValues, "The random values should vary across iterations");
    }
}