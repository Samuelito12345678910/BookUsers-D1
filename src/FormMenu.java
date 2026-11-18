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
        }
    }

