package guiExploration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FramesAndPanels extends JFrame implements ActionListener, Runnable {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JPanel pnlOne;
    private JPanel pnlTwo;
    private JPanel pnlThree;
    private JPanel pnlFour;
    private JPanel pnlFive;

    public FramesAndPanels(String title) throws HeadlessException {
        super(title);

    }

    private void createGUI() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlOne = createPanel(Color.WHITE);
        pnlTwo = createPanel(Color.BLUE);
        pnlThree = createPanel(Color.YELLOW);
        pnlFour = createPanel(Color.DARK_GRAY);
        pnlFive = createPanel(Color.GREEN);
        getContentPane().add(pnlOne, BorderLayout.CENTER);
        getContentPane().add(pnlTwo, BorderLayout.WEST);
        getContentPane().add(pnlThree, BorderLayout.NORTH);
        getContentPane().add(pnlFour, BorderLayout.EAST);
        getContentPane().add(pnlFive, BorderLayout.SOUTH);
//        repaint();
        setVisible(true);

    }

    private JPanel createPanel (Color c) {
        // Create
        JPanel panel = new JPanel();
        panel.setBackground(c);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {
        createGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new FramesAndPanels("BorderLayout"));
    }


}
