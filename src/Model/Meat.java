package Minitest2;

import java.time.LocalDate;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost()*getWeight();
    }

    @Override
    public LocalDate localDateGetExpiryDate() {
        return null;
    }

    @Override
    public double getRealMoney() {
        return getAmount()*97/100;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id='" + super.getId()+ '\'' +
                ", name='" + super.getName() + '\'' +
                ", manufacturingDate=" + super.getManufacturingDate() +
                ", cost=" + super.getCost() +
                ", weight=" + weight +
                '}';
    }
}
