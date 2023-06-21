package de.ekert.mavendemo.app;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.ekert.mavendemo.exceptions.DivisorIsZeroException;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final float DELTA = 0.00001f;
	private String name;
	
	public App(String name) {
		this.name = name;
	}
	
	/**
	 * Multiplicates x with y
	 * @param x
	 * @param y
	 * @return x*y
	 * @throws DivisorIsZeroException 
	 */
	public float quotient (float divident, float divisor) throws DivisorIsZeroException {
		if (Math.abs(divisor) < DELTA) {
			throw new DivisorIsZeroException("Divisor darf nicht 0.0 sein");
		}
		return divident/divisor;
	}
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private static Logger logger = LogManager.getLogger(App.class);
	public static void main( String[] args )
    {
        App app = new App("Mobile University 2 Application");
        try {
			System.out.println(app.quotient(3.0f, 4.5f));
			logger.info("Meine tolle App funktioniert.");
			app.quotient(0,0);
		} catch (DivisorIsZeroException e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
    }
}
