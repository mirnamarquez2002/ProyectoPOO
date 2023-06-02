import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraPolinomios {

    private JFrame ventana;
    private JTextField entradaPolinomio;
    private JTextField salidaPolinomio;
    private JButton botonResolver;

    public CalculadoraPolinomios() {
        // Crear la ventana principal
        ventana = new JFrame("Calculadora de Polinomios");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400);

        // Crear el panel superior con el título, Discutir necesidad de este panel.
        /* 
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.BLUE);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel etiquetaTitulo = new JLabel("Calculadora de Polinomios");
        panelSuperior.add(etiquetaTitulo);
        */
        //Creating inferior panel
        JPanel panelInf = new JPanel();
        panelInf.setLayout(new BorderLayout());
        salidaPolinomio = new JTextField(21);
        panelInf.add(salidaPolinomio, BorderLayout.CENTER);

        // Crear el panel derecho con los botones de control
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(3, 1));
        JButton botonAdd = new JButton("Sumar");
        JButton botonSubstract = new JButton("Restar");
        JButton botonEval = new JButton("Evaluar");
        JButton botonMult = new JButton("Multiplicar");
        JButton botonGraph = new JButton("Graficar");
        JButton botonCerrar = new JButton("X");
        panelLeft.add(botonAdd);
        panelLeft.add(botonSubstract);
        panelLeft.add(botonEval);
        panelLeft.add(botonMult);
        panelLeft.add(botonGraph);
        panelLeft.add(botonCerrar);

        // Crear el panel izquierdo para la ventana gráfica
        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.LIGHT_GRAY);
        // Aquí puedes agregar los componentes necesarios para la gráfica

        // Crear el panel central para la entrada de polinomio y el botón de resolver
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        JLabel etiquetaEntrada = new JLabel("Entrada:");
        entradaPolinomio = new JTextField(10);
        botonResolver = new JButton("Ingresar Polinomio");
        panelCentral.add(etiquetaEntrada, BorderLayout.NORTH);
        panelCentral.add(entradaPolinomio, BorderLayout.CENTER);
        panelCentral.add(botonResolver, BorderLayout.SOUTH);

        // Agregar los paneles a la ventana principal
        // ventana.add(panelSuperior, BorderLayout.NORTH); <- Is this necessary?

        ventana.add(panelRight, BorderLayout.EAST);
        ventana.add(panelLeft, BorderLayout.WEST);
        ventana.add(panelCentral, BorderLayout.CENTER);
        ventana.add(panelInf, BorderLayout.SOUTH);

        // Agregar acciones a los botones
        botonResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolverPolinomio();
            }
        });
        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Mostrar la ventana
        ventana.setVisible(true);
    }

    private void resolverPolinomio() {
        String polinomio = entradaPolinomio.getText();
        // Lógica para resolver el polinomio
        // y mostrar el resultado en la interfaz
        JOptionPane.showMessageDialog(ventana, "El polinomio es: " + polinomio);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraPolinomios();
            }
        });
    }
}
