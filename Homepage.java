import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Homepage extends javax.swing.JFrame {
    private Customer Customer;
    private DetailTransaksi DetailTransaksi;
    private Supplier Supplier;
    private Transaksi Transaksi;

    public Homepage() {
        initComponents();
        initClock();
    }

    private void initComponents() {

        BackgroundBiru = new javax.swing.JPanel();
        PilihMenuLabel = new javax.swing.JLabel();
        SelamatDatangLabel = new javax.swing.JLabel();
        MenuComboBox = new javax.swing.JComboBox<>();
        PilihButton = new javax.swing.JButton();
        Tanggal = new javax.swing.JLabel();
        ImageIcon logoIcon = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(
                new ImageIcon(logoIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 221));

        BackgroundBiru.setBackground(new java.awt.Color(0, 102, 221));
        BackgroundBiru.add(logoLabel);
        BackgroundBiru.setLayout(null);

        logoLabel.setBounds((BackgroundBiru.getWidth() - 200) / 2 + 410, -10, 200, 200);

        PilihMenuLabel.setFont(new java.awt.Font("Segoe UI", 1, 22));
        PilihMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        PilihMenuLabel.setText("Silahkan pilih menu berikut");

        SelamatDatangLabel.setFont(new java.awt.Font("Segoe UI", 1, 28));
        SelamatDatangLabel.setForeground(new java.awt.Color(255, 255, 255));
        SelamatDatangLabel.setText("Selamat Datang,");

        MenuComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14));
        MenuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Edit Customer", "Edit Supplier", "Lihat Data Transaksi", "Lihat Detail Transaksi" }));
        MenuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuComboBoxActionPerformed(evt);
            }
        });

        PilihButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        PilihButton.setForeground(new java.awt.Color(0, 102, 221));
        PilihButton.setText("Pilih");
        for (java.awt.event.ActionListener al : PilihButton.getActionListeners()) {
            PilihButton.removeActionListener(al);
        }
        PilihButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PilihButtonCustActionPerformed(evt);
            }
        });

        Tanggal = new javax.swing.JLabel();
        Tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Tanggal.setForeground(new java.awt.Color(255, 255, 255));
        Tanggal.setText(getCurrentTime());

        javax.swing.GroupLayout BackgroundBiruLayout = new javax.swing.GroupLayout(BackgroundBiru);
        BackgroundBiru.setLayout(BackgroundBiruLayout);
        BackgroundBiruLayout.setHorizontalGroup(
                BackgroundBiruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BackgroundBiruLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Tanggal)
                                .addContainerGap())
                        .addGroup(BackgroundBiruLayout.createSequentialGroup()
                                .addGap(308, 308, 308)
                                .addComponent(SelamatDatangLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(BackgroundBiruLayout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addGroup(BackgroundBiruLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(MenuComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(PilihMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PilihButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(287, Short.MAX_VALUE)));
        BackgroundBiruLayout.setVerticalGroup(
                BackgroundBiruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BackgroundBiruLayout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(SelamatDatangLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PilihMenuLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MenuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PilihButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148,
                                        Short.MAX_VALUE)
                                .addComponent(Tanggal)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BackgroundBiru, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BackgroundBiru, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void MenuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedOption = (String) MenuComboBox.getSelectedItem();
        if (selectedOption.equals("Edit Customer")) {
            for (java.awt.event.ActionListener al : PilihButton.getActionListeners()) {
                PilihButton.removeActionListener(al);
            }
            PilihButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PilihButtonCustActionPerformed(evt);
                }
            });
        } else if (selectedOption.equals("Edit Supplier")) {
            for (java.awt.event.ActionListener al : PilihButton.getActionListeners()) {
                PilihButton.removeActionListener(al);
            }
            PilihButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PilihButtonSupActionPerformed(evt);
                }
            });
        } else if (selectedOption.equals("Lihat Data Transaksi")) {
            for (java.awt.event.ActionListener al : PilihButton.getActionListeners()) {
                PilihButton.removeActionListener(al);
            }
            PilihButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PilihButtonDataTransActionPerformed(evt);
                }
            });
        } else if (selectedOption.equals("Lihat Detail Transaksi")) {
            for (java.awt.event.ActionListener al : PilihButton.getActionListeners()) {
                PilihButton.removeActionListener(al);
            }
            PilihButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PilihButtonDetailActionPerformed(evt);
                }
            });
        }

    }

    private String getCurrentTime() {
        // Get the current time and format it
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(new Date());
    }

    private void initClock() {
        // Use Timer to update the time label every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tanggal.setText(getCurrentTime());
            }
        });
        timer.start();
    }

    private void PilihButtonCustActionPerformed(java.awt.event.ActionEvent evt) {
        Customer customer = new Customer();
        customer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Mengatur GUI untuk ditutup pada dispose
        customer.setVisible(true);
    }

    private void PilihButtonSupActionPerformed(java.awt.event.ActionEvent evt) {
        Supplier supplier = new Supplier();
        supplier.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        supplier.setVisible(true);
    }

    private void PilihButtonDataTransActionPerformed(java.awt.event.ActionEvent evt) {
        Transaksi transaksi = new Transaksi();
        transaksi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        transaksi.setVisible(true);
    }

    private void PilihButtonDetailActionPerformed(java.awt.event.ActionEvent evt) {
        DetailTransaksi detailTransaksi = new DetailTransaksi();
        detailTransaksi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailTransaksi.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Homepage homepage = new Homepage();
                homepage.setLocationRelativeTo(null); // Mengatur posisi frame ke tengah layar
                homepage.setVisible(true);

            }
        });
    }

    private javax.swing.JPanel BackgroundBiru;
    private javax.swing.JComboBox<String> MenuComboBox;
    private javax.swing.JButton PilihButton;
    private javax.swing.JLabel PilihMenuLabel;
    private javax.swing.JLabel SelamatDatangLabel;
    private javax.swing.JLabel Tanggal;
}