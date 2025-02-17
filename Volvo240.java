import java.awt.*;

public class Volvo240 extends Car{

    private double trimFactor;

    public Volvo240(){
        super(4,Color.black,100,"Volvo240");
        trimFactor = 1.25;
    }

    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
