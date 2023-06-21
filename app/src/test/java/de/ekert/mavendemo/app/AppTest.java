package de.ekert.mavendemo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.ekert.mavendemo.exceptions.DivisorIsZeroException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private static App app;
	
	@BeforeAll
	public static void beforeAll() {
    	app = new App("meine App");
	}
	
    /**
     * Rigorous Test :-)
     */
    @Test
    public void quotientTest()
    {
        try {
			assertEquals(3,app.quotient(9,3));
		} catch (DivisorIsZeroException e) {
			assertTrue(false);
		}
    }
    
    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(DivisorIsZeroException.class, () ->
            app.quotient(1, 0));
        assertEquals("Divisor darf nicht 0.0 sein", exception.getMessage());
    }
}
