
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

public class Supplier extends JFrame {

    private JTextField textFieldID;
    private JTextField textFieldName;
    private JTextField textFieldAlamat;
    private JTextField textFieldNoTelp;
    private JTextArea resultTextArea;
    String[] jcomp2Items = { "Create", "Delete", "Update" };
    private JTextField textFieldKuantitas;

    private Connection connection;

    public Supplier() {
        super("Supplier");

        textFieldID = new JTextField(20);
        textFieldName = new JTextField(20);
        textFieldAlamat = new JTextField(20);
        textFieldNoTelp = new JTextField(20);
        textFieldKuantitas = new JTextField(20);

        JLabel labelaktifitas = new JLabel("Aktifitas:");
        JLabel labelID = new JLabel("ID Supplier:");
        JLabel labelnama = new JLabel("Nama Supplier:");
        JLabel labelalamat = new JLabel("Alamat Supplier:");
        JLabel labelnotelp = new JLabel("NoTelp Supplier:");

        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);

        JComboBox<String> jcomp2 = new JComboBox<>(jcomp2Items);

        // Set the preferred size of JComboBox to match the widest text field

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Set background colors for panels
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(139, 194, 255)); // Coklat muda
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(0, 100, 213)); // Coklat tua

        // Set foreground (text) colors for labels
        labelaktifitas.setForeground(Color.BLACK);
        labelID.setForeground(Color.BLACK);
        labelnama.setForeground(Color.BLACK);
        labelalamat.setForeground(Color.BLACK);
        labelnotelp.setForeground(Color.BLACK);

        // Set background color for buttons
        addButton.setBackground(new Color(9, 255, 99)); // Green
        updateButton.setBackground(new Color(255, 200, 100)); // Yellow
        deleteButton.setBackground(new Color(255, 0, 0)); // Red

        // Set foreground (text) colors for buttons
        addButton.setForeground(Color.BLACK);
        updateButton.setForeground(Color.BLACK);
        deleteButton.setForeground(Color.BLACK);

        // Create layout
        setLayout(new BorderLayout());

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
        inputPanel.add(labelID, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(textFieldID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(labelnama, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(textFieldName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(labelalamat, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        inputPanel.add(textFieldAlamat, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(labelnotelp, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        inputPanel.add(textFieldNoTelp, gbc);

        // Create layout
        setLayout(new BorderLayout());

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

        jcomp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) jcomp2.getSelectedItem();

                if (selectedOption == "Update") {
                    labelID.setVisible(false);
                    textFieldID.setVisible(false);
                    labelnama.setVisible(false);
                    textFieldName.setVisible(false);
                    labelalamat.setVisible(true);
                    textFieldAlamat.setVisible(true);
                    labelnotelp.setVisible(true);
                    textFieldNoTelp.setVisible(true);
                    textFieldKuantitas.setVisible(false);
                    addButton.setVisible(false);
                    updateButton.setVisible(true);
                    deleteButton.setVisible(false);
                } else if (selectedOption == "Delete") {
                    labelID.setVisible(false);
                    textFieldID.setVisible(false);
                    labelnama.setVisible(false);
                    textFieldName.setVisible(false);
                    labelalamat.setVisible(false);
                    textFieldAlamat.setVisible(false);
                    labelnotelp.setVisible(false);
                    textFieldNoTelp.setVisible(false);
                    textFieldKuantitas.setVisible(false);
                    addButton.setVisible(false);
                    updateButton.setVisible(false);
                    deleteButton.setVisible(true);
                }

                else if (selectedOption == "Create") {
                    labelID.setVisible(true);
                    textFieldID.setVisible(true);
                    labelnama.setVisible(true);
                    textFieldName.setVisible(true);
                    labelalamat.setVisible(true);
                    textFieldAlamat.setVisible(true);
                    labelnotelp.setVisible(true);
                    textFieldNoTelp.setVisible(true);
                    textFieldKuantitas.setVisible(true);
                    addButton.setVisible(true);
                    updateButton.setVisible(false);
                    deleteButton.setVisible(false);
                }

            }
        });

        // Set up action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = resultTextArea.getSelectedText();
                if (selectedText != null && !selectedText.isEmpty()) {
                    // Use regular expression to extract the ID
                    String regex = "\\b\\d+\\b";
                    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
                    java.util.regex.Matcher matcher = pattern.matcher(selectedText);

                    // Find and use the first match as the ID
                    if (matcher.find()) {
                        String idString = matcher.group();
                        int id = Integer.parseInt(idString.trim());
                        // Get new values for Alamat and NoTelp from the text fields or other sources
                        String newAlamat = textFieldAlamat.getText();
                        String newNoTelp = textFieldNoTelp.getText();
                        updateRecord(id, newAlamat, newNoTelp);
                    } else {
                        resultTextArea.setText("No valid ID found in the selected text.");
                    }
                } else {
                    resultTextArea.setText("Please select an ID to update.");
                    readRecords();
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

                    // Find and use the first match as the ID
                    if (matcher.find()) {
                        String idString = matcher.group();
                        int id = Integer.parseInt(idString.trim());
                        deleteRecord(id);
                    } else {
                        resultTextArea.setText("No valid ID found in the selected text.");
                    }
                } else {
                    resultTextArea.setText("Please select an ID to delete.");
                    readRecords();
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
            readRecords();
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

    private void addRecord() {
        String ID = textFieldID.getText();
        String name = textFieldName.getText();
        String alamat = textFieldAlamat.getText();
        String salary = textFieldNoTelp.getText();

        try (Statement statement = connection.createStatement()) {
            // Get the current maximum Transaksi_ID

            // Insert the new record
            String insertSql = "INSERT INTO Supplier (Supplier_ID, Nama_Supplier, Alamat_Sup, NoTelp_Sup) VALUES ('"
                    + ID + "', '"
                    + name + "', '"
                    + alamat + "', '"
                    + salary + "')";

            statement.executeUpdate(insertSql);
            readRecords();

            // // Insert the corresponding record in TransaksiSupplier
            // String insertTransaksiSql = "INSERT INTO TransaksiSupplier (Supplier_ID,
            // Transaksi_ID, Total_Harga) VALUES ('"
            // + ID + "', '"
            // + newTransaksiId + "', '"
            // + "0" + "')";

            // statement.executeUpdate(insertTransaksiSql);

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

    private void readRecords() {
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM Supplier")) {

            // Find the maximum length for each column
            int maxIdLength = 15;
            int maxNameLength = 25;
            int maxAlamatLength = 45;
            int maxNotelpLength = 15;

            StringBuilder resultText = new StringBuilder();
            resultText.append(String.format(
                    "%-" + maxIdLength + "s%-" + maxNameLength + "s%-" + maxAlamatLength + "s%-" + maxNotelpLength

                            + "s\n",
                    "Supplier_ID", "Nama_Supplier", "Alamat_Sup", "NoTelp_Sup"));
            while (resultSet.next()) {
                int id = resultSet.getInt("Supplier_ID");
                String name = resultSet.getString("Nama_Supplier");
                String alamat = resultSet.getString("Alamat_Sup");
                String notelp = resultSet.getString("NoTelp_Sup");

                resultText.append(String.format(
                        "%-" + maxIdLength + "d%-" + maxNameLength + "s%-" + maxAlamatLength + "s%-" + maxNotelpLength
                                + "s\n",
                        id, name, alamat, notelp));

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
            String updateSql = "UPDATE Supplier SET Alamat_Sup = '" + newAlamat +
                    "', NoTelp_Sup = '" + newNoTelp + "' WHERE Supplier_ID = " + id;

            statement.executeUpdate(updateSql);
            readRecords(); // Refresh the displayed records

            // Restore the selected text and caret position
            resultTextArea.setText(resultTextArea.getText()); // This is to refresh the text area
            resultTextArea.getCaret().setDot(selectionStart);
            resultTextArea.getCaret().moveDot(selectionEnd);
        } catch (SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error updating record: " + e.getMessage());
            readRecords();
        }
    }

    private void deleteRecord(int id) {
        try (Statement statement = connection.createStatement()) {
            String deleteSql = "DELETE FROM Supplier WHERE Supplier_ID = " + id;
            statement.executeUpdate(deleteSql);
            readRecords(); // Refresh the displayed records
        } catch (SQLException e) {
            e.printStackTrace();
            resultTextArea.setText("Error deleting record: " + e.getMessage());
            readRecords();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Supplier());
    }
}