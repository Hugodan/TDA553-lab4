
import org.junit.Test;
import static org.junit.Assert.*;

public class Saab95Test {
    @Test
    public void testSaab95TurboOn() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        assertTrue(saab95.turboOn);
}   
    @Test
    public void testSaab95TurboOff(){
        Saab95 saab95 = new Saab95();
        saab95.setTurboOff();
        assertFalse(saab95.turboOn);

    }
    @Test
    public void testSaab95SpeedFactor(){
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        saab95.speedFactor();
        assertEquals(125*0.01*1.3, saab95.speedFactor(), 0.01);

        saab95.setTurboOff();
        saab95.speedFactor();
        assertEquals(125*0.01*1.0, saab95.speedFactor(),0.01);
        
    }
}