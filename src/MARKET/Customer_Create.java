package MARKET;

public class Customer_Create {

    public String name;
    public double money;
    public boolean isDrivingCar;

    public static Customer_Create Customer_init(){
        Customer_Create customer = new Customer_Create();
        customer.name = "¹Ë¿Í£º" + ((int) (Math.random() * 10000));
        customer.money = (1 + Math.random()) * 1000;
        customer.isDrivingCar = Math.random() > 0.5;

        return customer;
    }

}

