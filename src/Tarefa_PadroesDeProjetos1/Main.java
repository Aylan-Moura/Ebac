package Tarefa_PadroesDeProjetos1;

public class Main {
    public static void main(String[] args) {
        CarFactory factoryEletrica = new ElectricCarFactory();
        Car carroEletrico = factoryEletrica.createCar();
        carroEletrico.drive();

        CarFactory factoryCombustao = new GasCarFactory();
        Car carroGasolina = factoryCombustao.createCar();
        carroGasolina.drive();
    }
}