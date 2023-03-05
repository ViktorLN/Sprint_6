import com.example.Feline;
import com.example.IKittensCounter;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class LionTest {
    @Test
    public void doesHaveManeIncorrectValueShowErrorTest(){
        Exception exception = assertThrows(Exception.class, () -> {
            IKittensCounter iKittensCounter = Mockito.mock(IKittensCounter.class);
            Predator predator = new Feline();
            Lion lion = new Lion("конфетка", iKittensCounter, predator);

        });
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual = exception.getMessage();
        assertTrue(expected.contains(actual));
    }
}
