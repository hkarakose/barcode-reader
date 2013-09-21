package barcodescanner;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.ImageReader;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: halil
 * Date: 9/22/13
 * Time: 12:38 AM
 */
public class BarcodeDecoder {
    private static String getDecodeText(File file) {
        BufferedImage image;
        try {
            image = ImageReader.readImage(file);
        } catch (IOException ioe) {
            return ioe.toString();
        }
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        try {
            result = new MultiFormatReader().decode(bitmap);
        } catch (ReaderException re) {
            return re.toString();
        }
        return String.valueOf(result.getText());
    }
}
