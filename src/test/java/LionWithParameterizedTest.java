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

@RunWith(Parameterized.class)
public class LionWithParameterizedTest {

    private final String sex;
    private final boolean expected;
    public LionWithParameterizedTest(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object [][] getLionSexDate() {
        return new Object[][] {
        {"Самец", true},
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
        Assert.assertEquals("Ошибка в указании пола", expected, actual);
    }

    @Test
    public void getKittensShowLionCountTest() throws Exception {
        IKittensCounter iKittensCounter = new Feline();
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, iKittensCounter, predator);
        int expected = 1;
        int actual = lion.getKittens();
        Assert.assertEquals("Неверное колличество отображаемых львов", expected, actual);
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
        Assert.assertEquals("Такая пища не подходит для льва", expected, actual);
    }

    // тест со стебом на проверку работы самого метода
    @Test
    public void getFoodGetListOfFoodWIthStabTest() throws Exception {
        IKittensCounter iKittensCounter = Mockito.mock(IKittensCounter.class);
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, iKittensCounter, predator);
        Mockito.when(predator.eatMeat()).thenReturn(Arrays.asList("Камень", "Ножницы", "Бумага"));
    }
}
