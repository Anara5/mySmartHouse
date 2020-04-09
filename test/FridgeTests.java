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



    



   /*
    private OrderingTest Assert;


    public OrderingTest(OrderingTest anAssert) {
        Assert = anAssert;
    }

    //empty fridge gets vegetables ordered
    @Test
    public void theFridgeGetsVegetables() {

        String[] vegetables = new String[]{};
        String[] vegetablesOrdered = {"cucumbers", "potatoes", "carrots", "tomatoes"};
        Expect(vegetables, EqualTo(vegetablesOrdered));
    }

    private void EqualTo(String[] vegetablesOrdered) {

    }

    private void Expect(String[] vegetables, String[] vegetablesOrdered) {
    }


    @Test
    public void takeOut_Carrots_from_theFridge() {

        final String [] vegetables = {"cucumbers", "tomatoes", "carrots", "potatoes"};
        String[] vegetablesLeft = {"tomatoes", "potatoes", "cucumbers"};
        Assert.assertEquals(vegetables, vegetablesLeft);
    }

    */
