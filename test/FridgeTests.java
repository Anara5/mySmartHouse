import SmartHouse.Fridge;
import SmartHouse.OrderSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FridgeTests {

    @Test
    public void take_whenEmpty_sendsOrder() {
        TestOrderSystem orderSystem = new TestOrderSystem();
        Fridge fridge = new Fridge(orderSystem);
        fridge.add("carrots", 5);
        fridge.take("carrots", 5);

        assertTrue(orderSystem.didReceiveOrder);
    }

    @Test
    public void fridge_whenItemsRemain_noOrderPlaced() {
        TestOrderSystem orderSystem = new TestOrderSystem();
        Fridge fridge = new Fridge(orderSystem);
        fridge.add("carrots", 5);

        fridge.take("carrots", 3);

        assertFalse(orderSystem.didReceiveOrder);
    }

    @Test
    public void fridge_multipleFoods_noOrderPlaced() {
        TestOrderSystem orderSystem = new TestOrderSystem();
        Fridge fridge = new Fridge(orderSystem);
        fridge.add("carrots", 5);
        fridge.add("tomatoes", 7);

        fridge.take("carrots", 5);

        assertTrue(orderSystem.didReceiveOrder);
    }

    private class TestOrderSystem implements OrderSystem {
        public boolean didReceiveOrder = false;

        @Override
        public void placeOrder(String foodType, int quantity) {
            didReceiveOrder = true;
        }
    }
}