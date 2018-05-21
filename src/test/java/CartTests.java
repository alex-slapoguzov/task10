import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.RealItem;
import shop.VirtualItem;

public class CartTests {

    private VirtualItem virtualItem;
    private RealItem realItem;

    @ParameterizedTest
    @CsvSource({"Class: class shop.VirtualItem; Name: Windows; Price: 11.0; Size on disk: 20000.0, Windows, 11.0, 20000.0",
            "Class: class shop.VirtualItem; Name: Microsoft office; Price: 30.0; Size on disk: 8500.0, Microsoft office, 30.0, 8500.0"})
    void virtualItemToStringMethodTest(String rightValue, String name, double price, double size){
        virtualItem = new VirtualItem();
        realItem = new RealItem();

        virtualItem.setName(name);
        virtualItem.setPrice(price);
        virtualItem.setSizeOnDisk(size);

        realItem.setWeight(weight);
        realItem.setName(name);
        realItem.setPrice(price);






        @ParameterizedTest
        @CsvSource({"Class: class shop.RealItem; Name: Audi; Price: 32026.9; Weight: 1560.0, Audi, 32026.9, 1560",
                "Class: class shop.RealItem; Name: BMW; Price: 22103.9; Weight: 1400.0, BMW, 22103.9, 1400.0"})
        void realItemToStringMethodTest(String rightValue, String name, double price, double weight) {


        }
}
