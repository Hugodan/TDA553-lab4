public class EngineOffState implements EngineState {
    @Override
    public void startEngine(Car car) {
        car.setEngineState(new EngineOnState());
        car.engineOn = true;
    }
    
    @Override
    public void stopEngine(Car car) {
        //Engine is off already.
    }
}