package guiExploration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelsAndWidgets extends JFrame implements ActionListener, Runnable {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JPanel pnlOne;
    private JPanel pnlTwo;
    private JPanel pnlThree;
    private JPanel pnlFour;
    private JPanel pnlBtn;
    private JButton btnLoad;
    private JButton btnUnload;
    private JButton btnFind;
    private JButton btnSwitch;

    public PanelsAndWidgets(String title) throws HeadlessException {
        super(title);
    }

    private void createGUI() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        pnlOne = createPanel(Color.WHITE);
        pnlTwo = createPanel(Color.LIGHT_GRAY);
        pnlThree = createPanel(Color.LIGHT_GRAY);
        pnlFour = createPanel(Color.LIGHT_GRAY);
        pnlBtn = createPanel(Color.LIGHT_GRAY);
        getContentPane().add(pnlOne, BorderLayout.CENTER);
        getContentPane().add(pnlTwo, BorderLayout.WEST);
        getContentPane().add(pnlThree, BorderLayout.NORTH);
        getContentPane().add(pnlFour, BorderLayout.EAST);
        getContentPane().add(pnlBtn, BorderLayout.SOUTH);

        // Buttons
        btnLoad = createButton("Load");
        btnUnload = createButton("Unload");
        btnFind = createButton("Find");
        btnSwitch = createButton("Switch");

        layoutButtonPanel();

        setVisible(true);
    }

    private JPanel createPanel (Color c) {
        // Create
        JPanel panel = new JPanel();
        panel.setBackground(c);
        return panel;
    }

    private void addToPanel(JPanel jp,Component c, GridBagConstraints
            constraints,int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        jp.add(c, constraints);
    }

    private void layoutButtonPanel() {
        GridBagLayout layout = new GridBagLayout();
        pnlBtn.setLayout(layout);
        // add components to the grid
        GridBagConstraints constraints = new GridBagConstraints();
        // Defaults
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 100;
        constraints.weighty = 100;

        // Layout Methods
        addToPanel(pnlBtn, btnLoad,constraints,0,0,2,1);
        addToPanel(pnlBtn, btnUnload,constraints,3,0,2,1);
        addToPanel(pnlBtn, btnFind,constraints,0,2,2,1);
        addToPanel(pnlBtn, btnSwitch,constraints,3,2,2,1);
    }

    private JButton createButton(String str) {
        JButton panelButton = new JButton(str);
        panelButton.addActionListener(this);
        return panelButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {
        createGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PanelsAndWidgets("BorderLayout"));
    }


}
