import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnaplogFrame extends JFrame
{
    private JAnalyze mainWindow;
    private static final long serialVersionUID = 1L;
    private JTextField genplot = new JTextField(20);
    private JTextField xplot = new JTextField(20);
    private JTextField tcptrace = new JTextField(20);
    private JTextField snaplogs = new JTextField(20);
    private JTextField variables = new JTextField(40);

    public SnaplogFrame(JAnalyze mainWindow) {
        this.mainWindow = mainWindow;

        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        JPanel tmpPanel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel("Genplot:"));
        genplot.setText(mainWindow.getProperties().getProperty("genplot", "/usr/local/bin/genplot"));
        genplot.getDocument().addDocumentListener(new PropertyListener(mainWindow, "genplot"));
        panel.add(genplot);
        tmpPanel.add(panel);
        cp.add(tmpPanel);
        panel = new JPanel();
        tmpPanel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel("Xplot:"));
        xplot.setText(mainWindow.getProperties().getProperty("xplot", "/usr/local/bin/xplot"));
        xplot.getDocument().addDocumentListener(new PropertyListener(mainWindow, "xplot"));
        panel.add(xplot);
        tmpPanel.add(panel);
        cp.add(tmpPanel);
        panel = new JPanel();
        tmpPanel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel("Tcptrace:"));
        tcptrace.setText(mainWindow.getProperties().getProperty("tcptrace", "/usr/local/bin/tcptrace"));
        tcptrace.getDocument().addDocumentListener(new PropertyListener(mainWindow, "tcptrace"));
        panel.add(tcptrace);
        tmpPanel.add(panel);
        cp.add(tmpPanel);
        panel = new JPanel();
        tmpPanel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel("Snaplog directory:"));
        snaplogs.setText(mainWindow.getProperties().getProperty("snaplogs", ""));
        snaplogs.getDocument().addDocumentListener(new PropertyListener(mainWindow, "snaplogs"));
        panel.add(snaplogs);
        tmpPanel.add(panel);
        cp.add(tmpPanel);
        panel = new JPanel();
        tmpPanel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel("Variables:"));
        variables.setText(mainWindow.getProperties().getProperty("variables",
                    "CurCwnd,SampleRTT,SlowStart,MaxRTT,CurSsthresh,CongestionSignals"));
        variables.getDocument().addDocumentListener(new PropertyListener(mainWindow, "variables"));
        panel.add(variables);
        tmpPanel.add(panel);
        cp.add(tmpPanel);

        setSize(515, 180);
    }

    public String getGenplot() {
        return genplot.getText();
    }

    public String getXplot() {
        return xplot.getText();
    }

    public String getTcptrace() {
        return tcptrace.getText();
    }

    public String getSnaplogs() {
        return snaplogs.getText();
    }

    public String getVariables() {
        return variables.getText();
    }
}
