import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.text.BadLocationException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Transaksi extends JFrame {

    private JTextField textFieldID;
    private JTextField textFieldTGL;
    private JTextField textFieldCust;
    String[] jcomp2Items = { "Create", "Delete", "Update" };
    String[] jcomp1Items = { "Customer", "Supplier" };
    private JTextField textFieldLogam;
    private JTextField textFieldKuan;

    private JTextArea resultTextArea;

    private Connection connection;

    public Transaksi() {
        super("Transaksi");

        textFieldID = new JTextField(20);
        textFieldTGL = new JTextField(20);
        textFieldCust = new JTextField(20);
        textFieldLogam = new JTextField(20);
        textFieldKuan = new JTextField(20);

        JLabel labelaktifitas = new JLabel("Aktifitas:");
        JLabel labelopsi = new JLabel("Opsi Mitra:");
        JLabel labelID = new JLabel("ID Transaksi:");
        JLabel labeltgl = new JLabel("Tanggal Transaksi:");
        JLabel labelcust = new JLabel("ID Customer:");
        JLabel labellogam = new JLabel("ID Logam:");
        JLabel labelkuan = new JLabel("Kuantitas Logam:");

        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);
        JComboBox<String> jcomp1 = new JComboBox<>(jcomp1Items);
        JComboBox<String> jcomp2 = new JComboBox<>(jcomp2Items);

        // Set the preferred size of JComboBox to match the widest text field

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Create layout
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST; // Align components at the top left corner
        gbc.insets = new Insets(5, 5, 5, 5); // Adjust the insets as needed

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(labelaktifitas, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(jcomp2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(labelopsi, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(jcomp1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(labelID, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(textFieldID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(labeltgl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        inputPanel.add(textFieldTGL, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(labelcust, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        inputPanel.add(textFieldCust, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(labellogam, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        inputPanel.add(textFieldLogam, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(labelkuan, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        inputPanel.add(textFieldKuan, gbc);

        // Create layout
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);

        // Add components to the frame
        add(inputPanel, BorderLayout.WEST); // Align the input panel to the left
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        resultTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleDeleteClick(e);
            }
        });

        jcomp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) jcomp1.getSelectedItem();

                if (selectedOption == "Supplier") {
                    labelcust.setText("ID Supplier");
                    readRecordsSup();
                } else {
                    labelcust.setText("ID Customer");
                    readRecordsCus();
                }

            }
        });

        jcomp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) jcomp2.getSelectedItem();

                if (selectedOption == "Update") {
                    labelID.setVisible(false);
                    textFieldID.setVisible(false);
                    labeltgl.setVisible(false);
                    textFieldTGL.setVisible(false);
                    labelcust.setVisible(true);
                    textFieldTGL.setVisible(true);
                    labellogam.setVisible(true);
                    textFieldCust.setVisible(true);
                    textFieldLogam.setVisible(false);
                    addButton.setVisible(false);
                    updateButton.setVisible(true);
                    deleteButton.setVisible(false);
                    labelkuan.setVisible(false);
                    textFieldKuan.setVisible(false);
                } else if (selectedOption == "Delete") {
                    labelID.setVisible(false);
                    textFieldID.setVisible(false);
                    labeltgl.setVisible(false);
                    textFieldTGL.setVisible(false);
                    labelcust.setVisible(false);
                    textFieldTGL.setVisible(false);
                    labellogam.setVisible(false);
                    textFieldCust.setVisible(false);
                    textFieldLogam.setVisible(false);
                    addButton.setVisible(false);
                    updateButton.setVisible(false);
                    deleteButton.setVisible(true);
                    labelkuan.setVisible(false);
                    textFieldKuan.setVisible(false);
                }

                else if (selectedOption == "Create") {
                    labelID.setVisible(true);
                    textFieldID.setVisible(true);
                    labeltgl.setVisible(true);
                    textFieldTGL.setVisible(true);
                    labelcust.setVisible(true);
                    textFieldTGL.setVisible(true);
                    labellogam.setVisible(true);
                    textFieldCust.setVisible(true);
                    textFieldLogam.setVisible(true);
                    addButton.setVisible(true);
                    updateButton.setVisible(false);
                    deleteButton.setVisible(false);
                    labelkuan.setVisible(true);
                    textFieldKuan.setVisible(true);
                }

            }
        });

        // Set up action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) jcomp1.getSelectedItem();
                if (selectedOption == "Customer") {
                    addRecordCus();
                    readRecordsCus();
                } else if (selectedOption == "Supplier") {
                    addRecordSup();
                    readRecordsSup();

                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = resultTextArea.getSelectedText();
                if (selectedText != null && !selectedText.isEmpty()) {
                    // Use regular expression to extract the ID
                    String regex = "\\b\\d+\\b";
                    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                    java.util.regex.Matcher matcher = pattern.matcher(selectedText);

                    // Find and use the second match as the ID
                    if (matcher.find()) {
                        String idString1 = matcher.group();
                        int id1 = Integer.parseInt(idString1.trim());
                        if (matcher.find()) {
                            String idString2 = matcher.group();
                            int id2 = Integer.parseInt(idString2.trim());
                            String selectedOption = (String) jcomp1.getSelectedItem();
                            if (selectedOption.equals("Customer")) {
                                deleteRecordCus(id1, id2);
                                readRecordsCus();
                            } else if (selectedOption.equals("Supplier")) {
                                deleteRecordSup(id1, id2);
                                readRecordsSup();
                            }
                        } else {
                            resultTextArea.setText("Only one ID found in the selected text.");
                        }
                    } else {
                        resultTextArea.setText("No valid ID found in the selected text.");
                    }
                } else {
                    resultTextArea.setText("Please select an ID to delete.");
                }
            }
        });

        // Set up database connection
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
            readRecordsCus();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1000, 600); // Set the size according to your preferences (width, height)
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Instead of disposing, just hide the second GUI
                setVisible(false);
                System.out.println("Second GUI closed");
            }
        });

    }

    private void addRecordCus() {
        String ID = textFieldID.getText();
        String tanggal = textFieldTGL.getText();
        String customer = textFieldCust.getText();
        String logam = textFieldLogam.getText();
        int kuan = Integer.parseInt(textFieldKuan.getText());
        int totalHarga = 70000 * kuan;
        try (Statement statement = connection.createStatement()) {
            // Get the current maximum Transaksi_ID

            // Insert the new record
            String insertSql = "INSERT INTO RiwayatTransaksi(Transaksi_ID,Tanggal,Total_Harga,ID_Logam,Kuantitas_KG) VALUES ('"
                    + ID + "', '"
                    + tanggal + "', '"
                    + totalHarga + "', '"
                    + logam + "','" + kuan + "')";

            statement.executeUpdate(insertSql);

            String insertsqlcus = "INSERT INTO TransaksiCustomer(Transaksi_ID,Customer_ID) VALUES ('"
                    + ID + "', '"
                    + customer + "')";

            statement.executeUpdate(insertsqlcus);

            readRecordsCus();
        } catch (SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error adding record: " + e.getMessage());
        }
    }

    private void addRecordSup() {
        String ID = textFieldID.getText();
        String tanggal = textFieldTGL.getText();
        String supplier = textFieldCust.getText();
        String logam = textFieldLogam.getText();
        int kuan = Integer.parseInt(textFieldKuan.getText());
        int totalHarga = 70000 * kuan;
        try (Statement statement = connection.createStatement()) {
            // Get the current maximum Transaksi_ID

            // Insert the new record
            String insertSql = "INSERT INTO RiwayatTransaksi(Transaksi_ID,Tanggal,Total_Harga,ID_Logam,Kuantitas_KG) VALUES ('"
                    + ID + "', '"
                    + tanggal + "', '"
                    + totalHarga + "', '"
                    + logam + "','" + kuan + "')";

            statement.executeUpdate(insertSql);

            String insertsqlcus = "INSERT INTO TransaksiSupplier(Transaksi_ID,Supplier_ID) VALUES ('"
                    + ID + "', '"
                    + supplier + "')";

            statement.executeUpdate(insertsqlcus);

            readRecordsCus();
        } catch (SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error adding record: " + e.getMessage());
        }
    }

    // Modify the handleDeleteClick method
    private void handleDeleteClick(MouseEvent e) {
        // Mendapatkan posisi caret dari mouse event
        int caretPosition = resultTextArea.viewToModel(e.getPoint());

        // Menghitung nomor baris yang diklik
        int lineNumber = 1;
        try {
            lineNumber = resultTextArea.getLineOfOffset(caretPosition) + 1;
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }

        // Mendapatkan jumlah karakter pada baris yang diklik
        int lineStartOffset = 0;
        int lineEndOffset = 0;
        try {
            lineStartOffset = resultTextArea.getLineStartOffset(lineNumber - 1);
            lineEndOffset = resultTextArea.getLineEndOffset(lineNumber - 1);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }

        // Mengaktifkan pemilihan pada baris yang diklik
        resultTextArea.setSelectionStart(lineStartOffset);
        resultTextArea.setSelectionEnd(lineEndOffset);

    }

    private void readRecordsCus() {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT b.Customer_ID,a.* FROM RiwayatTransaksi a\r\n" + //
                                "JOIN TransaksiCustomer b ON b.Transaksi_ID = a.Transaksi_ID\r\n" + //
                                "")) {

            // Find the maximum length for each column
            int maxIdLength = 25;
            int maxNameLength = 25;
            int maxAlamatLength = 25;
            int maxNotelpLength = 25;
            int maxtotalpLength = 25;
            int maxlogamength = 15;

            StringBuilder resultText = new StringBuilder();
            resultText.append(String.format(
                    "%-" + maxIdLength + "s%-" + maxNameLength + "s%-" + maxAlamatLength + "s%-" + maxNotelpLength
                            + "s%-" + maxtotalpLength + "s%-" + maxlogamength
                            + "s\n",
                    "Customer_ID", "Transaksi_ID", "Tanggal", "Total_Harga", "ID_Logam", "Kuantitas_KG"));
            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String name = resultSet.getString("Transaksi_ID");
                String alamat = resultSet.getString("Tanggal");
                String notelp = resultSet.getString("Total_Harga");
                String logam = resultSet.getString("ID_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");

                resultText.append(String.format(
                        "%-" + maxIdLength + "d%-" + maxNameLength + "s%-" + maxAlamatLength + "s%-" + maxNotelpLength
                                + "s%-" + maxtotalpLength + "s%-" + maxlogamength
                                + "s\n",
                        id, name, alamat, notelp, logam, kuan));

            }

            // Set monospaced font for JTextArea
            resultTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            resultTextArea.setText(resultText.toString());
        } catch (

        SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error reading records: " + e.getMessage());
        }
    }

    private void readRecordsSup() {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT b.Supplier_ID,a.* \r\n" + //
                        "FROM RiwayatTransaksi a\r\n" + //
                        "JOIN TransaksiSupplier b ON b.Transaksi_ID = a.Transaksi_ID")) {

            // Find the maximum length for each column
            int maxIdLength = 25;
            int maxNameLength = 25;
            int maxAlamatLength = 25;
            int maxNotelpLength = 25;
            int maxtotalpLength = 25;
            int maxlogamength = 15;

            StringBuilder resultText = new StringBuilder();
            resultText.append(String.format(
                    "%-" + maxIdLength + "s%-" + maxNameLength + "s%-" + maxAlamatLength + "s%-" + maxNotelpLength
                            + "s%-" + maxtotalpLength + "s%-" + maxlogamength
                            + "s\n",
                    "Supplier_ID", "Transaksi_ID", "Tanggal", "Total_Harga", "ID_Logam", "Kuantitas_KG"));
            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String name = resultSet.getString("Transaksi_ID");
                String alamat = resultSet.getString("Tanggal");
                String notelp = resultSet.getString("Total_Harga");
                String logam = resultSet.getString("ID_Logam");
                String kuan = resultSet.getString("Kuantitas_KG");

                resultText.append(String.format(
                        "%-" + maxIdLength + "d%-" + maxNameLength + "s%-" + maxAlamatLength + "s%-" + maxNotelpLength
                                + "s%-" + maxtotalpLength + "s%-" + maxlogamength
                                + "s\n",
                        id, name, alamat, notelp, logam, kuan));

            }

            // Set monospaced font for JTextArea
            resultTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            resultTextArea.setText(resultText.toString());
        } catch (

        SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error reading records: " + e.getMessage());
        }
    }

    private void updateRecord(int id, String newAlamat, String newNoTelp) {
        // Store the selected text and caret position
        int selectionStart = resultTextArea.getSelectionStart();
        int selectionEnd = resultTextArea.getSelectionEnd();
        String selectedText = resultTextArea.getSelectedText();

        try (Statement statement = connection.createStatement()) {
            // Update the record with the new values
            String updateSql = "UPDATE Transaksi SET Alamat_Cust = '" + newAlamat +
                    "', NoTelp_Cust = '" + newNoTelp + "' WHERE Customer_ID = " + id;

            statement.executeUpdate(updateSql);
            readRecordsCus(); // Refresh the displayed records

            // Restore the selected text and caret position
            resultTextArea.setText(resultTextArea.getText()); // This is to refresh the text area
            resultTextArea.getCaret().setDot(selectionStart);
            resultTextArea.getCaret().moveDot(selectionEnd);
        } catch (SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error updating record: " + e.getMessage());
            readRecordsCus();
        }
    }

    private void deleteRecordCus(int id1, int id2) {
        try (Statement statement = connection.createStatement()) {
            // Delete from the child table first
            String deleteChildSql = "DELETE FROM TransaksiCustomer WHERE Customer_ID = " + id1;
            statement.executeUpdate(deleteChildSql);

            // Then, delete from the parent table
            String deleteParentSql = "DELETE FROM RiwayatTransaksi WHERE Transaksi_ID = " + id2;
            statement.executeUpdate(deleteParentSql);

            readRecordsCus(); // Refresh the displayed records
        } catch (SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error deleting record: " + e.getMessage());
            readRecordsCus();
        }
    }

    private void deleteRecordSup(int id1, int id2) {
        try (Statement statement = connection.createStatement()) {
            // Delete from the child table first
            String deleteChildSql = "DELETE FROM TransaksiSupplier WHERE Supplier_ID = " + id1;
            statement.executeUpdate(deleteChildSql);

            // Then, delete from the parent table
            String deleteParentSql = "DELETE FROM RiwayatTransaksi WHERE Transaksi_ID = " + id2;
            statement.executeUpdate(deleteParentSql);

            readRecordsCus(); // Refresh the displayed records
        } catch (SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error deleting record: " + e.getMessage());
            readRecordsCus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Transaksi());
    }
}
