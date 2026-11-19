import javax.swing.*;
import Clases.Usuario;
import java.util.ArrayList;
public class FormMenu  extends JFrame{
    private JPanel panelPrincipal;
    private JButton btnCreditos;
    private JButton btnLIstado;
    private JButton btnRegistrar;

    private ArrayList<Usuario>listaUsuarios;
    private int contador = 1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
        public FormMenu() {
            listaUsuarios = new ArrayList<>();
            setTitle("BookUsers-SuarezJostin y JuanPacheco");
            setContentPane(panelPrincipal);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 300);
            setLocationRelativeTo(null);
            btnRegistrar.addActionListener(e-> new FormRegistro(listaUsuarios, this).setVisible(true));
            btnLIstado.addActionListener(e -> new FormListado(listaUsuarios).setVisible(true));
            btnCreditos.addActionListener(e -> new FormCreditos().setVisible(true));
        }
        public int generarSiguienteId() {return contador++; }
        public static void main(String[] args) {SwingUtilities.invokeLater(()-> new FormMenu().setVisible(true));}
    }

