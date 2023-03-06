import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalWithParameterizedTest {

    private final String animalKind;
    private final List<String> foodType;

    public AnimalWithParameterizedTest(String animalKind, List<String> foodType) {
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
    public void getFoodReturnListOfStringTest() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalKind);
        Assert.assertEquals("Неверно указан тип пищи", foodType, actual);
    }
}
