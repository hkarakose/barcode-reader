package barcodescanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;

/**
 * User: halil
 * Date: 9/22/13
 * Time: 12:40 AM
 */
public class BarcodeEncoder {
    private static final String DEFAULT_IMAGE_FORMAT = "PNG";

    public void encode(BarcodeFormat barcodeFormat, String contents) throws WriterException, IOException {
        encode(barcodeFormat, contents, 200, 200);
    }

    public void encode(BarcodeFormat barcodeFormat, String contents, int width, int height) throws WriterException, IOException {
        MultiFormatWriter barcodeWriter = new MultiFormatWriter();
        BitMatrix matrix = barcodeWriter.encode(contents, barcodeFormat, width, height);
        MatrixToImageWriter.writeToFile(matrix, DEFAULT_IMAGE_FORMAT, new File("out.png"));
    }
}
