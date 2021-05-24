import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficoTarta extends JFrame {
    private JPanel contentPane;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    private JTextField tf7;
    private JTextField tf8;
    private JTextField tf9;
    private JTextField tf10;
    private boolean bandera = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GraficoTarta frame = new GraficoTarta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GraficoTarta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.orange);
        setTitle("Inventario de Instrumentos");
        setBounds(100, 100, 1100, 700);
        setIconImage(new ImageIcon(getClass().getResource("Tulevik.jpg")).getImage());
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.lightGray);
        contentPane.setLayout(null);

        JLabel title = new JLabel("INSTRUMENTOS");
        title.setBounds(550, 23, 100, 14);
        contentPane.add(title);

        JLabel guitarras = new JLabel("Guitarras");
        guitarras.setBounds(46, 39, 61, 14);
        contentPane.add(guitarras);

        JLabel guitarrasS = new JLabel("Stock");
        guitarrasS.setBounds(46, 200, 61, 14);
        contentPane.add(guitarrasS);

        JLabel guitarrasO = new JLabel("Ocupadas");
        guitarrasO.setBounds(46, 230, 61, 14);
        contentPane.add(guitarrasO);

        JLabel bajos = new JLabel("Bajos");
        bajos.setBounds(350, 39, 61, 14);
        contentPane.add(bajos);

        JLabel BajosS = new JLabel("Stock");
        BajosS.setBounds(350, 200, 61, 14);
        contentPane.add(BajosS);

        JLabel BajosO = new JLabel("Ocupadas");
        BajosO.setBounds(350, 230, 61, 14);
        contentPane.add(BajosO);

        JLabel violin = new JLabel("Violines");
        violin.setBounds(654, 39, 61, 14);
        contentPane.add(violin);

        JLabel violinS = new JLabel("Stock");
        violinS.setBounds(654, 200, 61, 14);
        contentPane.add(violinS);

        JLabel violinO = new JLabel("Ocupadas");
        violinO.setBounds(654, 230, 61, 14);
        contentPane.add(violinO);

        JLabel saxofon = new JLabel("Saxofones");
        saxofon.setBounds(46, 329, 61, 14);
        contentPane.add(saxofon);

        JLabel saxofonS = new JLabel("Stock");
        saxofonS.setBounds(46, 500, 61, 14);
        contentPane.add(saxofonS);

        JLabel saxofonO = new JLabel("Ocupadas");
        saxofonO.setBounds(46, 530, 61, 14);
        contentPane.add(saxofonO);

        JLabel clarinete = new JLabel("Clarinetes");
        clarinete.setBounds(350, 329, 61, 14);
        contentPane.add(clarinete);

        JLabel clarineteS = new JLabel("Stock");
        clarineteS.setBounds(350, 500, 61, 14);
        contentPane.add(clarineteS);

        JLabel clarineteO = new JLabel("Ocupadas");
        clarineteO.setBounds(350, 530, 61, 14);
        contentPane.add(clarineteO);

        JLabel resumen = new JLabel("Resumen");
        resumen.setBounds(650, 329, 100, 14);
        contentPane.add(resumen);

        tf1 = new JTextField();
        tf1.setBounds(117, 200, 86, 20);
        contentPane.add(tf1);
        tf1.setColumns(10);

        tf2 = new JTextField();
        tf2.setBounds(117, 230, 86, 20);
        contentPane.add(tf2);
        tf2.setColumns(10);

        tf3 = new JTextField();
        tf3.setBounds(421, 200, 86, 20);
        contentPane.add(tf3);
        tf3.setColumns(10);

        tf4 = new JTextField();
        tf4.setBounds(421, 230, 86, 20);
        contentPane.add(tf4);
        tf4.setColumns(10);

        tf5 = new JTextField();
        tf5.setBounds(725, 200, 86, 20);
        contentPane.add(tf5);
        tf5.setColumns(10);

        tf6 = new JTextField();
        tf6.setBounds(725, 230, 86, 20);
        contentPane.add(tf6);
        tf6.setColumns(10);

        tf7 = new JTextField();
        tf7.setBounds(117, 500, 86, 20);
        contentPane.add(tf7);
        tf7.setColumns(10);

        tf8 = new JTextField();
        tf8.setBounds(117, 530, 86, 20);
        contentPane.add(tf8);
        tf8.setColumns(10);

        tf9 = new JTextField();
        tf9.setBounds(421, 500, 86, 20);
        contentPane.add(tf9);
        tf9.setColumns(10);

        tf10 = new JTextField();
        tf10.setBounds(421, 530, 86, 20);
        contentPane.add(tf10);
        tf10.setColumns(10);

        JButton btnGraficar = new JButton("Graficar");

        btnGraficar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                bandera = true;
                repaint();
            }
        });
        btnGraficar.setBounds(650, 570 , 107, 37);
        contentPane.add(btnGraficar);
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (bandera == true) {

            //Gráfico de Guitarras

            String s1 = tf1.getText();

            String s2 = tf2.getText();

            int v1 = Integer.parseInt(s1);

            int v2 = Integer.parseInt(s2);

            int disponibleG = v1 - v2;

            int grados1 = disponibleG * 360 / v1;

            int grados2 = v2 * 360 / v1;


            g.setColor(new Color(4, 17, 137));

            g.fillArc(50, 100, 100, 100, 0, grados1);

            g.fillRect(170, 120, 20, 20);

            g.drawString("Disponibles: "+disponibleG, 200, 130);


            g.setColor(new Color(77, 120, 250));

            g.fillArc(50, 100, 100, 100, grados1, grados2);

            g.fillRect(170, 150, 20, 20);

            g.drawString("Ocupadas", 200, 160);

            //Grafico de Bajos

            String s3 = tf3.getText();

            String s4 = tf4.getText();

            int v3 = Integer.parseInt(s3);

            int v4 = Integer.parseInt(s4);

            int disponibleB = v3 - v4;

            int grados3 = disponibleB * 360 / v3;

            int grados4 = v4 * 360 / v3;

            g.setColor(new Color(0, 130, 11));

            g.fillArc(350, 100, 100, 100, 0, grados3);

            g.fillRect(470, 120, 20, 20);

            g.drawString("Disponibles: "+disponibleB, 500, 130);


            g.setColor(new Color(140, 232, 141));

            g.fillArc(350, 100, 100, 100, grados3, grados4);

            g.fillRect(470, 150, 20, 20);

            g.drawString("Ocupadas", 500, 160);

            //Gráfico violines

            String s5 = tf5.getText();

            String s6 = tf6.getText();

            int v5 = Integer.parseInt(s5);

            int v6 = Integer.parseInt(s6);

            int disponibleV = v5 - v6;

            int grados5 = disponibleV * 360 / v5;

            int grados6 = v6 * 360 / v5;

            g.setColor(new Color(238, 255, 0));

            g.fillArc(650, 100, 100, 100, 0, grados5);

            g.fillRect(770, 120, 20, 20);

            g.drawString("Disponibles: "+disponibleV, 800, 130);


            g.setColor(new Color(255, 250, 127));

            g.fillArc(650, 100, 100, 100, grados5, grados6);

            g.fillRect(770, 150, 20, 20);

            g.drawString("Ocupadas", 800, 160);

            //Gráfico de Saxofones

            String s7 = tf7.getText();

            String s8 = tf8.getText();

            int v7 = Integer.parseInt(s7);

            int v8 = Integer.parseInt(s8);

            int disponibleS = v7 - v8;

            int grados7 = disponibleS * 360 / v7;

            int grados8 = v8 * 360 / v7;


            g.setColor(new Color(137, 4, 119));

            g.fillArc(50, 400, 100, 100, 0, grados7);

            g.fillRect(170, 420, 20, 20);

            g.drawString("Disponibles: "+disponibleS, 200, 430);


            g.setColor(new Color(189, 77, 250));

            g.fillArc(50, 400, 100, 100, grados7, grados8);

            g.fillRect(170, 450, 20, 20);

            g.drawString("Ocupadas", 200, 460);

            //Grafico de Clarinetes

            String s9 = tf9.getText();

            String s10 = tf10.getText();

            int v9 = Integer.parseInt(s9);

            int v10 = Integer.parseInt(s10);

            int disponibleC = v9 - v10;

            int grados9 = disponibleC * 360 / v9;

            int grados10 = v10 * 360 / v9;

            g.setColor(new Color(255, 114, 0));

            g.fillArc(350, 400, 100, 100, 0, grados9);

            g.fillRect(470, 420, 20, 20);

            g.drawString("Disponibles: "+disponibleC, 500, 430);


            g.setColor(new Color(255, 156, 88));

            g.fillArc(350, 400, 100, 100, grados9, grados10);

            g.fillRect(470, 450, 20, 20);

            g.drawString("Ocupadas", 500, 460);

            //resumen

            int total = v1+v2+v3+v4+v5+v6+v7+v8+v9+v10;
            int disponibles = (disponibleS+disponibleB+disponibleC+disponibleG+disponibleV);
            int ocupados = total-disponibles;

            int gradosO = ocupados*360/total;
            int gradosD = disponibles*360/total;

            g.setColor(new Color(0, 92, 65));

            g.fillArc(650, 400, 100, 100, 0, gradosO);

            g.fillRect(770, 420, 20, 20);

            g.drawString("Disponibles: "+disponibles, 800, 430);


            g.setColor(new Color(0, 121, 77));

            g.fillArc(650, 400, 100, 100, gradosO, gradosD);

            g.fillRect(770, 450, 20, 20);

            g.drawString("Ocupados: "+ocupados, 800, 460);

        }
    }
}