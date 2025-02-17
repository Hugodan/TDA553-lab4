import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;
public class SanityCheck {
    @Test
    public void testCarGasAmount() {
        Car car = new Saab95(); 
        double oldSpeed = car.getCurrentSpeed();
        car.gas(2);
        assertTrue(oldSpeed == car.getCurrentSpeed());
    }

    @Test
    public void testCarBrakeAmount() {
        Car car = new Saab95(); 
        double oldSpeed = car.getCurrentSpeed();
        car.brake(2);
        assertTrue(oldSpeed == car.getCurrentSpeed());
    }

    @Test
    public void testCarSpeedLimit() {
        Car car = new Saab95(); 
        for(int i = 0;i< 100;i++){
            car.gas(1);
        }
        assertTrue(car.getEnginePower() >= car.getCurrentSpeed());
    }

    @Test
    public void testCarGasPositive() {
        Car car = new Saab95();
        double oldSpeed = car.getCurrentSpeed();
        car.gas(-1);
        assertFalse(car.getCurrentSpeed()<oldSpeed);
    }

    @Test
    public void testCarBrakeNegative() {
        Car car = new Saab95(); 
        double oldSpeed = car.getCurrentSpeed();
        car.brake(-1);
        assertFalse(car.getCurrentSpeed()>oldSpeed);
    }
    @Test
    public void testTurnLeft() {
        Car car = new Volvo240();

        int[] expectedDirections = {3, 2, 1, 0};
        
        for (int expectedDirection : expectedDirections) {
            car.turnLeft();
            assertEquals(expectedDirection, car.getDirection());
        }
    }


    @Test
    public void testTurnRight() {
        Car car = new Volvo240();

        int[] expectedDirections = {1, 2, 3, 0}; 
        
        for (int expectedDirection : expectedDirections) {
            car.turnRight();
            assertEquals(expectedDirection, car.getDirection());
        }
    }

    @Test
    public void testMove() {
        Car car = new Volvo240();
        car.startEngine();

        int[] directions = {0, 1, 2, 3};
        double[][] expectedPositions = {
            {0, 0.1}, 
            {0.1, 0.1}, 
            {0.1, 0}, 
            {0, 0} 
        };

        for (int i = 0; i < directions.length; i++) {
            car.move(); 
            car.turnRight();

            assertEquals(expectedPositions[i][0], car.getPosX(), 0.01); 
            assertEquals(expectedPositions[i][1], car.getPosY(), 0.01); 
        }
    }

    @Test
    public void testGetNrDoors(){
        Car car = new Volvo240();
        assertEquals(4, car.getNrDoors());
    }


    @Test
    public void testColor(){
        Car car = new Volvo240();
        car.setColor(Color.red);
        assertEquals(Color.red, car.getColor());
    }

}
