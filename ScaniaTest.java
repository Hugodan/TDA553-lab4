import org.junit.Test;
import static org.junit.Assert.*;

public class ScaniaTest {
    @Test
    public void testSetAngle1(){
        Scania scania = new Scania();
        scania.setAngle(45);
        assertEquals(45, scania.getAngle(), 0.01);

    }

    @Test
    public void testSetAngle2(){
        Scania scania = new Scania();
        scania.startEngine();
        scania.gas(1);
        //assertEquals(0,scania.getAngle(),0.01);
        assertNotEquals(0,scania.getCurrentSpeed(),0.01);
        scania.raiseAngle(45);

        // assertEquals(0, scania.getAngle(), 0.01);

    }
    

}
