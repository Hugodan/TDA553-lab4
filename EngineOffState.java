public class EngineOffState implements EngineState {
    @Override
    public void startEngine(Car car) {
        car.setEngineState(new EngineOnState());
        car.engineOn = true;
    }
}