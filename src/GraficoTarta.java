import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraficoTarta extends JFrame {
    private JPanel contentPane;
    private JTextField tf[] = new JTextField[5];
    private JTextField stock[] = new JTextField[5];
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
        setTitle("Inventario de Instrumentos");
        setBounds(100, 100, 1100, 700);
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

        stock[0] = new JTextField();
        stock[0].setBounds(117, 200, 86, 20);
        contentPane.add(stock[0]);
        stock[0].setColumns(10);

        tf[0] = new JTextField();
        tf[0].setBounds(117, 230, 86, 20);
        contentPane.add(tf[0]);
        tf[0].setColumns(10);

        stock[1] = new JTextField();
        stock[1].setBounds(421, 200, 86, 20);
        contentPane.add(stock[1]);
        stock[1].setColumns(10);

        tf[1] = new JTextField();
        tf[1].setBounds(421, 230, 86, 20);
        contentPane.add(tf[1]);
        tf[1].setColumns(10);

        stock[2] = new JTextField();
        stock[2].setBounds(725, 200, 86, 20);
        contentPane.add(stock[2]);
        stock[2].setColumns(10);

        tf[2] = new JTextField();
        tf[2].setBounds(725, 230, 86, 20);
        contentPane.add(tf[2]);
        tf[2].setColumns(10);

        stock[3] = new JTextField();
        stock[3].setBounds(117, 500, 86, 20);
        contentPane.add(stock[3]);
        stock[3].setColumns(10);

        tf[3] = new JTextField();
        tf[3].setBounds(117, 530, 86, 20);
        contentPane.add(tf[3]);
        tf[3].setColumns(10);

        stock[4] = new JTextField();
        stock[4].setBounds(421, 500, 86, 20);
        contentPane.add(stock[4]);
        stock[4].setColumns(10);

        tf[4] = new JTextField();
        tf[4].setBounds(421, 530, 86, 20);
        contentPane.add(tf[4]);
        tf[4].setColumns(10);

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

            String s[] = new String[10];

            int v[] = new int[10];

            //asignando a s el valor de stock
            for (int i = 0; i < stock.length; i++) {
                s[i] = stock[i].getText();
            }
            int m=0;
            for (int j = 5; j < 10; j++) {
                s[j] = tf[m].getText();
                m++;
            }

            //asignando s a v
            for (int i = 0; i <10 ; i++) {
                v[i]= Integer.parseInt(s[i]);
            }

            g.setColor(new Color(255, 0, 6));


            //Gráfico de Guitarras
            int disponibleG = v[0] - v[5];

            int grados1 = disponibleG * 360 / v[0];

            int grados2 = v[5] * 360 / v[0];

            if(v[5]>v[0]){
                JOptionPane.showMessageDialog(null, "ERROR "+v[5]+" can't be greater than "+v[0]);
                disponibleG = 0;
                g.drawString("Error ", 50, 150);
            }else{

                g.setColor(new Color(4, 17, 137));

                g.fillArc(50, 100, 100, 100, 0, grados1);

                g.fillRect(170, 120, 20, 20);

                g.drawString("Disponibles: "+disponibleG, 200, 130);


                g.setColor(new Color(77, 120, 250));

                g.fillArc(50, 100, 100, 100, grados1, grados2);

                g.fillRect(170, 150, 20, 20);

                g.drawString("Ocupadas", 200, 160);
            }


            //Grafico de Bajos

            int disponibleB = v[1] - v[6];

            int grados3 = disponibleB * 360 / v[1];

            int grados4 = v[6] * 360 / v[1];

            g.setColor(new Color(255, 0, 6));

            if(v[6]>v[1]){
                JOptionPane.showMessageDialog(null, "ERROR "+v[6]+" can't be greater than "+v[1]);
                disponibleB = 0;
                g.drawString("Error ", 350, 150);
            }else{

                g.setColor(new Color(0, 130, 11));

                g.fillArc(350, 100, 100, 100, 0, grados3);

                g.fillRect(470, 120, 20, 20);

                g.drawString("Disponibles: "+disponibleB, 500, 130);


                g.setColor(new Color(140, 232, 141));

                g.fillArc(350, 100, 100, 100, grados3, grados4);

                g.fillRect(470, 150, 20, 20);

                g.drawString("Ocupadas", 500, 160);
            }

            //Gráfico violines

            int disponibleV = v[2] - v[7];

            int grados5 = disponibleV * 360 / v[2];

            int grados6 = v[7] * 360 / v[2];

            g.setColor(new Color(255, 0, 6));

            if(v[7]>v[2]) {
                JOptionPane.showMessageDialog(null, "ERROR " + v[7] + " can't be greater than " + v[2]);
                disponibleV = 0;
                g.drawString("Error ", 650, 150);
            }else{

                g.setColor(new Color(238, 255, 0));

                g.fillArc(650, 100, 100, 100, 0, grados5);

                g.fillRect(770, 120, 20, 20);

                g.drawString("Disponibles: "+disponibleV, 800, 130);


                g.setColor(new Color(255, 250, 127));

                g.fillArc(650, 100, 100, 100, grados5, grados6);

                g.fillRect(770, 150, 20, 20);

                g.drawString("Ocupadas", 800, 160);
            }

            //Gráfico de Saxofones

            int disponibleS = v[3] - v[8];

            int grados7 = disponibleS * 360 / v[3];

            int grados8 = v[8] * 360 / v[3];

            g.setColor(new Color(255, 0, 6));

            if(v[8]>v[3]){
                JOptionPane.showMessageDialog(null, "ERROR "+v[8]+" can't be greater than "+v[3]);
                disponibleS = 0;
                g.drawString("Error ", 50, 450);
            }else{

                g.setColor(new Color(137, 4, 119));

                g.fillArc(50, 400, 100, 100, 0, grados7);

                g.fillRect(170, 420, 20, 20);

                g.drawString("Disponibles: "+disponibleS, 200, 430);


                g.setColor(new Color(189, 77, 250));

                g.fillArc(50, 400, 100, 100, grados7, grados8);

                g.fillRect(170, 450, 20, 20);

                g.drawString("Ocupadas", 200, 460);
            }

            //Grafico de Clarinetes

            int disponibleC = v[4] - v[9];

            int grados9 = disponibleC * 360 / v[4];

            int grados10 = v[9] * 360 / v[4];

            g.setColor(new Color(255, 0, 6));

            if(v[9]>v[4]){
                JOptionPane.showMessageDialog(null, "ERROR "+v[9]+" can't be greater than "+v[4]);
                disponibleC = 0;
                g.drawString("Error ", 350, 450);
            }else{

                g.setColor(new Color(255, 114, 0));

                g.fillArc(350, 400, 100, 100, 0, grados9);

                g.fillRect(470, 420, 20, 20);

                g.drawString("Disponibles: "+disponibleC, 500, 430);


                g.setColor(new Color(255, 156, 88));

                g.fillArc(350, 400, 100, 100, grados9, grados10);

                g.fillRect(470, 450, 20, 20);

                g.drawString("Ocupadas", 500, 460);
            }


            //resumen

            int total = 0;
            for (int i = 0; i < 5; i++) {
                total=total+v[i];
            }

            int disponibles = disponibleG+disponibleB+disponibleV+disponibleS+disponibleC;
            int ocupados = total-disponibles;

            int gradosO = ocupados*360/total;
            int gradosD = disponibles*360/total;

            g.setColor(new Color(0, 92, 65));

            g.fillArc(650, 400, 100, 100, 0, gradosD);

            g.fillRect(770, 420, 20, 20);

            g.drawString("Disponibles: "+disponibles, 800, 430);


            g.setColor(new Color(0, 121, 77));

            g.fillArc(650, 400, 100, 100, gradosD, gradosO);

            g.fillRect(770, 450, 20, 20);

            g.drawString("Ocupados: "+ocupados, 800, 460);

            g.setColor(new Color(7, 114, 196));

            g.drawString("Instrumentos totales: "+total,800, 490);
        }
    }
}