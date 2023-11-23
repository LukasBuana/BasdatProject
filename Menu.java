
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private Customer Customer;
    private Supplier Supplier;
    private Transaksi Transaksi;

    public Menu() {
        super("Menu");

        JButton cust_button = new JButton("Customer");
        JButton sup_button = new JButton("Supplier");
        JButton trans_button = new JButton("DataTransaksi");
        cust_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Customer == null) {
                    Customer = new Customer();
                } else {
                    Customer.setVisible(true);
                }
            }
        });

        sup_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Supplier == null) {
                    Supplier = new Supplier();
                } else {
                    Supplier.setVisible(true);
                }
            }
        });

        trans_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Transaksi == null) {
                    Transaksi = new Transaksi();
                } else {
                    Transaksi.setVisible(true);
                }
            }
        });

        // Set the horizontal margin for the buttons
        int horizontalMargin = 50;
        // Set the vertical gap between buttons
        int verticalGap = 20;

        cust_button.setBorder(
                BorderFactory.createEmptyBorder(verticalGap, horizontalMargin, verticalGap, horizontalMargin));
        sup_button.setBorder(
                BorderFactory.createEmptyBorder(verticalGap, horizontalMargin, verticalGap, horizontalMargin));
        trans_button.setBorder(
                BorderFactory.createEmptyBorder(verticalGap, horizontalMargin, verticalGap, horizontalMargin));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, horizontalMargin, verticalGap));
        buttonPanel.add(cust_button);
        buttonPanel.add(sup_button);
        buttonPanel.add(trans_button);

        // Create the contentPane with BoxLayout and set alignment to Y_AXIS
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Add some glue to center the buttonPanel vertically
        contentPane.add(Box.createVerticalGlue());
        contentPane.add(buttonPanel);
        contentPane.add(Box.createVerticalGlue());

        setContentPane(contentPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu());
    }
}