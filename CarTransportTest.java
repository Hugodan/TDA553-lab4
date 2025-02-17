import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Stack;

public class CarTransportTest {
    @Test
    public void testload() {
        CarTransport carTransport = new CarTransport();
        Car car = new Volvo240();
        carTransport.lowerAngle();
        Stack<Car> testStack = new Stack<>();
        testStack.push(car);
        carTransport.loadCar(car);
        assertEquals(testStack, carTransport.getLoadedCars());
        
}

    @Test
    public void testUnload() {
        CarTransport carTransport = new CarTransport();
        Car car = new Volvo240();
        Stack<Car> testStack = new Stack<>();

        carTransport.lowerAngle();
        carTransport.loadCar(car);
        carTransport.unloadCar();
        assertEquals(testStack, carTransport.getLoadedCars());

}

    @Test
    public void testRaiseAngle(){
        CarTransport carTransport = new CarTransport();
        carTransport.lowerAngle();
        carTransport.raiseAngle();
        assertEquals(0, carTransport.getAngle(), 0.01);
    }

    @Test
    public void testCarTransportMove(){
        CarTransport carTransport = new CarTransport();
        Car car = new Volvo240();
        carTransport.lowerAngle();
        carTransport.loadCar(car);
        carTransport.raiseAngle();
        carTransport.move();
        assertEquals(car.getPosX(), carTransport.getPosX(), 0.01);
        assertEquals(car.getPosY(), carTransport.getPosY(), 0.01);



    }
    
}
