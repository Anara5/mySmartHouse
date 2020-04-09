package SmartHouse;

import java.util.HashMap;

public class Fridge {
    private final OrderSystem orderSystem;
    private final HashMap<String, Integer> quantities = new HashMap<>();

    public Fridge(OrderSystem orderSystem) {
        this.orderSystem = orderSystem;
    }

    public void add(String foodType, int quantity) {
        quantities.put(foodType, quantity);
    }

    public void take(String foodType, int quantity) {
        if (quantity == this.quantities.get(foodType))
            orderSystem.placeOrder("", 0);
    }
}
