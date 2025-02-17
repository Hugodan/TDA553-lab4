
import org.junit.Test;
import static org.junit.Assert.*;

public class Volvo240Test {


    @Test
    public void testVolvo240SpeedFactor(){
        Volvo240 Volvo240 = new Volvo240();
        Volvo240.speedFactor();
        assertEquals(100*0.01*1.25, Volvo240.speedFactor(), 0.01);
        
    }
    

}
