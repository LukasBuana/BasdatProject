import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DetailTransaksi extends javax.swing.JFrame {
    private Connection connection;
    private javax.swing.JLabel Tanggal;

    public DetailTransaksi() {
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
        OpsiMitraLabel = new javax.swing.JLabel();
        OpsiMitraComboBox = new javax.swing.JComboBox<>();
        TampilkanButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetailTransTabel = new javax.swing.JTable();
        CariDataLabel = new javax.swing.JLabel();
        CariDataTxtBox = new javax.swing.JTextField();
        FilterLabel = new javax.swing.JLabel();
        FilterDataComboBox = new javax.swing.JComboBox<>();
        CariDataButton = new javax.swing.JButton();
        FilterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 221));

        OpsiMitraLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        OpsiMitraLabel.setForeground(new java.awt.Color(255, 255, 255));
        OpsiMitraLabel.setText("Opsi Mitra:");

        OpsiMitraComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Supplier" }));
        OpsiMitraComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpsiMitraComboBoxActionPerformed(evt);
            }
        });

        TampilkanButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        TampilkanButton.setForeground(new java.awt.Color(0, 102, 221));
        TampilkanButton.setText("Tampilkan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(OpsiMitraLabel)
                                                        .addComponent(OpsiMitraComboBox,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 191,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(TampilkanButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(OpsiMitraLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OpsiMitraComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(242, 242, 242)
                                .addComponent(TampilkanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE)));

        DetailTransTabel.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null }
                },
                new String[] {
                        "ID Customer", "Nama Customer", "Alamat Customer", "No. Telp Customer", "Transaksi ID",
                        "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)", "Total Harga"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                    java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(DetailTransTabel);

        CariDataLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        CariDataLabel.setForeground(new java.awt.Color(0, 102, 221));
        CariDataLabel.setText("Cari Data");

        CariDataTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariDataTxtBoxActionPerformed(evt);
            }
        });

        FilterLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        FilterLabel.setForeground(new java.awt.Color(0, 102, 221));
        FilterLabel.setText("Filter Data Berdasarkan");

        FilterDataComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Urutan Nomor Transaksi ID Paling Awal", "Urutan Nomor Transaksi ID Paling Akhir",
                        "Transaksi Terbesar",
                        "Transaksi Terkecil", "Urutan Abjad Paling Awal (A-Z)",
                        "Urutan Abjad Paling Akhir (Z-A)" }));

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
                                                        .addComponent(FilterLabel)
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(CariDataLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CariDataTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CariDataButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FilterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FilterDataComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FilterButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Tanggal))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();

        for (ActionListener al : TampilkanButton.getActionListeners()) {
            TampilkanButton.removeActionListener(al);
        }
        TampilkanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readRecordsCus();
            }
        });

        CariDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (OpsiMitraComboBox.getSelectedItem().equals("Customer")) {
                    cariDataCus();
                } else if (OpsiMitraComboBox.getSelectedItem().equals("Supplier")) {
                    cariDataSup();
                }
            }
        });
        FilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilter = (String) FilterDataComboBox.getSelectedItem();
                String query = "";

                if (OpsiMitraComboBox.getSelectedItem().equals("Customer")) {
                    query = "SELECT b.*,c.ID_Logam,d.Jenis_Logam,a.Nama_Customer,a.Alamat_Cust,a.NoTelp_Cust,d.Harga_KG,c.Kuantitas_KG,c.Total_Harga FROM Customer a "
                            + "JOIN TransaksiCustomer b ON b.Customer_ID = a.Customer_ID "
                            + "JOIN RiwayatTransaksi c ON c.Transaksi_ID = b.Transaksi_ID "
                            + "JOIN JenisBesi d ON d.ID_Logam = c.ID_Logam";

                    switch (selectedFilter) {
                        case "Urutan Nomor Transaksi ID Paling Awal":
                            query += " ORDER BY b.Transaksi_ID ASC";
                            break;
                        case "Urutan Nomor Transaksi ID Paling Akhir":
                            query += " ORDER BY b.Transaksi_ID DESC";
                            break;
                        case "Urutan Abjad Paling Awal (A-Z)":
                            query += " ORDER BY a.Nama_Customer ASC";
                            break;
                        case "Urutan Abjad Paling Akhir (Z-A)":
                            query += " ORDER BY a.Nama_Customer DESC";
                            break;
                        case "Transaksi Terbesar":
                            query += " ORDER BY c.Total_Harga DESC";
                            break;
                        case "Transaksi Terkecil":
                            query += " ORDER BY c.Total_Harga ASC";
                            break;
                        default:
                            // Default query if no filter is selected
                            break;
                    }
                    executeQueryAndUpdateTableCus(query);
                } else if (OpsiMitraComboBox.getSelectedItem().equals("Supplier")) {
                    query = "SELECT b.*,c.ID_Logam,d.Jenis_Logam,a.Nama_Supplier,a.Alamat_Sup,a.NoTelp_Sup,d.Harga_KG,c.Kuantitas_KG,c.Total_Harga FROM Supplier a "
                            + "JOIN TransaksiSupplier b ON b.Supplier_ID = a.Supplier_ID "
                            + "JOIN RiwayatTransaksi c ON c.Transaksi_ID = b.Transaksi_ID "
                            + "JOIN JenisBesi d ON d.ID_Logam = c.ID_Logam";

                    switch (selectedFilter) {
                        case "Urutan Nomor Transaksi ID Paling Awal":
                            query += " ORDER BY b.Transaksi_ID ASC";
                            break;
                        case "Urutan Nomor Transaksi ID Paling Akhir":
                            query += " ORDER BY b.Transaksi_ID DESC";
                            break;
                        case "Urutan Abjad Paling Awal (A-Z)":
                            query += " ORDER BY a.Nama_Supplier ASC";
                            break;
                        case "Urutan Abjad Paling Akhir (Z-A)":
                            query += " ORDER BY a.Nama_Supplier DESC";
                            break;
                        case "Transaksi Terbesar":
                            query += " ORDER BY c.Total_Harga DESC";
                            break;
                        case "Transaksi Terkecil":
                            query += " ORDER BY c.Total_Harga ASC";
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
                if (selectedMitra.equals("Customer")) {
                    for (ActionListener al : TampilkanButton.getActionListeners()) {
                        TampilkanButton.removeActionListener(al);
                    }
                    TampilkanButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            readRecordsCus();
                        }
                    });
                } else if (selectedMitra.equals("Supplier")) {
                    for (ActionListener al : TampilkanButton.getActionListeners()) {
                        TampilkanButton.removeActionListener(al);
                    }
                    TampilkanButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            readRecordsSup();
                        }
                    });
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

    private void readRecordsCus() {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT b.*,c.ID_Logam,d.Jenis_Logam,a.Nama_Customer,a.Alamat_Cust,a.NoTelp_Cust,d.Harga_KG,c.Kuantitas_KG,c.Total_Harga FROM Customer a \r\n"
                                + //
                                "JOIN TransaksiCustomer b ON b.Customer_ID = a.Customer_ID\r\n" + //
                                "JOIN RiwayatTransaksi c ON c.Transaksi_ID = b.Transaksi_ID\r\n" + //
                                "JOIN JenisBesi d ON d.ID_Logam = c.ID_Logam")) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No.Telp Customer",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)", "Total Harga" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String nama = resultSet.getString("Nama_Customer");
                String alamat = resultSet.getString("Alamat_Cust");
                String no = resultSet.getString("NoTelp_Cust");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String jenis = resultSet.getString("Jenis_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String hargakg = resultSet.getString("Harga_KG");
                String harga = resultSet.getString("Total_Harga");

                model.addRow(new Object[] { id, nama, alamat, no, trans, logam, jenis, kuan, hargakg, harga });
            }

            DetailTransTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DetailTransTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No.Telp Customer",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)",
                            "Total Harga" }));
            DetailTransTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
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
                ResultSet resultSet = statement.executeQuery(
                        "SELECT b.*,c.ID_Logam,d.Jenis_Logam,a.Nama_Supplier,a.Alamat_Sup,a.NoTelp_Sup,d.Harga_KG,c.Kuantitas_KG,c.Total_Harga FROM Supplier a \r\n"
                                + //
                                "JOIN TransaksiSupplier b ON b.Supplier_ID = a.Supplier_ID\r\n" + //
                                "JOIN RiwayatTransaksi c ON c.Transaksi_ID = b.Transaksi_ID\r\n" + //
                                "JOIN JenisBesi d ON d.ID_Logam = c.ID_Logam")) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No.Telp Supplier",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)", "Total Harga" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String nama = resultSet.getString("Nama_Supplier");
                String alamat = resultSet.getString("Alamat_Sup");
                String no = resultSet.getString("NoTelp_Sup");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String jenis = resultSet.getString("Jenis_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String hargakg = resultSet.getString("Harga_KG");
                String harga = resultSet.getString("Total_Harga");

                model.addRow(new Object[] { id, nama, alamat, no, trans, logam, jenis, kuan, hargakg, harga });
            }

            DetailTransTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DetailTransTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No.Telp Supplier",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)",
                            "Total Harga" }));
            DetailTransTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void executeQueryAndUpdateTableCus(String query) {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No.Telp Customer",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)", "Total Harga" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String nama = resultSet.getString("Nama_Customer");
                String alamat = resultSet.getString("Alamat_Cust");
                String no = resultSet.getString("NoTelp_Cust");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String jenis = resultSet.getString("Jenis_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String hargakg = resultSet.getString("Harga_KG");
                String harga = resultSet.getString("Total_Harga");

                model.addRow(new Object[] { id, nama, alamat, no, trans, logam, jenis, kuan, hargakg, harga });
            }
            DetailTransTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DetailTransTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No.Telp Customer",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)",
                            "Total Harga" }));
            DetailTransTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
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
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No.Telp Supplier",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)", "Total Harga" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String nama = resultSet.getString("Nama_Supplier");
                String alamat = resultSet.getString("Alamat_Sup");
                String no = resultSet.getString("NoTelp_Sup");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String jenis = resultSet.getString("Jenis_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String hargakg = resultSet.getString("Harga_KG");
                String harga = resultSet.getString("Total_Harga");

                model.addRow(new Object[] { id, nama, alamat, no, trans, logam, jenis, kuan, hargakg, harga });
            }

            DetailTransTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DetailTransTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No.Telp Supplier",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)",
                            "Total Harga" }));
            DetailTransTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void cariDataCus() {
        String keyword = CariDataTxtBox.getText();

        // Lakukan koneksi ke database
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT b.*,c.ID_Logam,d.Jenis_Logam,a.Nama_Customer,a.Alamat_Cust,a.NoTelp_Cust,d.Harga_KG,c.Kuantitas_KG,c.Total_Harga "
                    +
                    "FROM Customer a " +
                    "JOIN TransaksiCustomer b ON b.Customer_ID = a.Customer_ID " +
                    "JOIN RiwayatTransaksi c ON c.Transaksi_ID = b.Transaksi_ID " +
                    "JOIN JenisBesi d ON d.ID_Logam = c.ID_Logam " +
                    "WHERE a.Customer_ID = ? OR a.Nama_Customer LIKE ? OR a.Alamat_Cust LIKE ? OR a.NoTelp_Cust LIKE ? "
                    +
                    "OR c.Transaksi_ID LIKE ? OR c.ID_Logam LIKE ? OR d.Jenis_Logam LIKE ? OR c.Kuantitas_KG LIKE ? " +
                    "OR d.Harga_KG LIKE ? OR c.Total_Harga LIKE ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try {
                    int id = Integer.parseInt(keyword);
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                    preparedStatement.setString(5, "%" + keyword + "%");
                    preparedStatement.setString(6, "%" + keyword + "%");
                    preparedStatement.setString(7, "%" + keyword + "%");
                    preparedStatement.setString(8, "%" + keyword + "%");
                    preparedStatement.setString(9, "%" + keyword + "%");
                    preparedStatement.setString(10, "%" + keyword + "%");
                } catch (NumberFormatException e) {
                    preparedStatement.setInt(1, 0);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                    preparedStatement.setString(5, "%" + keyword + "%");
                    preparedStatement.setString(6, "%" + keyword + "%");
                    preparedStatement.setString(7, "%" + keyword + "%");
                    preparedStatement.setString(8, "%" + keyword + "%");
                    preparedStatement.setString(9, "%" + keyword + "%");
                    preparedStatement.setString(10, "%" + keyword + "%");
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
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No.Telp Customer",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)", "Total Harga" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String nama = resultSet.getString("Nama_Customer");
                String alamat = resultSet.getString("Alamat_Cust");
                String no = resultSet.getString("NoTelp_Cust");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String jenis = resultSet.getString("Jenis_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String hargakg = resultSet.getString("Harga_KG");
                String harga = resultSet.getString("Total_Harga");

                model.addRow(new Object[] { id, nama, alamat, no, trans, logam, jenis, kuan, hargakg, harga });
            }

            DetailTransTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DetailTransTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No.Telp Customer",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)",
                            "Total Harga" }));
            DetailTransTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
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
            String query = "SELECT b.*,c.ID_Logam,d.Jenis_Logam,a.Nama_Supplier,a.Alamat_Sup,a.NoTelp_Sup,d.Harga_KG,c.Kuantitas_KG,c.Total_Harga "
                    +
                    "FROM Supplier a " +
                    "JOIN TransaksiSupplier b ON b.Supplier_ID = a.Supplier_ID " +
                    "JOIN RiwayatTransaksi c ON c.Transaksi_ID = b.Transaksi_ID " +
                    "JOIN JenisBesi d ON d.ID_Logam = c.ID_Logam " +
                    "WHERE a.Supplier_ID = ? OR a.Nama_Supplier LIKE ? OR a.Alamat_Sup LIKE ? OR a.NoTelp_Sup LIKE ? "
                    +
                    "OR c.Transaksi_ID LIKE ? OR c.ID_Logam LIKE ? OR d.Jenis_Logam LIKE ? OR c.Kuantitas_KG LIKE ? " +
                    "OR d.Harga_KG LIKE ? OR c.Total_Harga LIKE ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try {
                    int id = Integer.parseInt(keyword);
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                    preparedStatement.setString(5, "%" + keyword + "%");
                    preparedStatement.setString(6, "%" + keyword + "%");
                    preparedStatement.setString(7, "%" + keyword + "%");
                    preparedStatement.setString(8, "%" + keyword + "%");
                    preparedStatement.setString(9, "%" + keyword + "%");
                    preparedStatement.setString(10, "%" + keyword + "%");
                } catch (NumberFormatException e) {
                    preparedStatement.setInt(1, 0);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                    preparedStatement.setString(5, "%" + keyword + "%");
                    preparedStatement.setString(6, "%" + keyword + "%");
                    preparedStatement.setString(7, "%" + keyword + "%");
                    preparedStatement.setString(8, "%" + keyword + "%");
                    preparedStatement.setString(9, "%" + keyword + "%");
                    preparedStatement.setString(10, "%" + keyword + "%");
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
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No.Telp Supplier",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)", "Total Harga" },
                    0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String nama = resultSet.getString("Nama_Supplier");
                String alamat = resultSet.getString("Alamat_Sup");
                String no = resultSet.getString("NoTelp_Sup");
                String trans = resultSet.getString("Transaksi_ID");
                String logam = resultSet.getString("ID_Logam");
                String jenis = resultSet.getString("Jenis_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");
                String hargakg = resultSet.getString("Harga_KG");
                String harga = resultSet.getString("Total_Harga");

                model.addRow(new Object[] { id, nama, alamat, no, trans, logam, jenis, kuan, hargakg, harga });
            }

            DetailTransTabel.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            DetailTransTabel.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No.Telp Supplier",
                            "ID Transaksi", "ID Logam", "Jenis Logam", "Kuantitas (Kg)", "Harga (Kg)",
                            "Total Harga" }));
            DetailTransTabel.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void CariDataTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void CariDataButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void FilterButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void OpsiMitraComboBoxActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(DetailTransaksi.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailTransaksi.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailTransaksi.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailTransaksi.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailTransaksi().setVisible(true);
            }
        });
    }

    private javax.swing.JButton CariDataButton;
    private javax.swing.JLabel CariDataLabel;
    private javax.swing.JTextField CariDataTxtBox;
    private javax.swing.JTable DetailTransTabel;
    private javax.swing.JButton FilterButton;
    private javax.swing.JComboBox<String> FilterDataComboBox;
    private javax.swing.JLabel FilterLabel;
    private javax.swing.JComboBox<String> OpsiMitraComboBox;
    private javax.swing.JLabel OpsiMitraLabel;
    private javax.swing.JButton TampilkanButton;

    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
}