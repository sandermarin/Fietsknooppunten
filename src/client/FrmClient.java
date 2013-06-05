package client;

import data.Fietstocht;
import data.Knooppunt;
import data.Route;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmClient extends javax.swing.JFrame {

    private ClientAppl client;
    private List<Knooppunt> knooppunten = new ArrayList();
    private Knooppunt beginKnooppunt;
    private List<Route> routes = new ArrayList();
    
    private DefaultTableModel tmodel = new DefaultTableModel();
    private DefaultListModel lmodel = new DefaultListModel();

    public FrmClient() {
        initComponents();

        //voor de eenvoud
        try {
            txtServerIP.setText("" + InetAddress.getLocalHost().getHostAddress());
            txtServerPoort.setText("" + 1234);
        } catch (UnknownHostException uhe) {
            JOptionPane.showMessageDialog(this, uhe.getMessage());
        }

        //tabel
        tblFietstocht.setModel(tmodel);
        tmodel.addColumn("Route");
        tmodel.addColumn("Aantal km");
        tmodel.addColumn("Totaal aantal km");

        //JList
        lstKnooppunten.setModel(lmodel);




    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtOutput = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtServerIP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtServerPoort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnMakeConnection = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFietstocht = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblVorigKnooppuntnr = new javax.swing.JLabel();
        btnSelecteerStartFietstocht = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboRoutes = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        lblAfstandRoute = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnVoegRouteToe = new javax.swing.JButton();
        btnBewaarFietstocht = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstKnooppunten = new javax.swing.JList();
        lblTotaalAantalKmFietstocht = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cboFietstochten = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fietsknooppunten netwerk Vlaanderen");
        setMinimumSize(new java.awt.Dimension(400, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        txtOutput.setEditable(false);
        getContentPane().add(txtOutput, java.awt.BorderLayout.SOUTH);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setText("Server IP:");
        jPanel1.add(jLabel1);
        jPanel1.add(txtServerIP);

        jLabel2.setText("Poort:");
        jPanel1.add(jLabel2);
        jPanel1.add(txtServerPoort);
        jPanel1.add(jLabel3);

        btnMakeConnection.setText("Make Connection");
        btnMakeConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeConnectionActionPerformed(evt);
            }
        });
        jPanel1.add(btnMakeConnection);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setEnabled(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setEnabled(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setEnabled(false);

        jPanel7.setLayout(new java.awt.BorderLayout());

        tblFietstocht.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblFietstocht);

        jPanel7.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel8.setLayout(new java.awt.GridLayout(4, 2));

        jLabel4.setText("Vorige knooppunt:");
        jPanel8.add(jLabel4);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2));

        lblVorigKnooppuntnr.setText("<start>");
        jPanel9.add(lblVorigKnooppuntnr);

        btnSelecteerStartFietstocht.setText("Start...");
        btnSelecteerStartFietstocht.setEnabled(false);
        btnSelecteerStartFietstocht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecteerStartFietstochtActionPerformed(evt);
            }
        });
        jPanel9.add(btnSelecteerStartFietstocht);

        jPanel8.add(jPanel9);

        jLabel5.setText("Routes naar volgend knooppunten:");
        jPanel8.add(jLabel5);

        cboRoutes.setEnabled(false);
        cboRoutes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRoutesActionPerformed(evt);
            }
        });
        jPanel8.add(cboRoutes);

        jLabel6.setText("Afstand (km):");
        jPanel8.add(jLabel6);

        lblAfstandRoute.setEditable(false);
        lblAfstandRoute.setText("<afstand naar volgende knooppuntt>");
        jPanel8.add(lblAfstandRoute);
        jPanel8.add(jLabel7);

        btnVoegRouteToe.setText("Voeg route toe!");
        btnVoegRouteToe.setEnabled(false);
        btnVoegRouteToe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoegRouteToeActionPerformed(evt);
            }
        });
        jPanel8.add(btnVoegRouteToe);

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        btnBewaarFietstocht.setText("Bewaar fietstocht!");
        btnBewaarFietstocht.setEnabled(false);
        btnBewaarFietstocht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBewaarFietstochtActionPerformed(evt);
            }
        });
        jPanel7.add(btnBewaarFietstocht, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Deel jouw fietstocht met anderen", jPanel7);

        jPanel10.setLayout(new java.awt.BorderLayout());

        lstKnooppunten.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstKnooppunten);

        jPanel10.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        lblTotaalAantalKmFietstocht.setText("Totaal aantal km:");
        jPanel10.add(lblTotaalAantalKmFietstocht, java.awt.BorderLayout.PAGE_END);

        jPanel11.setLayout(new java.awt.GridLayout(1, 3));

        jLabel10.setText("Bewaarde fietstochten:");
        jPanel11.add(jLabel10);

        jPanel11.add(cboFietstochten);

        jPanel10.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Overzicht fietstochten", jPanel10);

        jPanel3.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-654)/2, (screenSize.height-420)/2, 654, 420);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        //Sluiten van connectie indien nog open
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btnMakeConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeConnectionActionPerformed
        try {
            // Add your handling code here:
            client = new ClientAppl(txtServerIP.getText(), Integer.parseInt(txtServerPoort.getText()), this);
            client.makeConnection();

            client.getKnooppunten();
            
            btnSelecteerStartFietstocht.setEnabled(true);
            btnMakeConnection.setEnabled(false);
            jTabbedPane1.setEnabled(true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnMakeConnectionActionPerformed

    private void btnSelecteerStartFietstochtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecteerStartFietstochtActionPerformed
        JList list = new JList();
        DefaultListModel dlmKnooppunten = new DefaultListModel();
        
        dlmKnooppunten.removeAllElements();
 
        for(Knooppunt k : knooppunten){
            dlmKnooppunten.addElement(k);
        }
        
        list.setModel(dlmKnooppunten);
        
        JScrollPane scrollpane = new JScrollPane(list);
        scrollpane.setSize(300, 100);
        
        JOptionPane.showMessageDialog(null, scrollpane, "Fietstocht", JOptionPane.QUESTION_MESSAGE);
        beginKnooppunt = (Knooppunt) list.getSelectedValue();
        
        lblVorigKnooppuntnr.setText(beginKnooppunt.toString());
        
        getRoutesFromKnooppunt(beginKnooppunt);
        
        
    }//GEN-LAST:event_btnSelecteerStartFietstochtActionPerformed

    private void cboRoutesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRoutesActionPerformed
        Route r = (Route) cboRoutes.getSelectedItem();
        lblAfstandRoute.setText(r.getAantalKm() + "");
        btnVoegRouteToe.setEnabled(true);
    }//GEN-LAST:event_cboRoutesActionPerformed

    private void btnVoegRouteToeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoegRouteToeActionPerformed
        
        setRouteTable();
        
        btnBewaarFietstocht.setEnabled(true);
        
    }//GEN-LAST:event_btnVoegRouteToeActionPerformed

    private void btnBewaarFietstochtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBewaarFietstochtActionPerformed
        
    }//GEN-LAST:event_btnBewaarFietstochtActionPerformed

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
        }

        FrmClient frm = new FrmClient();
        frm.setVisible(true);
    }
    
    //Events
    public void setRouteTable(){
        int maxKm = 0;
        Route r = (Route) cboRoutes.getSelectedItem();
        routes.add(r);
        
        for(Route oR : routes){
            maxKm += oR.getAantalKm();
        }
        
        tmodel.addRow(new Object[] {r.getStartKnooppunt().getNummerBord() + " > " + r.getEindKnooppunt().getNummerBord(),r.getAantalKm(),maxKm});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBewaarFietstocht;
    private javax.swing.JButton btnMakeConnection;
    private javax.swing.JButton btnSelecteerStartFietstocht;
    private javax.swing.JButton btnVoegRouteToe;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboFietstochten;
    private javax.swing.JComboBox cboRoutes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lblAfstandRoute;
    private javax.swing.JLabel lblTotaalAantalKmFietstocht;
    private javax.swing.JLabel lblVorigKnooppuntnr;
    private javax.swing.JList lstKnooppunten;
    private javax.swing.JTable tblFietstocht;
    private javax.swing.JTextField txtOutput;
    private javax.swing.JTextField txtServerIP;
    private javax.swing.JTextField txtServerPoort;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc="Commands to server">
    public void getRoutesFromKnooppunt(Knooppunt k){
        cboRoutes.setEnabled(true);
        try {
            client.getRoutesFromKnooppunt(k);
        } catch (IOException ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bewaarFietstocht(){
        String naam = JOptionPane.showInputDialog(null,"Geef een naam voor deze fietstocht:");
        String extraInfo = JOptionPane.showInputDialog(null,"Extra info omtrent deze fietstocht:");
        
        Fietstocht f;
        f = new Fietstocht(naam, extraInfo);
        
        try {
            client.insertFietstocht(f, knooppunten);
        } catch (IOException ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Commands from server">
    public void toonKnooppunten(List<Knooppunt> knooppunten) {
        this.knooppunten = knooppunten;
    }
    
    public void vulRoutes(List<Route> routes){
        for(Route r : routes){
            cboRoutes.addItem(r);
        }
    }
    //</editor-fold>
    
}
