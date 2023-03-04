import com.example.Feline;
import com.example.IKittensCounter;
import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expected;
    public LionTest(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Object [][] getLionSexDate() {
        return new Object[][] {
        {"Самец",true},
        { "Самка", false},
        };
    }

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doesHaveManeIndicateSexTest() throws Exception {
        IKittensCounter iKittensCounter = Mockito.mock(Feline.class);
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, iKittensCounter, predator);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals("Ошибка в указании пола",expected, actual);
    }

    @Test
    public void getKittensShowLionCountTest() throws Exception {
        IKittensCounter iKittensCounter = new Feline();
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, iKittensCounter, predator);
        int expected = 1;
        int actual = lion.getKittens();
        Assert.assertEquals("Неверное колличество отображаемых львов",expected,actual);
    }

    @Test
    public void getKittensWithMockGetTrueTest() throws Exception {
        IKittensCounter iKittensCounter = Mockito.mock(Feline.class);
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, iKittensCounter, predator);
        lion.getKittens();
        Mockito.verify(iKittensCounter, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodGetListOfFoodTest() throws Exception {
        IKittensCounter iKittensCounter = Mockito.mock(IKittensCounter.class);
        Predator predator = new Feline();
        Lion lion = new Lion(sex, iKittensCounter, predator);
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        Assert.assertEquals("Такая пища не подходит для льва",expected,actual);
    }

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
