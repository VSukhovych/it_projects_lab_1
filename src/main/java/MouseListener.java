import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener {

    public static void main(String[] args) {

        Frame frame = new Frame("Example Frame");

        Component textArea = new TextArea("Click here to see mouse click info...");

        textArea.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                TextArea source = (TextArea) evt.getSource();
                if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
                    source.setText(source.getText() + "nLeft mouse button clicked on point [" + evt.getPoint().x + "," + evt.getPoint().y + "]");
                }
                if ((evt.getModifiers() & InputEvent.BUTTON2_MASK) != 0) {
                    source.setText(source.getText() + "nCenter mouse button clicked on point [" + evt.getPoint().x + "," + evt.getPoint().y + "]");
                }
                if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
                    source.setText(source.getText() + "nRight mouse button clicked on point [" + evt.getPoint().x + "," + evt.getPoint().y + "]");
                }
            }

        });

        frame.add(textArea, BorderLayout.NORTH);
        int width = 300;
        int height = 300;
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}