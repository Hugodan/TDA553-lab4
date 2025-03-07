public interface EngineState {
    default void startEngine (Car car) {}
    default void stopEngine(Car car) {}
}