
public class CarRepairShopController extends Controller{

    protected RepairShop<Volvo240> volvoRepairShop;
    
    public CarRepairShopController(int capacity, double posX, double posY) {
        this.volvoRepairShop = new RepairShop<>(capacity, posX, posY);

    }
    

        boolean checkInShop(double posX, double posY, double shopX, double shopY){
            return shopX <= posX && shopX + 101 >= posX &&  shopY <= posY && shopY + 96 >= posY;
        }

}
