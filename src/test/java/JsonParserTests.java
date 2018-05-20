import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import shop.Cart;

import java.io.File;


public class JsonParserTests {


    private JsonParser jsonParser;


    @BeforeEach
    void setUp() {
        this.jsonParser = new JsonParser();
    }

    @Nested
    class writeToFileTests {
        @ParameterizedTest
        @ValueSource(strings = {"alexey-cart", "111BBvv6", "!@#$%^&"})
        void writeToFileIsFilePresentPositive(String cartName) {
            String fileName = cartName + ".json";

            Cart alexeyCart = new Cart(cartName);
            jsonParser.writeToFile(alexeyCart);


            Assertions.assertTrue(isFilePresent(fileName), "File isn't created!");
        }

        @ParameterizedTest
        @ValueSource(strings = {"con", ">", "||", "***", "<"})
        void writeToFileIsFilePresentNegative(String cartName) {
            String fileName = cartName + ".json";

            Cart alexeyCart = new Cart(cartName);
            jsonParser.writeToFile(alexeyCart);


            Assertions.assertFalse(isFilePresent(fileName), "File is created!");
        }

        @Nested
        class readFromFileTests{

            @Test
            void readFromFilePositive(){

            }

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
}
