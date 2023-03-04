import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
public class FelineTest {
    @Test
    public void getFamilyReturnStringTest(){
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals("Неверное название семейства",expected,actual);
    }

    @Test
    public void eatMeatReturnListOfStringTest() throws Exception {
        Feline feline = new Feline();
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Кошачьи такое не едят",expected,actual);
    }

    @Test
    public void getKittensIncreaseByOneTest(){
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals("Нет",expected,actual);

    }

    @Test
    public void getKittensIntIncreaseByFourTest(){
        Feline feline = new Feline();
        int expected = 4;
        int actual = feline.getKittens(4);
        Assert.assertEquals("Неверное количество кошачьих",expected,actual);
    }
}
