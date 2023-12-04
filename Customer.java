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

public class Customer extends javax.swing.JFrame {
    private Connection connection;
    private int selectedId;
    private javax.swing.JLabel Tanggal;

    public Customer() {
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
        IDCustLabel = new javax.swing.JLabel();
        IDCustTxtBox = new javax.swing.JTextField();
        NamaCustTxtBox = new javax.swing.JTextField();
        NamaCustLabel = new javax.swing.JLabel();
        AlamatCustLabel = new javax.swing.JLabel();
        AlamatCustTxtBox = new javax.swing.JTextField();
        NoTelpCustLabel = new javax.swing.JLabel();
        NoTelpCustTxtBox = new javax.swing.JTextField();
        CreateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelCust = new javax.swing.JTable();
        CariDataLabel = new javax.swing.JLabel();
        CariDataTxtBox = new javax.swing.JTextField();
        FilterDataLabel = new javax.swing.JLabel();
        FilterComboBox = new javax.swing.JComboBox<>();
        CariDataButton = new javax.swing.JButton();
        TerapkanButtton = new javax.swing.JButton();
        Tanggal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 221));

        PilihAktivitasLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        PilihAktivitasLabel.setForeground(new java.awt.Color(255, 255, 255));
        PilihAktivitasLabel.setText("Pilih Aktivitas:");

        AktivitasComboBox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Create", "Delete", "Update" }));

        IDCustLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        IDCustLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDCustLabel.setText("ID Customer");

        IDCustTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCustTxtBoxActionPerformed(evt);
            }
        });

        NamaCustTxtBox.setToolTipText("");
        NamaCustTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaCustTxtBoxActionPerformed(evt);
            }
        });

        NamaCustLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        NamaCustLabel.setForeground(new java.awt.Color(255, 255, 255));
        NamaCustLabel.setText("Nama Customer");

        AlamatCustLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        AlamatCustLabel.setForeground(new java.awt.Color(255, 255, 255));
        AlamatCustLabel.setText("Alamat Customer");

        AlamatCustTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlamatCustTxtBoxActionPerformed(evt);
            }
        });

        NoTelpCustLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        NoTelpCustLabel.setForeground(new java.awt.Color(255, 255, 255));
        NoTelpCustLabel.setText("Nomor Telepon Customer");

        NoTelpCustTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoTelpCustTxtBoxActionPerformed(evt);
            }
        });

        CreateButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        CreateButton.setForeground(new java.awt.Color(0, 102, 221));
        CreateButton.setText("Create");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(PilihAktivitasLabel)
                                                        .addComponent(AktivitasComboBox, 0, 191, Short.MAX_VALUE)
                                                        .addComponent(IDCustLabel)
                                                        .addComponent(NamaCustLabel)
                                                        .addComponent(NamaCustTxtBox)
                                                        .addComponent(AlamatCustLabel)
                                                        .addComponent(AlamatCustTxtBox)
                                                        .addComponent(NoTelpCustLabel)
                                                        .addComponent(NoTelpCustTxtBox)
                                                        .addComponent(IDCustTxtBox))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(CreateButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(IDCustLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDCustTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NamaCustLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NamaCustTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AlamatCustLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AlamatCustTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NoTelpCustLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NoTelpCustTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE)));

        TabelCust.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "ID Customer", "Nama Customer", "Alamat Customer", "No. Telp Customer"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

        });
        jScrollPane1.setViewportView(TabelCust);
        TabelCust.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel selectionModel = TabelCust.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = TabelCust.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get the ID of the selected row
                        int selectedId = (int) TabelCust.getValueAt(selectedRow, 0);
                        // Store the selected ID for later use
                        setSelectedId(selectedId);
                    }
                }
            }
        });

        // Add this method to your class to store the selected ID

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

        FilterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Urutan Nomor ID Paling Awal", "Urutan Nomor ID Paling Akhir",
                        "Urutan Abjad Paling Awal (A-Z)",
                        "Urutan Abjad Paling Akhir (Z-A)" }));

        CariDataButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        CariDataButton.setForeground(new java.awt.Color(0, 102, 221));
        CariDataButton.setText("Cari Data");
        CariDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariDataButtonActionPerformed(evt);
            }
        });

        TerapkanButtton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        TerapkanButtton.setForeground(new java.awt.Color(0, 102, 221));
        TerapkanButtton.setText("Terapkan Filter");
        TerapkanButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerapkanButttonActionPerformed(evt);
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
                                                .addComponent(FilterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TerapkanButtton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        129, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(CariDataButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FilterDataLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(FilterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TerapkanButtton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Tanggal))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
        readRecords();
        for (ActionListener al : CreateButton.getActionListeners()) {
            CreateButton.removeActionListener(al);
        }
        CreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
                readRecords();

            }
        });
        TerapkanButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilter = (String) FilterComboBox.getSelectedItem();
                String query = "SELECT * FROM Customer";

                switch (selectedFilter) {
                    case "Urutan Nomor ID Paling Awal":
                        query += " ORDER BY Customer_ID ASC";
                        break;

                    case "Urutan Nomor ID Paling Akhir":
                        query += " ORDER BY Customer_ID DESC";
                        break;

                    case "Urutan Abjad Paling Awal (A-Z)":
                        query += " ORDER BY Nama_Customer ASC";
                        break;
                    case "Urutan Abjad Paling Akhir (Z-A)":
                        query += " ORDER BY Nama_Customer DESC";
                        break;
                    default:
                        // Default query if no filter is selected
                        break;
                }

                executeQueryAndUpdateTable(query);
            }
        });
        AktivitasComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) AktivitasComboBox.getSelectedItem();
                if (selectedOption.equals("Create")) {
                    for (ActionListener al : CreateButton.getActionListeners()) {
                        CreateButton.removeActionListener(al);
                    }
                    IDCustLabel.setVisible(true);
                    IDCustTxtBox.setVisible(true);
                    NamaCustLabel.setVisible(true);
                    NamaCustTxtBox.setVisible(true);
                    AlamatCustLabel.setVisible(true);
                    AlamatCustTxtBox.setVisible(true);
                    NoTelpCustLabel.setVisible(true);
                    NoTelpCustTxtBox.setVisible(true);
                    CreateButton.setText("Create");
                    CreateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            addRecord();
                            readRecords();

                        }
                    });

                } else if (selectedOption.equals("Delete")) {
                    for (ActionListener al : CreateButton.getActionListeners()) {
                        CreateButton.removeActionListener(al);
                    }
                    IDCustLabel.setVisible(false);
                    IDCustTxtBox.setVisible(false);
                    NamaCustLabel.setVisible(false);
                    NamaCustTxtBox.setVisible(false);
                    AlamatCustLabel.setVisible(false);
                    AlamatCustTxtBox.setVisible(false);
                    NoTelpCustLabel.setVisible(false);
                    NoTelpCustTxtBox.setVisible(false);
                    CreateButton.setText("Delete");
                    CreateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            deleteRecord(selectedId);
                        }
                    });
                } else if (selectedOption.equals("Update")) {
                    for (ActionListener al : CreateButton.getActionListeners()) {
                        CreateButton.removeActionListener(al);
                    }
                    CreateButton.setText("Update");
                    IDCustLabel.setVisible(false);
                    IDCustTxtBox.setVisible(false);
                    NamaCustLabel.setVisible(false);
                    NamaCustTxtBox.setVisible(false);
                    AlamatCustLabel.setVisible(true);
                    AlamatCustTxtBox.setVisible(true);
                    NoTelpCustLabel.setVisible(true);
                    NoTelpCustTxtBox.setVisible(true);
                    CreateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int selectedRow = TabelCust.getSelectedRow();
                            if (selectedRow != -1) {
                                int id = (int) TabelCust.getValueAt(selectedRow, 0);
                                String newAlamat = AlamatCustTxtBox.getText();
                                String newNoTelp = NoTelpCustTxtBox.getText();
                                updateRecord(id, newAlamat, newNoTelp);
                            }
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

    private void setSelectedId(int id) {
        this.selectedId = id;
    }

    private void addRecord() {
        String ID = IDCustTxtBox.getText();
        String name = NamaCustTxtBox.getText();
        String alamat = AlamatCustTxtBox.getText();
        String salary = NoTelpCustTxtBox.getText();

        try (Statement statement = connection.createStatement()) {
            // Get the current maximum Transaksi_ID

            // Insert the new record
            String insertSql = "INSERT INTO Customer (Customer_ID, Nama_Customer, Alamat_Cust, NoTelp_Cust) VALUES ('"
                    + ID + "', '"
                    + name + "', '"
                    + alamat + "', '"
                    + salary + "')";

            statement.executeUpdate(insertSql);
            // readRecords();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeQueryAndUpdateTable(String query) {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {

            // Create the DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No. Telp Customer" }, 0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String name = resultSet.getString("Nama_Customer");
                String alamat = resultSet.getString("Alamat_Cust");
                String notelp = resultSet.getString("NoTelp_Cust");

                // Add a new row to the model
                model.addRow(new Object[] { id, name, alamat, notelp });
            }

            // Set the model to the table
            TabelCust.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle the exception as needed
        }
    }

    private void readRecords() {

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer")) {

            // Create the DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No. Telp Customer" }, 0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String name = resultSet.getString("Nama_Customer");
                String alamat = resultSet.getString("Alamat_Cust");
                String notelp = resultSet.getString("NoTelp_Cust");

                // Add a new row to the model
                model.addRow(new Object[] { id, name, alamat, notelp });
            }

            // Set the model to the table
            TabelCust.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            TabelCust.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No. Telp Customer" }));
            TabelCust.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void deleteRecord(int id) {
        try (Statement statement = connection.createStatement()) {
            String deleteSql = "DELETE FROM Customer WHERE Customer_ID = " + id;
            statement.executeUpdate(deleteSql);
            readRecords(); // Refresh the displayed records
        } catch (SQLException e) {
            e.printStackTrace();
            readRecords();
        }
    }

    private void updateRecord(int id, String newAlamat, String newNoTelp) {

        try (Statement statement = connection.createStatement()) {
            // Update the record with the new values
            String updateSql = "UPDATE Customer SET Alamat_Cust = '" + newAlamat +
                    "', NoTelp_Cust = '" + newNoTelp + "' WHERE Customer_ID = " + id;

            statement.executeUpdate(updateSql);
            readRecords();
        } catch (SQLException e) {
            e.printStackTrace();
            readRecords();
        }
    }

    private void cariData() {

        String keyword = CariDataTxtBox.getText();

        // Lakukan koneksi ke database
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Customer WHERE Customer_ID = ? OR Nama_Customer LIKE ? OR Alamat_Cust LIKE ? OR NoTelp_Cust LIKE ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try {
                    int id = Integer.parseInt(keyword);
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                } catch (NumberFormatException e) {
                    preparedStatement.setInt(1, 0);
                    preparedStatement.setString(2, "%" + keyword + "%");
                    preparedStatement.setString(3, "%" + keyword + "%");
                    preparedStatement.setString(4, "%" + keyword + "%");
                }

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    displaySearchResults(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displaySearchResults(ResultSet resultSet) {
        try {
            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No. Telp Customer" }, 0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String name = resultSet.getString("Nama_Customer");
                String alamat = resultSet.getString("Alamat_Cust");
                String notelp = resultSet.getString("NoTelp_Cust");

                model.addRow(new Object[] { id, name, alamat, notelp });
            }

            TabelCust.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            TabelCust.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Customer", "Nama Customer", "Alamat Customer", "No. Telp Customer" }));
            TabelCust.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void IDCustTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void NamaCustTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void AlamatCustTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void NoTelpCustTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void CariDataTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void CariDataButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cariData();

    }

    private void TerapkanButttonActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> AktivitasComboBox;
    private javax.swing.JLabel AlamatCustLabel;
    private javax.swing.JTextField AlamatCustTxtBox;
    private javax.swing.JButton CariDataButton;
    private javax.swing.JLabel CariDataLabel;
    private javax.swing.JTextField CariDataTxtBox;
    private javax.swing.JButton CreateButton;
    private javax.swing.JComboBox<String> FilterComboBox;
    private javax.swing.JLabel FilterDataLabel;
    private javax.swing.JLabel IDCustLabel;
    private javax.swing.JTextField IDCustTxtBox;
    private javax.swing.JLabel NamaCustLabel;
    private javax.swing.JTextField NamaCustTxtBox;
    private javax.swing.JLabel NoTelpCustLabel;
    private javax.swing.JTextField NoTelpCustTxtBox;
    private javax.swing.JLabel PilihAktivitasLabel;
    private javax.swing.JTable TabelCust;
    private javax.swing.JButton TerapkanButtton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
}
// CreateButton.addActionListener(new ActionListener() {
// @Override
// public void actionPerformed(ActionEvent e) {
// int selectedRow = TransaksiTabel.getSelectedRow();
// if (selectedRow != -1) {
// int id = (int) TransaksiTabel.getValueAt(selectedRow, 0);
// String newAlamat = IDLogamLabel.getText();
// String newNoTelp = NoTelpCustTxtBox.getText();
// updateRecord(id, newAlamat, newNoTelp);
// }
// }
// });