package workshop.testing.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by nayza on 17/4/2561.
 */
public class RecipeTest {

    @Test
    public void can_read_data_from_water(){

        // Arrange
        InputStream inputStream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");

        // Act
        Recipe recipe = Recipe.readFromStream(inputStream);

        // Assert
        assertNotNull(recipe);
        assertEquals("water", recipe.id);
        assertEquals("Water", recipe.title);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);

    }

    @Test
    public void can_read_data_with_multiple_line_description_from_mixed(){

        // Arrange
        InputStream inputStream = RecipeTest.class.getResourceAsStream("/recipes/mixed.txt");

        // Act
        Recipe recipe = Recipe.readFromStream(inputStream);

        // Assert
        assertNotNull(recipe);
        assertEquals("punch", recipe.id);
        assertEquals("Punch", recipe.title);
        assertEquals("Juice of 3 lemons\n" +
                "1 orange\n" +
                "1 pint grape juice\n" +
                "1 cup sugar\n" +
                "1 cup water\n" +
                "1 pine apple juice\n" +
                "Mix all together and strain. Add large piece of ice.", recipe.description);

    }





}