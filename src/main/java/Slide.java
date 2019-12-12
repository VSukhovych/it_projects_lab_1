import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Slide {

    private BufferedImage image;
    File bmpFile = new File("bmpImage.bmp");

    {
        try {
            image = ImageIO.read(bmpFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
