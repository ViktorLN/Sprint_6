import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Test
    public void getFoodIncorrectValueShowErrorTest() throws Exception{
        Exception exception = assertThrows(Exception.class, () -> {
            Animal animal = new Animal();
            animal.getFood("Всеядное");
        });
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actual = exception.getMessage();
        assertTrue(expected.contains(actual));
    }
    @Test
    public void getFamilyReturnStringTest(){
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        Assert.assertEquals("Ошибка в описании семейств", expected, actual);
    }
}
