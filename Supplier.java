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

public class Supplier extends javax.swing.JFrame {
    private Connection connection;
    private int selectedId;
    private javax.swing.JLabel Tanggal;

    public Supplier() {
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
        IDSupLabel = new javax.swing.JLabel();
        IDSupTxtBox = new javax.swing.JTextField();
        NamaSupTxtBox = new javax.swing.JTextField();
        NamaSupLabel = new javax.swing.JLabel();
        AlamatSupLabel = new javax.swing.JLabel();
        AlamatSupTxtBox = new javax.swing.JTextField();
        NoTelpSupLabel = new javax.swing.JLabel();
        NoTelpSupTxtBox = new javax.swing.JTextField();
        CreateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelSup = new javax.swing.JTable();
        CariDataLabel = new javax.swing.JLabel();
        CariDataTxtBox = new javax.swing.JTextField();
        FilterDataLabel = new javax.swing.JLabel();
        FilterComboBox = new javax.swing.JComboBox<>();
        CariDataButton = new javax.swing.JButton();
        TerapkanButton = new javax.swing.JButton();
        Tanggal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 221));

        PilihAktivitasLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        PilihAktivitasLabel.setForeground(new java.awt.Color(255, 255, 255));
        PilihAktivitasLabel.setText("Pilih Aktivitas:");

        AktivitasComboBox
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Create", "Delete", "Update" }));

        IDSupLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        IDSupLabel.setForeground(new java.awt.Color(255, 255, 255));
        IDSupLabel.setText("ID Supplier");

        IDSupTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDSupTxtBoxActionPerformed(evt);
            }
        });

        NamaSupTxtBox.setToolTipText("");
        NamaSupTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaSupTxtBoxActionPerformed(evt);
            }
        });

        NamaSupLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        NamaSupLabel.setForeground(new java.awt.Color(255, 255, 255));
        NamaSupLabel.setText("Nama Supplier");

        AlamatSupLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        AlamatSupLabel.setForeground(new java.awt.Color(255, 255, 255));
        AlamatSupLabel.setText("Alamat Supplier");

        AlamatSupTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlamatSupTxtBoxActionPerformed(evt);
            }
        });

        NoTelpSupLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        NoTelpSupLabel.setForeground(new java.awt.Color(255, 255, 255));
        NoTelpSupLabel.setText("Nomor Telepon Supplier");

        NoTelpSupTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoTelpSupTxtBoxActionPerformed(evt);
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
                                                        .addComponent(IDSupLabel)
                                                        .addComponent(NamaSupLabel)
                                                        .addComponent(NamaSupTxtBox)
                                                        .addComponent(AlamatSupLabel)
                                                        .addComponent(AlamatSupTxtBox)
                                                        .addComponent(NoTelpSupLabel)
                                                        .addComponent(NoTelpSupTxtBox)
                                                        .addComponent(IDSupTxtBox))
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
                                .addComponent(IDSupLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDSupTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NamaSupLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NamaSupTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AlamatSupLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AlamatSupTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NoTelpSupLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NoTelpSupTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE)));

        TabelSup.setModel(new javax.swing.table.DefaultTableModel(
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
                        "ID Supplier", "Nama Supplier", "Alamat Supplier", "No. Telp Supplier"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        TabelSup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel selectionModel = TabelSup.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = TabelSup.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get the ID of the selected row
                        int selectedId = (int) TabelSup.getValueAt(selectedRow, 0);
                        // Store the selected ID for later use
                        setSelectedId(selectedId);
                    }
                }
            }
        });
        jScrollPane1.setViewportView(TabelSup);

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

        TerapkanButton.setFont(new java.awt.Font("Segoe UI", 1, 12));
        TerapkanButton.setForeground(new java.awt.Color(0, 102, 221));
        TerapkanButton.setText("Terapkan Filter");
        TerapkanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerapkanButtonActionPerformed(evt);
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
                                                .addComponent(TerapkanButton, javax.swing.GroupLayout.PREFERRED_SIZE,
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
                                        .addComponent(TerapkanButton, javax.swing.GroupLayout.DEFAULT_SIZE,
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

        TerapkanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilter = (String) FilterComboBox.getSelectedItem();
                String query = "SELECT * FROM Supplier";

                switch (selectedFilter) {
                    case "Urutan Nomor ID Paling Awal":
                        query += " ORDER BY Supplier_ID ASC";
                        break;

                    case "Urutan Nomor ID Paling Akhir":
                        query += " ORDER BY Supplier_ID DESC";
                        break;

                    case "Urutan Abjad Paling Awal (A-Z)":
                        query += " ORDER BY Nama_Supplier ASC";
                        break;
                    case "Urutan Abjad Paling Akhir (Z-A)":
                        query += " ORDER BY Nama_Supplier DESC";
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
                    IDSupLabel.setVisible(true);
                    IDSupTxtBox.setVisible(true);
                    NamaSupLabel.setVisible(true);
                    NamaSupTxtBox.setVisible(true);
                    AlamatSupLabel.setVisible(true);
                    AlamatSupTxtBox.setVisible(true);
                    NoTelpSupLabel.setVisible(true);
                    NoTelpSupTxtBox.setVisible(true);
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
                    IDSupLabel.setVisible(false);
                    IDSupTxtBox.setVisible(false);
                    NamaSupLabel.setVisible(false);
                    NamaSupTxtBox.setVisible(false);
                    AlamatSupLabel.setVisible(false);
                    AlamatSupTxtBox.setVisible(false);
                    NoTelpSupLabel.setVisible(false);
                    NoTelpSupTxtBox.setVisible(false);
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
                    IDSupLabel.setVisible(false);
                    IDSupTxtBox.setVisible(false);
                    NamaSupLabel.setVisible(false);
                    NamaSupTxtBox.setVisible(false);
                    AlamatSupLabel.setVisible(true);
                    AlamatSupTxtBox.setVisible(true);
                    NoTelpSupLabel.setVisible(true);
                    NoTelpSupTxtBox.setVisible(true);
                    CreateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int selectedRow = TabelSup.getSelectedRow();
                            if (selectedRow != -1) {
                                int id = (int) TabelSup.getValueAt(selectedRow, 0);
                                String newAlamat = AlamatSupTxtBox.getText();
                                String newNoTelp = NoTelpSupTxtBox.getText();
                                updateRecord(id, newAlamat, newNoTelp);
                            }
                        }
                    });

                }
            }

            private void AlamatSupTxtBoxsetVisible(boolean b) {
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
        String ID = IDSupTxtBox.getText();
        String name = NamaSupTxtBox.getText();
        String alamat = AlamatSupTxtBox.getText();
        String salary = NoTelpSupTxtBox.getText();

        try (Statement statement = connection.createStatement()) {
            // Get the current maximum Transaksi_ID

            // Insert the new record
            String insertSql = "INSERT INTO Supplier (Supplier_ID, Nama_Supplier, Alamat_Sup, NoTelp_Sup) VALUES ('"
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
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No. Telp Supplier" }, 0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String name = resultSet.getString("Nama_Supplier");
                String alamat = resultSet.getString("Alamat_Sup");
                String notelp = resultSet.getString("NoTelp_Sup");

                // Add a new row to the model
                model.addRow(new Object[] { id, name, alamat, notelp });
            }

            // Set the model to the table
            TabelSup.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle the exception as needed
        }
    }

    private void readRecords() {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Supplier")) {

            // Create the DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No. Telp Supplier" }, 0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String name = resultSet.getString("Nama_Supplier");
                String alamat = resultSet.getString("Alamat_Sup");
                String notelp = resultSet.getString("NoTelp_Sup");

                // Add a new row to the model
                model.addRow(new Object[] { id, name, alamat, notelp });
            }

            // Set the model to the table
            TabelSup.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            TabelSup.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No. Telp Supplier" }));
            TabelSup.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
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
            String deleteSql = "DELETE FROM Supplier WHERE Supplier_ID = " + id;
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
            String updateSql = "UPDATE Supplier SET Alamat_Sup = '" + newAlamat +
                    "', NoTelp_Sup = '" + newNoTelp + "' WHERE Supplier_ID = " + id;

            statement.executeUpdate(updateSql);
            readRecords(); // Refresh the displayed records

            // Restore the selected text and caret position
        } catch (SQLException e) {
            e.printStackTrace();
            readRecords();
        }
    }

    private void cariData() {

        String keyword = CariDataTxtBox.getText();

        // Lakukan koneksi ke database
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Supplier WHERE Supplier_ID = ? OR Nama_Supplier LIKE ? OR Alamat_Sup LIKE ? OR NoTelp_Sup LIKE ?";

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
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No. Telp Supplier" }, 0);

            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String name = resultSet.getString("Nama_Supplier");
                String alamat = resultSet.getString("Alamat_Sup");
                String notelp = resultSet.getString("NoTelp_Sup");

                model.addRow(new Object[] { id, name, alamat, notelp });
            }

            TabelSup.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            TabelSup.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null } },
                    new String[] { "ID Supplier", "Nama Supplier", "Alamat Supplier", "No. Telp Supplier" }));
            TabelSup.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            });
        }
    }

    private void IDSupTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void NamaSupTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void AlamatSupTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void NoTelpSupTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void CariDataTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void CariDataButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cariData();

    }

    private void TerapkanButtonActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> AktivitasComboBox;
    private javax.swing.JLabel AlamatSupLabel;
    private javax.swing.JTextField AlamatSupTxtBox;
    private javax.swing.JButton CariDataButton;
    private javax.swing.JLabel CariDataLabel;
    private javax.swing.JTextField CariDataTxtBox;
    private javax.swing.JButton CreateButton;
    private javax.swing.JComboBox<String> FilterComboBox;
    private javax.swing.JLabel FilterDataLabel;
    private javax.swing.JLabel IDSupLabel;
    private javax.swing.JTextField IDSupTxtBox;
    private javax.swing.JLabel NamaSupLabel;
    private javax.swing.JTextField NamaSupTxtBox;
    private javax.swing.JLabel NoTelpSupLabel;
    private javax.swing.JTextField NoTelpSupTxtBox;
    private javax.swing.JLabel PilihAktivitasLabel;
    private javax.swing.JTable TabelSup;
    private javax.swing.JButton TerapkanButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
}