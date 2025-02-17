import java.awt.*;

public class FlatBedCar extends Car{

    private double angle;
    protected double maxAngle;

    public FlatBedCar(int doors, Color carColor, int power, String model, double maxAngle){
        super(doors,carColor,power,model);
        angle = 0;
        this.maxAngle = maxAngle;
    }

    public double getAngle(){
        return angle;
    }

    private double getMaxAngle(){
        return maxAngle;
    }

    //Set angle of the flatbed. Cannot go bellow 0 or above max angle
    public void setAngle(double newAngle){
        if (getCurrentSpeed() == 0){
            if(newAngle > getMaxAngle()) {
                angle = getMaxAngle();
            }
            else if(newAngle < 0) {
                angle = 0;
            }
            else{
                angle = newAngle;
            }
        }
    }

    public void raiseAngle(double var){
        setAngle(getAngle()+var);
    }

    public void lowerAngle(double var){
        setAngle(getAngle()-var);
    }

    //Cannot start engine if angle is not 0. would indicate ramp is up for car transport
    @Override
    public void startEngine(){
        if (getAngle() == 0){
            currentSpeed = 0.1;
        }
	        
    }
    

}
