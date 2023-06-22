package de.ekert.mavendemo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.ekert.mavendemo.exceptions.DivisorIsZeroException;
import de.ekert.mavendemo.swing.MinimalSwingApplication;

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
			assertEquals(0, app.quotient(1, 0));
		} catch (DivisorIsZeroException e) {
			assertTrue(true);//this is ok, we triggered the exception
		}
    }
    
    @Test
    public void getterTest() {
    	assertEquals("meine App", app.getName());
    	app.setName("other");
    	assertEquals("other", app.getName());
    }
    
    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(DivisorIsZeroException.class, () ->
            app.quotient(1, 0));
        assertEquals("Divisor darf nicht 0.0 sein", exception.getMessage());
    }
    
    @Test
    void mainTesting() {
    	App.main(null);
    	MinimalSwingApplication.main((String[])null);
    }
}
