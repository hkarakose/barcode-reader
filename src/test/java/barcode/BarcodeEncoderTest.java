package barcode;


import barcodescanner.BarcodeEncoder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class BarcodeEncoderTest extends TestCase {
    BarcodeEncoder encoder = new BarcodeEncoder();

    public BarcodeEncoderTest(String testName) {
        super(testName);
    }

    @Test
    public void testBarcodeEncode() {
        try {
            encoder.encode(BarcodeFormat.UPC_A, "12121212121");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
