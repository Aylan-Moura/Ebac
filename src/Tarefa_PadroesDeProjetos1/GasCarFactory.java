package Tarefa_PadroesDeProjetos1;

public class GasCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new GasCar();
    }
}
