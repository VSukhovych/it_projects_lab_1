import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayImage extends JFrame {

    private static int i;

    public static void main(String avg[]) {
        new MouseReceiver();
        new DisplayImage().showNextSlide();
    }

    public static void clickMouse(String button, Robot r, int number) {
        int mouse;
        switch (button) {
            case "left":
                mouse = InputEvent.BUTTON1_MASK;
                break;
            case "right":
                mouse = InputEvent.BUTTON3_MASK;
                break;
            case "middle":
                mouse = InputEvent.BUTTON2_MASK;
                break;
            default:
                mouse = InputEvent.BUTTON1_MASK;
                break;
        }
        for (int i = 0; i < number; i++) {
            r.mousePress(mouse);
            r.delay(1000);
            r.mouseRelease(mouse);
            r.delay(1000);
        }
    }

    private void displayImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(img);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(1282, 853);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private ArrayList<String> getImages() {
        ArrayList<String> images = new ArrayList();
        String path = this.getClass().getResource("/images/dawn-190055_1280.bmp").getPath();
        images.add(new File(path).getAbsolutePath());
        path = this.getClass().getResource("/images/elephant-1822636_1280.bmp").getPath();
        images.add(new File(path).getAbsolutePath());
        path = this.getClass().getResource("/images/nature-3082832_1280.bmp").getPath();
        images.add(new File(path).getAbsolutePath());
        return images;
    }

    private void showNextSlide() {
        ArrayList<String> imageList = getImages();
        displayImage(imageList.get(i));
        i++;
    }
}