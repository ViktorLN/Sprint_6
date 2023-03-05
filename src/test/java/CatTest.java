import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

public class CatTest {


    @Test
    public void getSoundCatsReturnStringTest(){
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        Assert.assertEquals("Кошка такого не говорила", expected, actual);
    }

    @Test
    public void getFoodReturnListOfStringTest() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual;
        actual = cat.getFood();
        Assert.assertEquals("Кошка такое не ест", expected, actual);
    }

    // тест с моками на проверку работы самого метода
    @Test
    public void getFoodWithMockTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
