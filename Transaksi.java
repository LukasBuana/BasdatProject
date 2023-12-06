import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Transaksi extends javax.swing.JFrame {
    private Connection connection;
    private int selectedId;
    private int transactionID;
    String logam = "LM0001";
    int harga = 15000;
    private javax.swing.JLabel Tanggal;

    public Transaksi() {
        initComponents();
        initClock();
    }

    private void initComponents() {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                "database=PROJEK_AKHIR;user=sa;password=lukas123;" +
                "integratedSecurity=false;" +
                "encrypt=true;" +
                "trustServerCertificate=true;" +
                "trustStore=<path-to-truststore>;" +
                "trustStorePassword=<truststore-password>;" +
                "loginTimeout=30;";
        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        jPanel1 = new javax.swing.JPanel();
        PilihAktivitasLabel = new javax.swing.JLabel();
        AktivitasComboBox = new javax.swing.JComboBox<>();
        IDTransTxtBox = new javax.swing.JTextField();
        IDTransLabel = new javax.swing.JLabel();
        TglTransLabel = new javax.swing.JLabel();
        TglTransTxtBox = new javax.swing.JTextField();
        IDCustLabel = new javax.swing.JLabel();
        IDCustTxtBox = new javax.swing.JTextField();
        CreateButton = new javax.swing.JButton();
        OpsiMitraComboBox = new javax.swing.JComboBox<>();
        OpsiMitraLabel = new javax.swing.JLabel();
        IDLogamLabel = new javax.swing.JLabel();
        IDLogamComboBox = new javax.swing.JComboBox<>();
        KuantitasTxtBox = new javax.swing.JTextField();
        KuantitasLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TransaksiTabel = new javax.swing.JTable();
        CariDataLabel = new javax.swing.JLabel();
        CariDataTxtBox = new javax.swing.JTextField();
        FilterDataLabel = new javax.swing.JLabel();
        FilterDataComboBox = new javax.swing.JComboBox<>();
        CariDataButton = new javax.swing.JButton();
        FilterButton = new javax.swing.JButton();
        Tanggal = new javax.swing.JLabel();
        ImageIcon logoIcon = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(
                new ImageIcon(logoIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 221));
        jPanel1.add(logoLabel);
        jPanel1.setLayout(null);

        logoLabel.setBounds((jPanel1.getWidth() - 200) / 2 + 100, -10, 200, 200);
        PilihAktivitasLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        PilihAktivitasLabel.setForeground(new java.awt.Color(255, 255, 255));
        PilihAktivitasLabel.setText("Pilih Aktivitas:");

        AktivitasComboBox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Create", "Delete", "Update" }));

        IDTransTxtBox.setToolTipText("");
        IDTransTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTransTxtBoxActionPerformed(evt);
            }
        });

        IDTransLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        IDTransLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDTransLabel.setText("ID Transaksi");

        TglTransLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        TglTransLabel.setForeground(new java.awt.Color(255, 255, 255));
        TglTransLabel.setText("Tanggal Transaksi");

        TglTransTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TglTransTxtBoxActionPerformed(evt);
            }
        });

        IDCustLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        IDCustLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDCustLabel.setText("ID Customer");

        IDCustTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCustTxtBoxActionPerformed(evt);
            }
        });

        CreateButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        CreateButton.setForeground(new java.awt.Color(0, 102, 221));
        CreateButton.setText("Create");

        OpsiMitraComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Supplier" }));

        OpsiMitraLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        OpsiMitraLabel.setForeground(new java.awt.Color(255, 255, 255));
        OpsiMitraLabel.setText("Opsi Mitra:");

        IDLogamLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        IDLogamLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDLogamLabel.setText("ID Logam:");

        IDLogamComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LM0001 - Kuningan",
                "LM0002 - Besi", "LM0003 - Aluminium", "LM0004 - Seng", "LM0005 - Stainless" }));
        IDLogamComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDLogamComboBoxActionPerformed(evt);
            }
        });

        KuantitasTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KuantitasTxtBoxActionPerformed(evt);
            }
        });

        KuantitasLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        KuantitasLabel.setForeground(new java.awt.Color(255, 255, 255));
        KuantitasLabel.setText("Kuantitas Logam (Kg)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CreateButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(PilihAktivitasLabel)
                                                                .addComponent(AktivitasComboBox, 0,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(IDTransLabel)
                                                                .addComponent(IDTransTxtBox)
                                                                .addComponent(TglTransLabel)
                                                                .addComponent(TglTransTxtBox)
                                                                .addComponent(IDCustLabel)
                                                                .addComponent(IDCustTxtBox)
                                                                .addComponent(OpsiMitraLabel)
                                                                .addComponent(OpsiMitraComboBox, 0,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(IDLogamLabel)
                                                                .addComponent(IDLogamComboBox, 0, 191, Short.MAX_VALUE))
                                                        .addComponent(KuantitasLabel))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(KuantitasTxtBox))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(PilihAktivitasLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AktivitasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(OpsiMitraLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OpsiMitraComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(IDTransLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDTransTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TglTransLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TglTransTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IDCustLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDCustTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IDLogamLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDLogamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(KuantitasLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(KuantitasTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        TransaksiTabel.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null }
                },
                new String[] {
                        "Customer ID", "Transaksi ID", "Tanggal", "Total Harga", "ID Logam", "Kuantitas (Kg)"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                    java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(TransaksiTabel);
        ListSelectionModel selectionModel = TransaksiTabel.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = TransaksiTabel.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get the ID of the selected row
                        int selectedId = (int) TransaksiTabel.getValueAt(selectedRow, 0);
                        int transactionID = Integer.parseInt((String) TransaksiTabel.getValueAt(selectedRow, 1));

                        setSelectedId(selectedId);
                        setTransactionID(transactionID);
                    }
                }
            }
        });

        CariDataLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        CariDataLabel.setForeground(new java.awt.Color(0, 102, 221));
        CariDataLabel.setText("Cari Data");

        CariDataTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariDataTxtBoxActionPerformed(evt);
            }
        });

        FilterDataLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        FilterDataLabel.setForeground(new java.awt.Color(0, 102, 221));
        FilterDataLabel.setText("Filter Data Berdasarkan");

        FilterDataComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Urutan Nomor Transaksi ID Paling Awal", "Urutan Nomor Transaksi ID Paling Akhir",
                        "Paling Lama Ditambahkan", "Paling Baru Ditambahkan", "Transaksi Terbesar",
                        "Transaksi Terkecil" }));

        CariDataButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        CariDataButton.setForeground(new java.awt.Color(0, 102, 221));
        CariDataButton.setText("Cari Data");
        CariDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariDataButtonActionPerformed(evt);
            }
        });

        FilterButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        FilterButton.setForeground(new java.awt.Color(0, 102, 221));
        FilterButton.setText("Terapkan Filter");
        FilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterButtonActionPerformed(evt);
            }
        });

        Tanggal = new javax.swing.JLabel();
        Tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14));
        Tanggal.setForeground(new java.awt.Color(0, 102, 221));
        Tanggal.setText(getCurrentTime());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(CariDataTxtBox,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(CariDataButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 129,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(FilterDataLabel)
                                                        .addComponent(CariDataLabel))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(FilterDataComboBox,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(FilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Tanggal)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CariDataLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CariDataTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CariDataButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FilterDataLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FilterDataComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FilterButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Tanggal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
        readRecordsCus();
        for (ActionListener al : CreateButton.getActionListeners()) {
            CreateButton.removeActionListener(al);
        }
        CreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IDCustLabel.getText().equals("ID Customer")) {
                    addRecordCus();
                    readRecordsCus();
                } else if (IDCustLabel.getText().equals("ID Supplier")) {
                    // Actions for creating a supplier
                    addRecordSup();
                    readRecordsSup();
                }
            }
        });

        CariDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IDCustLabel.getText().equals("ID Customer")) {
                    cariDataCus();
                } else if (IDCustLabel.getText().equals("ID Supplier")) {
                    cariDataSup();
                }
            }
        });
        FilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilter = (String) FilterDataComboBox.getSelectedItem();
                String query = "";

                if (IDCustLabel.getText().equals("ID Customer")) {
                    query = "SELECT b.Customer_ID, a.* FROM RiwayatTransaksi a "
                            + "JOIN TransaksiCustomer b ON b.Transaksi_ID = a.Transaksi_ID";
                    switch (selectedFilter) {
                        case "Urutan Nomor Transaksi ID Paling Awal":
                            query += " ORDER BY Transaksi_ID ASC";
                            break;
                        case "Urutan Nomor Transaksi ID Paling Akhir":
                            query += " ORDER BY Transaksi_ID DESC";
                            break;
                        case "Paling Baru Ditambahkan":
                            query += " ORDER BY CONVERT(DATE, Tanggal, 103) DESC";
                            break;
                        case "Paling Lama Ditambahkan":
                            query += " ORDER BY CONVERT(DATE, Tanggal, 103) ASC";
                            break;
                        case "Transaksi Terbesar":
                            query += " ORDER BY Total_Harga DESC";
                            break;
                        case "Transaksi Terkecil":
                            query += " ORDER BY Total_Harga ASC";
                            break;
                        default:
                            // Default query if no filter is selected
                            break;
                    }
                    executeQueryAndUpdateTableCus(query);
                } else if (IDCustLabel.getText().equals("ID Supplier")) {
                    query = "SELECT b.Supplier_ID, a.* FROM RiwayatTransaksi a "
                            + "JOIN TransaksiSupplier b ON b.Transaksi_ID = a.Transaksi_ID";
                    switch (selectedFilter) {
                        case "Urutan Nomor Transaksi ID Paling Awal":
                            query += " ORDER BY Transaksi_ID ASC";
                            break;
                        case "Urutan Nomor Transaksi ID Paling Akhir":
                            query += " ORDER BY Transaksi_ID DESC";
                            break;
                        case "Paling Baru Ditambahkan":
                            query += " ORDER BY CONVERT(DATE, Tanggal, 103) DESC";
                            break;
                        case "Paling Lama Ditambahkan":
                            query += " ORDER BY CONVERT(DATE, Tanggal, 103) ASC";
                            break;
                        case "Transaksi Terbesar":
                            query += " ORDER BY Total_Harga DESC";
                            break;
                        case "Transaksi Terkecil":
                            query += " ORDER BY Total_Harga ASC";
                            break;
                        default:
                            // Default query if no filter is selected
                            break;
                    }
                    executeQueryAndUpdateTableSup(query);
                }

            }
        });

        OpsiMitraComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMitra = (String) OpsiMitraComboBox.getSelectedItem();
                configureButtonBasedOnMitra(selectedMitra);
            }
        });

        AktivitasComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) AktivitasComboBox.getSelectedItem();
                configureButtonBasedOnAktivitas(selectedOption);
            }
        });

        AktivitasComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) AktivitasComboBox.getSelectedItem();
                if (selectedOption.equals("Create")) {

                    IDCustLabel.setVisible(true);
                    IDCustTxtBox.setVisible(true);
                    IDTransLabel.setVisible(true);
                    IDTransTxtBox.setVisible(true);
                    IDLogamComboBox.setVisible(true);
                    IDLogamLabel.setVisible(true);
                    TglTransTxtBox.setVisible(true);
                    TglTransLabel.setVisible(true);
                    KuantitasLabel.setVisible(true);
                    KuantitasTxtBox.setVisible(true);
                    CreateButton.setText("Create");

                } else if (selectedOption.equals("Delete")) {
                    KuantitasLabel.setVisible(false);
                    KuantitasTxtBox.setVisible(false);
                    IDCustLabel.setVisible(false);
                    IDCustTxtBox.setVisible(false);
                    IDTransLabel.setVisible(false);
                    IDTransTxtBox.setVisible(false);
                    IDLogamComboBox.setVisible(false);
                    IDLogamLabel.setVisible(false);
                    TglTransTxtBox.setVisible(false);
                    TglTransLabel.setVisible(false);
                    CreateButton.setText("Delete");

                } else if (selectedOption.equals("Update")) {
                    KuantitasLabel.setVisible(true);
                    KuantitasTxtBox.setVisible(true);
                    CreateButton.setText("Update");
                    IDCustLabel.setVisible(false);
                    IDCustTxtBox.setVisible(false);
                    IDTransLabel.setVisible(false);
                    IDTransTxtBox.setVisible(false);
                    IDLogamComboBox.setVisible(true);
                    IDLogamLabel.setVisible(true);
                    TglTransTxtBox.setVisible(false);
                    TglTransLabel.setVisible(false);

                }
            }
        });
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

    private String getCurrentTime() {
        // Get the current time and format it
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(new Date());
    }

    private void configureButtonBasedOnMitra(String selectedMitra) {
        if (selectedMitra.equals("Customer")) {
            IDCustLabel.setText("ID Customer");
            readRecordsCus();

        } else if (selectedMitra.equals("Supplier")) {
            IDCustLabel.setText("ID Supplier");
            readRecordsSup();
        }
    }

    private void configureButtonBasedOnAktivitas(String selectedOption) {
        for (ActionListener al : CreateButton.getActionListeners()) {
            CreateButton.removeActionListener(al);
        }

        if (selectedOption.equals("Create")) {
            CreateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (IDCustLabel.getText().equals("ID Customer")) {
                        addRecordCus();
                        readRecordsCus();
                    } else if (IDCustLabel.getText().equals("ID Supplier")) {
                        // Actions for creating a supplier
                        addRecordSup();
                        readRecordsSup();
                    }
                }
            });
        } else if (selectedOption.equals("Delete")) {
            CreateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (IDCustLabel.getText().equals("ID Customer")) {
                        deleteRecordCus();
                    } else if (IDCustLabel.getText().equals("ID Supplier")) {
                        deleteRecordSup();
                    }
                }
            });
        } else if (selectedOption.equals("Update")) {
            CreateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (IDCustLabel.getText().equals("ID Customer")) {
                        updateLogam();
                        int newkuan = Integer.parseInt(KuantitasTxtBox.getText());

                        updateRecordCus(newkuan);
                    } else if (IDCustLabel.getText().equals("ID Supplier")) {
                        updateLogam();
                        int newkuan = Integer.parseInt(KuantitasTxtBox.getText());
                        updateRecordSup(newkuan);
                    }
                }
            });
        }
    }

    private void setSelectedId(int id) {
        this.selectedId = id;
    }

    private void setTransactionID(int id) {
        this.transactionID = id;
    }

    private int getSelectedId() {
        return selectedId;
    }

    private int getTransactionID() {
        return transactionID;
    }

    private void updateLogam() {
        String selectedOption = (String) IDLogamComboBox.getSelectedItem();
        switch (selectedOption) {
            case "LM0001 - Kuningan":
                logam = "LM0001";
                harga = 70000;
                break;
            case "LM0002 - Besi":
                logam = "LM0002";
                harga = 28000;
                break;
            case "LM0003 - Aluminium":
                logam = "LM0003";
                harga = 17000;
                break;
            case "LM0004 - Seng":
                logam = "LM0004";
                harga = 15000;
                break;
            case "LM0005 - Stainless":
                logam = "LM0005";
                harga = 10000;
                break;
            // Add more cases if needed
        }
    }

    private void addRecordCus() {
        String trans = IDTransTxtBox.getText();
        String tanggal = TglTransTxtBox.getText();
        String cus = IDCustTxtBox.getText();
        int kuan = Integer.parseInt(KuantitasTxtBox.getText());
        updateLogam();
        int totalHarga = kuan * harga;

        try {
            connection.setAutoCommit(false); // Start a transaction

            try (Statement statement = connection.createStatement()) {
                // Get the current maximum Transaksi_ID
                updateLogam();

                // Insert the new record
                String insertSql = "INSERT INTO RiwayatTransaksi(Transaksi_ID,Tanggal,Total_Harga,ID_Logam,Kuantitas_KG) VALUES ('"
                        + trans + "', '"
                        + tanggal + "', '"
                        + totalHarga + "', '"
                        + logam + "','"
                        + kuan + "')";

                statement.executeUpdate(insertSql);

                String insertSqlCus = "INSERT INTO TransaksiCustomer(Transaksi_ID,Customer_ID) VALUES ('"
                        + trans + "', '"
                        + cus + "')";

                statement.executeUpdate(insertSqlCus);

                connection.commit(); // Commit the transaction if everything is successful
                readRecordsCus();
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback(); // Rollback the transaction in case of an error
            } finally {
                connection.setAutoCommit(true); // Restore auto-commit mode
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRecordSup() {
        String trans = IDTransTxtBox.getText();
        String tanggal = TglTransTxtBox.getText();
        String cus = IDCustTxtBox.getText();
        int kuan = Integer.parseInt(KuantitasTxtBox.getText());
        updateLogam();
        int totalHarga = kuan * harga;

        try {
            connection.setAutoCommit(false); // Start a transaction

            try (Statement statement = connection.createStatement()) {
                // Get the current maximum Transaksi_ID
                updateLogam();

                // Insert the new record
                String insertSql = "INSERT INTO RiwayatTransaksi(Transaksi_ID,Tanggal,Total_Harga,ID_Logam,Kuantitas_KG) VALUES ('"
                        + trans + "', '"
                        + tanggal + "', '"
                        + totalHarga + "', '"
                        + logam + "','"
                        + kuan + "')";

                statement.executeUpdate(insertSql);

                String insertSqlSup = "INSERT INTO TransaksiSupplier(Transaksi_ID,Supplier_ID) VALUES ('"
                        + trans + "', '"
                        + cus + "')";

                statement.executeUpdate(insertSqlSup);

                connection.commit(); // Commit the transaction if everything is successful
                readRecordsSup();
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback(); // Rollback the transaction in case of an error
            } finally {
                connection.setAutoCommit(true); // Restore auto-commit mode
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeQueryAndUpdateTableCus(String query) {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Customer", "ID Transaksi", "ID Logam", "Kuantitas (Kg)", "Total Harga",
                            "Tanggal Transaksi" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String harga = resultSet.getString("Total_Harga");
                String tanggal = resultSet.getString("Tanggal");

                model.addRow(new Object[] { id, trans, logam, kuan, harga, tanggal });
            }

            TransaksiTabel.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
            TransaksiTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Customer", "ID Transaksi", "ID Logam", "Kuantitas_KG", "Total Harga",
                            "Tanggal Transaksi" }));
            TransaksiTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void executeQueryAndUpdateTableSup(String query) {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Supplier", "ID Transaksi", "ID Logam", "Kuantitas_KG", "Total Harga",
                            "Tanggal Transaksi" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String harga = resultSet.getString("Total_Harga");
                String tanggal = resultSet.getString("Tanggal");

                model.addRow(new Object[] { id, trans, logam, kuan, harga, tanggal });
            }

            TransaksiTabel.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
            TransaksiTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Supplier", "ID Transaksi", "ID Logam", "Kuantitas_KG", "Total Harga",
                            "Tanggal Transaksi" }));
            TransaksiTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void readRecordsCus() {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT b.Customer_ID,a.* FROM RiwayatTransaksi a \r\n" + //
                        "JOIN TransaksiCustomer b ON b.Transaksi_ID = a.Transaksi_ID\r\n" + //
                        "\r\n" + //
                        "                                ")) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Customer", "ID Transaksi", "ID Logam", "Kuantitas (Kg)", "Total Harga",
                            "Tanggal Transaksi" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String harga = resultSet.getString("Total_Harga");
                String tanggal = resultSet.getString("Tanggal");

                model.addRow(new Object[] { id, trans, logam, kuan, harga, tanggal });
            }

            TransaksiTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            TransaksiTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Customer", "ID Transaksi", "ID Logam", "Kuantitas_KG", "Total Harga",
                            "Tanggal Transaksi" }));
            TransaksiTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void readRecordsSup() {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT b.Supplier_ID,a.* FROM RiwayatTransaksi a \r\n" + //
                        "JOIN TransaksiSupplier b ON b.Transaksi_ID = a.Transaksi_ID\r\n" + //
                        "\r\n" + //
                        "                                ")) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Supplier", "ID Transaksi", "ID Logam", "Kuantitas_KG", "Total Harga",
                            "Tanggal Transaksi" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String harga = resultSet.getString("Total_Harga");
                String tanggal = resultSet.getString("Tanggal");

                model.addRow(new Object[] { id, trans, logam, kuan, harga, tanggal });
            }

            TransaksiTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            TransaksiTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Supplier", "ID Transaksi", "ID Logam", "Kuantitas_KG", "Total Harga",
                            "Tanggal Transaksi" }));
            TransaksiTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void deleteRecordCus() {
        try (Statement statement = connection.createStatement()) {
            int customerID = getSelectedId();
            int transactionID = getTransactionID();

            String deleteChildSql = "DELETE FROM TransaksiCustomer WHERE Customer_ID = " + customerID
                    + " AND Transaksi_ID = " + transactionID;
            statement.executeUpdate(deleteChildSql);

            String deleteParentSql = "DELETE FROM RiwayatTransaksi WHERE Transaksi_ID = " + transactionID;
            statement.executeUpdate(deleteParentSql);

            readRecordsCus();
        } catch (SQLException e) {
            e.printStackTrace();
            readRecordsCus();
        }
    }

    private void deleteRecordSup() {
        try (Statement statement = connection.createStatement()) {
            int SupplierID = getSelectedId();
            int transactionID = getTransactionID();

            String deleteChildSql = "DELETE FROM TransaksiSupplier WHERE Supplier_ID = " + SupplierID
                    + " AND Transaksi_ID = " + transactionID;
            statement.executeUpdate(deleteChildSql);

            String deleteParentSql = "DELETE FROM RiwayatTransaksi WHERE Transaksi_ID = " + transactionID;
            statement.executeUpdate(deleteParentSql);

            readRecordsSup();
        } catch (SQLException e) {
            e.printStackTrace();
            readRecordsCus();
        }
    }

    private void updateRecordCus(int newKuantitas) {
        try (Statement statement = connection.createStatement()) {
            int newTotalHarga = newKuantitas * harga;

            String updateParentSql = "UPDATE RiwayatTransaksi SET ID_Logam = '" + logam + "', Kuantitas_KG = "
                    + newKuantitas + ", Total_Harga = " + newTotalHarga +
                    " WHERE Transaksi_ID = '" + getTransactionID() + "'";
            statement.executeUpdate(updateParentSql);

            readRecordsCus();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateRecordSup(int newKuantitas) {
        try (Statement statement = connection.createStatement()) {
            int newTotalHarga = newKuantitas * harga;

            String updateParentSql = "UPDATE RiwayatTransaksi SET ID_Logam = '" + logam + "', Kuantitas_KG = "
                    + newKuantitas + ", Total_Harga = " + newTotalHarga +
                    " WHERE Transaksi_ID = '" + getTransactionID() + "'";
            statement.executeUpdate(updateParentSql);

            readRecordsSup();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cariDataCus() {
        String keyword = CariDataTxtBox.getText();

        // Lakukan koneksi ke database
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT b.Customer_ID, a.* FROM RiwayatTransaksi a " +
                    "JOIN TransaksiCustomer b ON b.Transaksi_ID = a.Transaksi_ID " +
                    "WHERE b.Customer_ID = ? OR a.Transaksi_ID LIKE ? OR a.ID_Logam LIKE ? " +
                    "OR a.Kuantitas_KG LIKE ? OR a.Total_Harga LIKE ? OR a.Tanggal LIKE ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try {
                    int id = Integer.parseInt(keyword);
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                    preparedStatement.setString(5, "%" + keyword + "%");
                    preparedStatement.setString(6, "%" + keyword + "%");
                } catch (NumberFormatException e) {
                    preparedStatement.setInt(1, 0);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                    preparedStatement.setString(5, "%" + keyword + "%");
                    preparedStatement.setString(6, "%" + keyword + "%");
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    displaySearchResultsCus(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displaySearchResultsCus(ResultSet resultSet) {
        try {
            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Customer", "ID Transaksi", "ID Logam", "Kuantitas (Kg)", "Total Harga",
                            "Tanggal Transaksi" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String harga = resultSet.getString("Total_Harga");
                String tanggal = resultSet.getString("Tanggal");

                model.addRow(new Object[] { id, trans, logam, kuan, harga, tanggal });
            }

            TransaksiTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            TransaksiTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Customer", "ID Transaksi", "ID Logam", "Kuantitas_KG", "Total Harga",
                            "Tanggal Transaksi" }));
            TransaksiTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void cariDataSup() {
        String keyword = CariDataTxtBox.getText();

        // Lakukan koneksi ke database
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT b.Supplier_ID, a.* FROM RiwayatTransaksi a " +
                    "JOIN TransaksiSupplier b ON b.Transaksi_ID = a.Transaksi_ID " +
                    "WHERE b.Supplier_ID = ? OR a.Transaksi_ID LIKE ? OR a.ID_Logam LIKE ? " +
                    "OR a.Kuantitas_KG LIKE ? OR a.Total_Harga LIKE ? OR a.Tanggal LIKE ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try {
                    int id = Integer.parseInt(keyword);
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                    preparedStatement.setString(5, "%" + keyword + "%");
                    preparedStatement.setString(6, "%" + keyword + "%");
                } catch (NumberFormatException e) {
                    preparedStatement.setInt(1, 0);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                    preparedStatement.setString(5, "%" + keyword + "%");
                    preparedStatement.setString(6, "%" + keyword + "%");
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    displaySearchResultsSup(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displaySearchResultsSup(ResultSet resultSet) {
        try {
            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Supplier", "ID Transaksi", "ID Logam", "Kuantitas (Kg)", "Total Harga",
                            "Tanggal Transaksi" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String harga = resultSet.getString("Total_Harga");
                String tanggal = resultSet.getString("Tanggal");

                model.addRow(new Object[] { id, trans, logam, kuan, harga, tanggal });
            }

            TransaksiTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            TransaksiTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Supplier", "ID Transaksi", "ID Logam", "Kuantitas_KG", "Total Harga",
                            "Tanggal Transaksi" }));
            TransaksiTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void IDTransTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void TglTransTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void IDCustTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void CariDataTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void CariDataButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void IDLogamComboBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void KuantitasTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> AktivitasComboBox;
    private javax.swing.JButton CariDataButton;
    private javax.swing.JLabel CariDataLabel;
    private javax.swing.JTextField CariDataTxtBox;
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton FilterButton;
    private javax.swing.JComboBox<String> FilterDataComboBox;
    private javax.swing.JLabel FilterDataLabel;
    private javax.swing.JLabel IDCustLabel;
    private javax.swing.JTextField IDCustTxtBox;
    private javax.swing.JComboBox<String> IDLogamComboBox;
    private javax.swing.JLabel IDLogamLabel;
    private javax.swing.JLabel IDTransLabel;
    private javax.swing.JTextField IDTransTxtBox;
    private javax.swing.JLabel KuantitasLabel;
    private javax.swing.JTextField KuantitasTxtBox;
    private javax.swing.JComboBox<String> OpsiMitraComboBox;
    private javax.swing.JLabel OpsiMitraLabel;
    private javax.swing.JLabel PilihAktivitasLabel;
    private javax.swing.JLabel TglTransLabel;
    private javax.swing.JTextField TglTransTxtBox;
    private javax.swing.JTable TransaksiTabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
}