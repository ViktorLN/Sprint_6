import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> foodType;

    public AnimalTest(String animalKind, List<String> foodType) {
        this.animalKind = animalKind;
        this.foodType = foodType;
    }

    @Parameterized.Parameters
    public static Object [][] getLionSexDate() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                { "Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFamilyReturnStringTest(){
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual =animal.getFamily();
        Assert.assertEquals("Ошибка в описании семейств",expected,actual);
    }

    @Test
    public void getFoodReturnListOfStringTest() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalKind);
        Assert.assertEquals("Неверно указан тип пищи", foodType,actual);
    }

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
}
