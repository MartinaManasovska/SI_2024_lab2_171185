import java.util.ArrayList;
import java.util.List;

public class SILab2Test {
    @Test
    public void testEveryBranchCriterion() {
        // Test case 1: Кога allItems е null
        try {
            SILab2.checkCart(null, 500);
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException ex) {
            assertEquals("allItems list can't be null!", ex.getMessage());
        }

        //Test case 2: Кога item's name не е null
        Item item1 = new Item(null, "01234", 100, 0.2f);
        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        assertFalse(SILab2.checkCart(itemList1, 500));

        // Test case 3: Кога item's name е празен стринг
        Item item2 = new Item("", "01234", 100, 0.2f);
        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(item2);
        assertTrue(SILab2.checkCart(itemList2, 500));

        // Test case 4: Кога the item's barcode е null
        Item item3 = new Item("Item3", null, 100, 0.2f);
        List<Item> itemList3 = new ArrayList<>();
        itemList3.add(item3);
        try {
            SILab2.checkCart(itemList3, 500);
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException ex) {
            assertEquals("No barcode!", ex.getMessage());
        }

        // Test case 5: item's barcode contains invalid characters
        Item item4 = new Item("Item4", "0123a", 100, 0.2f);
        List<Item> itemList4 = new ArrayList<>();
        itemList4.add(item4);
        try {
            SILab2.checkCart(itemList4, 500);
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException ex) {
            assertEquals("Invalid character in item barcode!", ex.getMessage());
        }

        // Test case TTT: item's price > 300, discount > 0, and barcode starts with '0'
        Item item5 = new Item("Item5", "01234", 400, 0.2f);
        List<Item> itemList5 = new ArrayList<>();
        itemList5.add(item5);
        assertTrue(SILab2.checkCart(itemList5, 500)); //Expected outcome true, as condition is met.

        // Test case TTF: item's price > 300, discount > 0, but barcode does not start with '0'
        Item item6 = new Item("Item6", "11234", 400, 0.2f);
        List<Item> itemList6 = new ArrayList<>();
        itemList6.add(item6);
        assertFalse(SILab2.checkCart(itemList6, 500)); //Expected outcome false, as condition is not met.

        // Test case 8: item's price <= 300, discount > 0, and barcode starts with '0'
        Item item7 = new Item("Item7", "01234", 200, 0.2f);
        List<Item> itemList7 = new ArrayList<>();
        itemList7.add(item7);
        assertTrue(SILab2.checkCart(itemList7, 500));

        // Test case 9: item's price <= 300, discount <= 0, and barcode starts with '0'
        Item item8 = new Item("Item8", "01234", 200, 0);
        List<Item> itemList8 = new ArrayList<>();
        itemList8.add(item8);
        assertTrue(SILab2.checkCart(itemList8, 500));
}
