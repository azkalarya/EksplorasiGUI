import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EksplorasiGUI extends JFrame implements ActionListener {
    private JTextField txtNama;
    private JLabel lblHasil;
    private JButton btnSapa, btnReset;

    public EksplorasiGUI() {
        setTitle("Eksplorasi GUI Java");
        setSize(380, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        panelInput.add(new JLabel("Masukkan Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel("Output:"));
        lblHasil = new JLabel("-");
        panelInput.add(lblHasil);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSapa = new JButton("Sapa");
        btnReset = new JButton("Reset");
        panelTombol.add(btnSapa);
        panelTombol.add(btnReset);

        add(panelInput, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);

        btnSapa.addActionListener(this);
        btnReset.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSapa) {
            String nama = txtNama.getText().trim();
            lblHasil.setText(nama.isEmpty() ? "Nama kosong!" : "Halo, " + nama + "!");
        } else if (e.getSource() == btnReset) {
            txtNama.setText("");
            lblHasil.setText("-");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EksplorasiGUI().setVisible(true));
    }
}