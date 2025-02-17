import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Stack;

public class RepairShopTest {
    @Test
    public  void testRepairShopLoad() {
        RepairShop<Volvo240> shop = new RepairShop<>(4);
        Volvo240 car1 = new Volvo240();
        Stack<Car> testqueue = new Stack<>();
        shop.loadCar(car1);
        shop.getLoadedCars();
        testqueue.add(car1);

    assertEquals(testqueue, shop.getLoadedCars());
        
    }
    @Test
    public  void testRepairShopUnLoad() {
        RepairShop<Volvo240> shop = new RepairShop<>(4);
        Volvo240 car1 = new Volvo240();
        Stack<Car> testqueue = new Stack<>();
        shop.loadCar(car1);
        shop.unloadCar(car1);
        shop.getLoadedCars();

    assertEquals(testqueue, shop.getLoadedCars());
        
    }

    @Test
    public  void testRepairShopCapacity() {
        RepairShop<Volvo240> shop = new RepairShop<>(2);
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = new Volvo240();
        Volvo240 car3 = new Volvo240(); 

        shop.loadCar(car1);
        shop.loadCar(car2);

        assertThrows(IndexOutOfBoundsException.class, () -> shop.loadCar(car3));   
}
    
    //@Test
    //public  void testRepairShopLoadCar() {
    //RepairShop<Volvo240> shop = new RepairShop<>(2);
    //    Saab95 car1 = new Saab95();
    //    shop.loadCar(car1);
    //}
}
