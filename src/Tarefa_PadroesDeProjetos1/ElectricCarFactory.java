package Tarefa_PadroesDeProjetos1;

public class ElectricCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new ElectricCar();
    }
}
