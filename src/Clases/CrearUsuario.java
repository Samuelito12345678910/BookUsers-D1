package Clases;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


public class CrearUsuario extends JFrame{
    private JButton btnRegistrar;
    private JButton btnLimpiar;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPasswordField passwordField1;
    private JTextField textField6;
    private JTextField textField7;
    private JButton btnSubir;
    private JPanel panelPrincipal;
    private JLabel txtTipoId;
    private JLabel txt;
    private JLabel txtNumDoc;
    private JLabel txtNombre1;
    private JLabel txtNombre2;
    private JLabel txtApellido2;
    private JLabel txtApellido1;
    private JLabel txtPasswor;
    private JLabel txtTelefono;
    private JLabel txtCorreo;

    private String rutaFoto = "";


    public CrearUsuario(){
        setContentPane(panelPrincipal);
        setTitle("Registro de Usuarios - BookUsers-D1");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cmbTipoDoc.addItem("Cédula de Ciudadanía (CC)");
        cmbTipoDoc.addItem("Tarjeta de Identidad (TI)");
        cmbTipoDoc.addItem("Registro Civil (RC)");
        cmbTipoDoc.addItem("Cédula de Extranjería (CE)");
        cmbTipoDoc.addItem("Pasaporte (PA)");
        cmbTipoDoc.addItem("Permiso por Protección Temporal (PPT)");

        // 2. Botón Subir (Filtro solo PNG y JPG)
        btnSubir.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (PNG, JPG)", "png", "jpg", "jpeg");
            selector.setFileFilter(filtro);
            selector.setAcceptAllFileFilterUsed(false);

            if (selector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File archivo = selector.getSelectedFile();
                rutaFoto = archivo.getAbsolutePath();
                btnSubir.setText(archivo.getName()); // Cambia el texto del botón al nombre de la foto
            }
        });

        // 3. Botón Registrar (Guardar en el ArrayList)
        btnRegistrar.addActionListener(e -> {
            if (txtNumDoc.getText().isEmpty() || txtNombre1.getText().isEmpty() || txtApellido1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa al menos Documento, Primer Nombre y Primer Apellido.");
                return;
            }

            Usuario nuevo = new Usuario(
                    cmbTipoDoc.getSelectedItem().toString(),
                    txtNumDoc.getText(),
                    txtNombre1.getText(),
                    txtNombre2.getText(),
                    txtApellido1.getText(),
                    txtApellido2.getText(),
                    txtPasswor.getText(),
                    txtTelefono.getText(),
                    txtCorreo.getText(),
                    rutaFoto
            );

            Usuario.listaUsuarios.add(nuevo);

            JOptionPane.showMessageDialog(this,
                    "¡Usuario registrado!\nID: " + nuevo.getId() + "\nUsername: " + nuevo.getUsername());

            limpiarCampos();
        });

        // 4. Botón Limpiar
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void limpiarCampos() {
        txtNumDoc.setText("");
        txtNombre1.setText("");
        txtNombre2.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        txtPasswor.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        btnSubir.setText("Subir");
        rutaFoto = "";
    }
}
