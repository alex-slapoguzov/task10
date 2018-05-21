import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.Parser;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;


import java.io.File;


public class JsonParserTests {


    private Parser jsonParser;
    private Cart cart;

    private RealItem realItem;
    private VirtualItem virtualItem;


    @BeforeEach
    void setUp() {
        jsonParser = new JsonParser();
     /*   car = new RealItem();
        license = new VirtualItem();

        car.setName("Nissan");
        car.setPrice(25300);
        car.setWeight(1720);

        license.setName("License");
        license.setPrice(50);
        license.setSizeOnDisk(150);*/
    }

    @AfterEach
    void tearDown() {
        String pathName = "src/main/resources/";

        File file = new File(pathName);
        for (File item : file.listFiles()) {
            if (!(item.getName().equals("andrew-cart.json")
                    | item.getName().equals("eugen-cart.json"))) {

                item.delete();
            }
        }
    }

    @Nested
    class writeToFileTests {
        @ParameterizedTest
        @ValueSource(strings = {"alexey-cart", "111BBvv6", "!@#$%^&"})
        void writeToFileIsFilePresentPositive(String cartName) {
            String fileName = cartName + ".json";
            cart = new Cart(cartName);

            jsonParser.writeToFile(cart);

            Assertions.assertTrue(isFilePresent(fileName), "File isn't created!");
        }

        @ParameterizedTest
        @ValueSource(strings = {"con", ">aaa", "||aaaa", "***aaaa", "<aaaa"})
        void writeToFileIsFilePresentNegative(String cartName) {
            String fileName = cartName + ".json";
            cart = new Cart(cartName);

            jsonParser.writeToFile(cart);

            Assertions.assertFalse(isFilePresent(fileName), "File is created!");
        }


        @ParameterizedTest
        @ValueSource(strings = {"alexey-cart", "111BBvv6", "!@#$%^&"})
        void writeToFileNotEmptyFilePositive(String cartName) {
            String fileName = cartName + ".json";
            cart = new Cart(cartName);
           /* igorCart.addRealItem(car);
            igorCart.addVirtualItem(license);*/
            jsonParser.writeToFile(cart);

            Assertions.assertTrue(isFileNotEmpty(fileName), "File is empty!");
        }


    }

    @Nested
    class readFromFileTests {

        @ParameterizedTest
        @CsvSource({"src/test/resources/andrew-cart.json, Audi, 32026.9", "src/main/resources/eugen-cart.json, BMW, 22103.9"})
        void readFromFilePositive(String path, String name, double price) {
            realItem = new RealItem();
            virtualItem = new VirtualItem();
            Cart cart = jsonParser.readFromFile(new File(path));


            cart.addRealItem(realItem);



        }

    }


    public boolean isFilePresent(String name) {
        File file = new File("src/main/resources/" + name);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFileNotEmpty(String name) {
        File file = new File("src/main/resources/" + name);
        if (file.length() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
