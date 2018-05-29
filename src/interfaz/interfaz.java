/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author d13
 */
public class interfaz extends javax.swing.JFrame {
    private TableColumnModel tableColumnModel;

    private JRadioButton[] patron_rb;   //rb=RadioButton
    private String[] patron_strg;       //strg=String
    private String patron_row = "";     //row=Patron de la tabla

    private JRadioButton[] patron_e_rb; 
    private int[] patron_e_int = new int[49];
    /**
     * Creates new form interfaz
     */
    public interfaz() {
        initComponents();
        /**
         * Centra Form
         */
        this.setLocationRelativeTo(null);
        /**
         * Configura tamaño de Columnas
         */
        this.setConfigurationColums();
        this.getRadioButtons();
        this.createPatronString();
        
    }
    
    private void setConfigurationColums()
    {
        tableColumnModel = Table_Leer.getColumnModel();
        tableColumnModel.getColumn(0).setPreferredWidth(100);
        tableColumnModel.getColumn(1).setPreferredWidth(100);
        tableColumnModel.getColumn(2).setPreferredWidth(700);
    }
    
    private void getRadioButtons()
    {
        JRadioButton[] patron = 
        {
            this.Pen_F0_C0, this.Pen_F0_C1, this.Pen_F0_C2, this.Pen_F0_C3, this.Pen_F0_C4, this.Pen_F0_C5, this.Pen_F0_C6,
            this.Pen_F1_C0, this.Pen_F1_C1, this.Pen_F1_C2, this.Pen_F1_C3, this.Pen_F1_C4, this.Pen_F1_C5, this.Pen_F0_C6,
            this.Pen_F2_C0, this.Pen_F2_C1, this.Pen_F2_C2, this.Pen_F2_C3, this.Pen_F2_C4, this.Pen_F2_C5, this.Pen_F0_C6,
            this.Pen_F3_C0, this.Pen_F3_C1, this.Pen_F3_C2, this.Pen_F3_C3, this.Pen_F3_C4, this.Pen_F3_C5, this.Pen_F0_C6,
            this.Pen_F4_C0, this.Pen_F4_C1, this.Pen_F4_C2, this.Pen_F4_C3, this.Pen_F4_C4, this.Pen_F4_C5, this.Pen_F0_C6,
            this.Pen_F5_C0, this.Pen_F5_C1, this.Pen_F5_C2, this.Pen_F5_C3, this.Pen_F5_C4, this.Pen_F5_C5, this.Pen_F0_C6,
            this.Pen_F6_C0, this.Pen_F6_C1, this.Pen_F6_C2, this.Pen_F6_C3, this.Pen_F6_C4, this.Pen_F6_C5, this.Pen_F0_C6,
        };
        
        JRadioButton[] patron_e = 
        {
            this.Pe_F0_C0, this.Pe_F0_C1, this.Pe_F0_C2, this.Pe_F0_C3, this.Pe_F0_C4, this.Pe_F0_C5, this.Pe_F0_C6,
            this.Pe_F1_C0, this.Pe_F1_C1, this.Pe_F1_C2, this.Pe_F1_C3, this.Pe_F1_C4, this.Pe_F1_C5, this.Pe_F1_C6,
            this.Pe_F2_C0, this.Pe_F2_C1, this.Pe_F2_C2, this.Pe_F2_C3, this.Pe_F2_C4, this.Pe_F2_C5, this.Pe_F2_C6,
            this.Pe_F3_C0, this.Pe_F3_C1, this.Pe_F3_C2, this.Pe_F3_C3, this.Pe_F3_C4, this.Pe_F3_C5, this.Pe_F3_C6,
            this.Pe_F4_C0, this.Pe_F4_C1, this.Pe_F4_C2, this.Pe_F4_C3, this.Pe_F4_C4, this.Pe_F4_C5, this.Pe_F4_C6,
            this.Pe_F5_C0, this.Pe_F5_C1, this.Pe_F5_C2, this.Pe_F5_C3, this.Pe_F5_C4, this.Pe_F5_C5, this.Pe_F5_C6,
            this.Pe_F6_C0, this.Pe_F6_C1, this.Pe_F6_C2, this.Pe_F6_C3, this.Pe_F6_C4, this.Pe_F6_C5, this.Pe_F6_C6,
        };
        this.patron_rb = patron;
        this.patron_e_rb = patron_e;
    }
    
    private void createPatronString()
    {
        patron_strg = new String[patron_rb.length];
    }
    
    private void getPatron()
    {
        for (int i = 0; i < patron_rb.length; i++) {
            if (patron_rb[i].isSelected())
            {
                patron_strg[i] = "+1";
            }
            else{
                patron_strg[i] = "-1";
            }
            patron_row +=patron_strg[i];
        }
    }
    
    private void getPatronE()
    {
        for (int i = 0; i < patron_e_rb.length; i++) {
            if (patron_e_rb[i].isSelected())
            {
                patron_e_int[i] = +1;
            }
            else{
                patron_e_int[i] = -1;
            }
        }
    }
    
    private void showPatron()
    {
        String row = "";
        int p = 0;
        for (int i = 0; i < patron_strg.length; i++) {
            row += patron_strg[i];
            if (p==6) {
                p=0;
                System.out.println(row);
                row = "";
            }
            else{
                p++;
            }
            
        }
    }
    
    private void showPatronE()
    {
        String row_patron_e[] = new String[7];
        int c = 0;
        String matriz = "";
        for (int i = 0; i < patron_e_int.length; i++) {
            row_patron_e[c] = patron_e_int[i]>0?"+1":"-1";
            c++;
            if(c==7)
            {
                matriz += Arrays.toString(row_patron_e) + "\n";
                c=0;
            }
            
        }
        //TxtA_Matriz.setText(matriz.replace(" ", ""));
        System.out.println(matriz);
    }
    
    private void addPatronTable()
    {
        DefaultTableModel defaultTableModel = (DefaultTableModel) Table_Leer.getModel();
        defaultTableModel.addRow(new Object[]{"id","Descripcion",patron_row});
        //LIMPIA PATRON
        patron_row = "";
    }
    
    private void clearPatron()
    {
        for (int i = 0; i < patron_rb.length; i++) {
            if (patron_rb[i].isSelected()) {
                patron_rb[i].setSelected(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrpRbtn_TypeAlgorithm = new javax.swing.ButtonGroup();
        TPT = new javax.swing.JTabbedPane();
        P_Leer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Leer = new javax.swing.JTable();
        P_Escribir = new javax.swing.JPanel();
        P_Container_Patron = new javax.swing.JPanel();
        Pen_F0_C0 = new javax.swing.JRadioButton();
        Pen_F0_C1 = new javax.swing.JRadioButton();
        Pen_F0_C2 = new javax.swing.JRadioButton();
        Pen_F0_C3 = new javax.swing.JRadioButton();
        Pen_F0_C4 = new javax.swing.JRadioButton();
        Pen_F0_C5 = new javax.swing.JRadioButton();
        Pen_F1_C0 = new javax.swing.JRadioButton();
        Pen_F1_C1 = new javax.swing.JRadioButton();
        Pen_F1_C2 = new javax.swing.JRadioButton();
        Pen_F1_C3 = new javax.swing.JRadioButton();
        Pen_F1_C4 = new javax.swing.JRadioButton();
        Pen_F1_C5 = new javax.swing.JRadioButton();
        Pen_F2_C0 = new javax.swing.JRadioButton();
        Pen_F2_C1 = new javax.swing.JRadioButton();
        Pen_F2_C2 = new javax.swing.JRadioButton();
        Pen_F2_C3 = new javax.swing.JRadioButton();
        Pen_F2_C4 = new javax.swing.JRadioButton();
        Pen_F2_C5 = new javax.swing.JRadioButton();
        Pen_F3_C4 = new javax.swing.JRadioButton();
        Pen_F3_C0 = new javax.swing.JRadioButton();
        Pen_F3_C1 = new javax.swing.JRadioButton();
        Pen_F3_C2 = new javax.swing.JRadioButton();
        Pen_F3_C3 = new javax.swing.JRadioButton();
        Pen_F3_C5 = new javax.swing.JRadioButton();
        Pen_F4_C0 = new javax.swing.JRadioButton();
        Pen_F4_C1 = new javax.swing.JRadioButton();
        Pen_F4_C2 = new javax.swing.JRadioButton();
        Pen_F4_C3 = new javax.swing.JRadioButton();
        Pen_F4_C4 = new javax.swing.JRadioButton();
        Pen_F4_C5 = new javax.swing.JRadioButton();
        Pen_F5_C0 = new javax.swing.JRadioButton();
        Pen_F5_C1 = new javax.swing.JRadioButton();
        Pen_F5_C2 = new javax.swing.JRadioButton();
        Pen_F5_C3 = new javax.swing.JRadioButton();
        Pen_F5_C4 = new javax.swing.JRadioButton();
        Pen_F5_C5 = new javax.swing.JRadioButton();
        Pen_F6_C0 = new javax.swing.JRadioButton();
        Pen_F6_C1 = new javax.swing.JRadioButton();
        Pen_F6_C2 = new javax.swing.JRadioButton();
        Pen_F6_C3 = new javax.swing.JRadioButton();
        Pen_F6_C4 = new javax.swing.JRadioButton();
        Pen_F6_C5 = new javax.swing.JRadioButton();
        Pen_F0_C6 = new javax.swing.JRadioButton();
        Pen_F1_C6 = new javax.swing.JRadioButton();
        Pen_F2_C6 = new javax.swing.JRadioButton();
        Pen_F3_C6 = new javax.swing.JRadioButton();
        Pen_F4_C6 = new javax.swing.JRadioButton();
        Pen_F5_C6 = new javax.swing.JRadioButton();
        Pen_F6_C6 = new javax.swing.JRadioButton();
        P_Container_Acciones_Leer = new javax.swing.JPanel();
        Btn_ReadPatron = new javax.swing.JButton();
        Btn_LimpiarPatron = new javax.swing.JButton();
        P_Container_Acciones_Desc = new javax.swing.JPanel();
        TxF_Descripcion = new javax.swing.JTextField();
        P_Delete = new javax.swing.JPanel();
        Cbx_Delete = new javax.swing.JComboBox<>();
        Btn_Delete = new javax.swing.JButton();
        P_Main = new javax.swing.JPanel();
        P_Container_Patron1 = new javax.swing.JPanel();
        Pe_F0_C0 = new javax.swing.JRadioButton();
        Pe_F1_C0 = new javax.swing.JRadioButton();
        Pe_F2_C0 = new javax.swing.JRadioButton();
        Pe_F3_C0 = new javax.swing.JRadioButton();
        Pe_F4_C0 = new javax.swing.JRadioButton();
        Pe_F5_C0 = new javax.swing.JRadioButton();
        Pe_F6_C0 = new javax.swing.JRadioButton();
        Pe_F4_C1 = new javax.swing.JRadioButton();
        Pe_F5_C1 = new javax.swing.JRadioButton();
        Pe_F0_C1 = new javax.swing.JRadioButton();
        Pe_F1_C1 = new javax.swing.JRadioButton();
        Pe_F2_C1 = new javax.swing.JRadioButton();
        Pe_F6_C1 = new javax.swing.JRadioButton();
        Pe_F3_C1 = new javax.swing.JRadioButton();
        Pe_F1_C2 = new javax.swing.JRadioButton();
        Pe_F3_C2 = new javax.swing.JRadioButton();
        Pe_F6_C2 = new javax.swing.JRadioButton();
        Pe_F0_C2 = new javax.swing.JRadioButton();
        Pe_F2_C2 = new javax.swing.JRadioButton();
        Pe_F4_C2 = new javax.swing.JRadioButton();
        Pe_F5_C2 = new javax.swing.JRadioButton();
        Pe_F6_C3 = new javax.swing.JRadioButton();
        Pe_F5_C3 = new javax.swing.JRadioButton();
        Pe_F0_C3 = new javax.swing.JRadioButton();
        Pe_F4_C3 = new javax.swing.JRadioButton();
        Pe_F3_C3 = new javax.swing.JRadioButton();
        Pe_F2_C3 = new javax.swing.JRadioButton();
        Pe_F1_C3 = new javax.swing.JRadioButton();
        Pe_F6_C4 = new javax.swing.JRadioButton();
        Pe_F4_C4 = new javax.swing.JRadioButton();
        Pe_F0_C4 = new javax.swing.JRadioButton();
        Pe_F1_C4 = new javax.swing.JRadioButton();
        Pe_F2_C4 = new javax.swing.JRadioButton();
        Pe_F5_C4 = new javax.swing.JRadioButton();
        Pe_F3_C4 = new javax.swing.JRadioButton();
        Pe_F6_C5 = new javax.swing.JRadioButton();
        Pe_F2_C5 = new javax.swing.JRadioButton();
        Pe_F0_C5 = new javax.swing.JRadioButton();
        Pe_F4_C5 = new javax.swing.JRadioButton();
        Pe_F5_C5 = new javax.swing.JRadioButton();
        Pe_F3_C5 = new javax.swing.JRadioButton();
        Pe_F1_C5 = new javax.swing.JRadioButton();
        Pe_F6_C6 = new javax.swing.JRadioButton();
        Pe_F0_C6 = new javax.swing.JRadioButton();
        Pe_F3_C6 = new javax.swing.JRadioButton();
        Pe_F2_C6 = new javax.swing.JRadioButton();
        Pe_F4_C6 = new javax.swing.JRadioButton();
        Pe_F1_C6 = new javax.swing.JRadioButton();
        Pe_F5_C6 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        rBtn_NNH = new javax.swing.JRadioButton();
        rBtn_NNHGA = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        Btn_Start = new javax.swing.JButton();
        Btn_Entrenar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TxtA_Ps = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        Btn_ShowMatriz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TPT.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        TPT.setToolTipText("");

        Table_Leer.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        Table_Leer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Descripcion", "Patron"
            }
        ));
        jScrollPane1.setViewportView(Table_Leer);

        javax.swing.GroupLayout P_LeerLayout = new javax.swing.GroupLayout(P_Leer);
        P_Leer.setLayout(P_LeerLayout);
        P_LeerLayout.setHorizontalGroup(
            P_LeerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        P_LeerLayout.setVerticalGroup(
            P_LeerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );

        TPT.addTab("Leer", P_Leer);

        P_Container_Patron.setBorder(javax.swing.BorderFactory.createTitledBorder("Patron"));
        P_Container_Patron.setToolTipText("Entrada de patron para entrenamiento");
        P_Container_Patron.setName(""); // NOI18N

        Pen_F0_C0.setToolTipText("0,0");

        Pen_F0_C1.setToolTipText("0,1");

        Pen_F0_C2.setToolTipText("0,2");

        Pen_F0_C3.setToolTipText("0,3");

        Pen_F0_C4.setToolTipText("0,4");

        Pen_F0_C5.setToolTipText("0,5");

        Pen_F1_C0.setToolTipText("1,0");

        Pen_F1_C1.setToolTipText("1,1");

        Pen_F1_C2.setToolTipText("1,2");

        Pen_F1_C3.setToolTipText("1,3");

        Pen_F1_C4.setToolTipText("1,4");

        Pen_F1_C5.setToolTipText("1,5");

        Pen_F2_C0.setToolTipText("2,0");

        Pen_F2_C1.setToolTipText("2,1");

        Pen_F2_C2.setToolTipText("2,2");

        Pen_F2_C3.setToolTipText("2,3");

        Pen_F2_C4.setToolTipText("2,4");

        Pen_F2_C5.setToolTipText("2,5");

        Pen_F3_C4.setToolTipText("3,4");

        Pen_F3_C0.setToolTipText("3,0");

        Pen_F3_C1.setToolTipText("3,1");

        Pen_F3_C2.setToolTipText("3,2");

        Pen_F3_C3.setToolTipText("3,3");

        Pen_F3_C5.setToolTipText("3,5");

        Pen_F4_C0.setToolTipText("4,0");

        Pen_F4_C1.setToolTipText("4,1");

        Pen_F4_C2.setToolTipText("4,2");

        Pen_F4_C3.setToolTipText("4,3");

        Pen_F4_C4.setToolTipText("4,4");

        Pen_F4_C5.setToolTipText("4,5");

        Pen_F5_C0.setToolTipText("5,0");

        Pen_F5_C1.setToolTipText("5,1");

        Pen_F5_C2.setToolTipText("5,2");

        Pen_F5_C3.setToolTipText("5,3");

        Pen_F5_C4.setToolTipText("5,4");

        Pen_F5_C5.setToolTipText("5,5");

        Pen_F6_C0.setToolTipText("6,0");

        Pen_F6_C1.setToolTipText("6,1");

        Pen_F6_C2.setToolTipText("6,2");

        Pen_F6_C3.setToolTipText("6,3");

        Pen_F6_C4.setToolTipText("6,4");

        Pen_F6_C5.setToolTipText("6,5");

        Pen_F0_C6.setToolTipText("0,5");

        Pen_F1_C6.setToolTipText("1,5");

        Pen_F2_C6.setToolTipText("2,5");

        Pen_F3_C6.setToolTipText("3,5");

        Pen_F4_C6.setToolTipText("4,5");

        Pen_F5_C6.setToolTipText("5,5");

        Pen_F6_C6.setToolTipText("6,5");

        javax.swing.GroupLayout P_Container_PatronLayout = new javax.swing.GroupLayout(P_Container_Patron);
        P_Container_Patron.setLayout(P_Container_PatronLayout);
        P_Container_PatronLayout.setHorizontalGroup(
            P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_Container_PatronLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addComponent(Pen_F0_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F0_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F0_C2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F0_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F0_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F0_C5))
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addComponent(Pen_F1_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F1_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F1_C2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F1_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F1_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F1_C5))
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addComponent(Pen_F2_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F2_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F2_C2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F2_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F2_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F2_C5))
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addComponent(Pen_F3_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F3_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F3_C2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F3_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F3_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F3_C5))
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addComponent(Pen_F4_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F4_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F4_C2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F4_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F4_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F4_C5))
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addComponent(Pen_F5_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F5_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F5_C2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F5_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F5_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F5_C5))
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addComponent(Pen_F6_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F6_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F6_C2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F6_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F6_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F6_C5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pen_F0_C6)
                    .addComponent(Pen_F1_C6)
                    .addComponent(Pen_F2_C6)
                    .addComponent(Pen_F3_C6)
                    .addComponent(Pen_F4_C6)
                    .addComponent(Pen_F5_C6)
                    .addComponent(Pen_F6_C6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        P_Container_PatronLayout.setVerticalGroup(
            P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_Container_PatronLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addComponent(Pen_F0_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F1_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F2_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F3_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F4_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F5_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pen_F6_C6))
                    .addGroup(P_Container_PatronLayout.createSequentialGroup()
                        .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pen_F0_C2)
                            .addComponent(Pen_F0_C3)
                            .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Pen_F0_C0)
                                .addComponent(Pen_F0_C1)
                                .addComponent(Pen_F0_C4))
                            .addComponent(Pen_F0_C5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pen_F1_C2)
                            .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Pen_F1_C0)
                                .addComponent(Pen_F1_C1)
                                .addComponent(Pen_F1_C3)
                                .addComponent(Pen_F1_C4))
                            .addComponent(Pen_F1_C5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pen_F2_C2)
                            .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Pen_F2_C0)
                                .addComponent(Pen_F2_C1)
                                .addComponent(Pen_F2_C3)
                                .addComponent(Pen_F2_C4))
                            .addComponent(Pen_F2_C5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pen_F3_C2)
                            .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Pen_F3_C0)
                                .addComponent(Pen_F3_C1)
                                .addComponent(Pen_F3_C3)
                                .addComponent(Pen_F3_C4))
                            .addComponent(Pen_F3_C5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pen_F4_C2)
                            .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Pen_F4_C0)
                                .addComponent(Pen_F4_C1)
                                .addComponent(Pen_F4_C3)
                                .addComponent(Pen_F4_C4))
                            .addComponent(Pen_F4_C5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pen_F5_C2)
                            .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Pen_F5_C0)
                                .addComponent(Pen_F5_C1)
                                .addComponent(Pen_F5_C3)
                                .addComponent(Pen_F5_C4))
                            .addComponent(Pen_F5_C5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pen_F6_C2)
                            .addGroup(P_Container_PatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Pen_F6_C0)
                                .addComponent(Pen_F6_C1)
                                .addComponent(Pen_F6_C3)
                                .addComponent(Pen_F6_C4))
                            .addComponent(Pen_F6_C5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        P_Container_Acciones_Leer.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        Btn_ReadPatron.setText("Leer Patron");
        Btn_ReadPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ReadPatronActionPerformed(evt);
            }
        });

        Btn_LimpiarPatron.setText("Limpiar Patron");
        Btn_LimpiarPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LimpiarPatronActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_Container_Acciones_LeerLayout = new javax.swing.GroupLayout(P_Container_Acciones_Leer);
        P_Container_Acciones_Leer.setLayout(P_Container_Acciones_LeerLayout);
        P_Container_Acciones_LeerLayout.setHorizontalGroup(
            P_Container_Acciones_LeerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_Container_Acciones_LeerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_Container_Acciones_LeerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_ReadPatron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_LimpiarPatron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        P_Container_Acciones_LeerLayout.setVerticalGroup(
            P_Container_Acciones_LeerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_Container_Acciones_LeerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_ReadPatron)
                .addGap(18, 18, 18)
                .addComponent(Btn_LimpiarPatron)
                .addContainerGap())
        );

        P_Container_Acciones_Desc.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));

        TxF_Descripcion.setToolTipText("Letra que representa el Patron");

        javax.swing.GroupLayout P_Container_Acciones_DescLayout = new javax.swing.GroupLayout(P_Container_Acciones_Desc);
        P_Container_Acciones_Desc.setLayout(P_Container_Acciones_DescLayout);
        P_Container_Acciones_DescLayout.setHorizontalGroup(
            P_Container_Acciones_DescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_Container_Acciones_DescLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxF_Descripcion)
                .addContainerGap())
        );
        P_Container_Acciones_DescLayout.setVerticalGroup(
            P_Container_Acciones_DescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxF_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout P_EscribirLayout = new javax.swing.GroupLayout(P_Escribir);
        P_Escribir.setLayout(P_EscribirLayout);
        P_EscribirLayout.setHorizontalGroup(
            P_EscribirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_EscribirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P_Container_Patron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(P_EscribirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(P_Container_Acciones_Desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(P_Container_Acciones_Leer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(625, Short.MAX_VALUE))
        );
        P_EscribirLayout.setVerticalGroup(
            P_EscribirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_EscribirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_EscribirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(P_EscribirLayout.createSequentialGroup()
                        .addComponent(P_Container_Acciones_Desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(P_Container_Acciones_Leer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(P_Container_Patron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        TPT.addTab("Escribir", P_Escribir);

        Cbx_Delete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Btn_Delete.setText("Borrar");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_DeleteLayout = new javax.swing.GroupLayout(P_Delete);
        P_Delete.setLayout(P_DeleteLayout);
        P_DeleteLayout.setHorizontalGroup(
            P_DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_DeleteLayout.createSequentialGroup()
                .addGroup(P_DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_DeleteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Cbx_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(P_DeleteLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Btn_Delete)))
                .addContainerGap(829, Short.MAX_VALUE))
        );
        P_DeleteLayout.setVerticalGroup(
            P_DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_DeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cbx_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Delete)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        TPT.addTab("Borrar", P_Delete);

        P_Container_Patron1.setBorder(javax.swing.BorderFactory.createTitledBorder("Patron"));
        P_Container_Patron1.setToolTipText("Entrada de patron para entrenamiento");
        P_Container_Patron1.setName(""); // NOI18N

        Pe_F0_C0.setToolTipText("0,0");

        Pe_F1_C0.setToolTipText("1,0");

        Pe_F2_C0.setToolTipText("2,0");

        Pe_F3_C0.setToolTipText("3,0");

        Pe_F4_C0.setToolTipText("4,0");

        Pe_F5_C0.setToolTipText("5,0");

        Pe_F6_C0.setToolTipText("6,0");

        Pe_F4_C1.setToolTipText("4,0");

        Pe_F5_C1.setToolTipText("5,0");

        Pe_F0_C1.setToolTipText("0,0");

        Pe_F1_C1.setToolTipText("1,0");

        Pe_F2_C1.setToolTipText("2,0");

        Pe_F6_C1.setToolTipText("6,0");

        Pe_F3_C1.setToolTipText("3,0");

        Pe_F1_C2.setToolTipText("1,0");

        Pe_F3_C2.setToolTipText("3,0");

        Pe_F6_C2.setToolTipText("6,0");

        Pe_F0_C2.setToolTipText("0,0");

        Pe_F2_C2.setToolTipText("2,0");

        Pe_F4_C2.setToolTipText("4,0");

        Pe_F5_C2.setToolTipText("5,0");

        Pe_F6_C3.setToolTipText("6,0");

        Pe_F5_C3.setToolTipText("5,0");

        Pe_F0_C3.setToolTipText("0,0");

        Pe_F4_C3.setToolTipText("4,0");

        Pe_F3_C3.setToolTipText("3,0");

        Pe_F2_C3.setToolTipText("2,0");

        Pe_F1_C3.setToolTipText("1,0");

        Pe_F6_C4.setToolTipText("6,0");

        Pe_F4_C4.setToolTipText("4,0");

        Pe_F0_C4.setToolTipText("0,0");

        Pe_F1_C4.setToolTipText("1,0");

        Pe_F2_C4.setToolTipText("2,0");

        Pe_F5_C4.setToolTipText("5,0");

        Pe_F3_C4.setToolTipText("3,0");

        Pe_F6_C5.setToolTipText("6,0");

        Pe_F2_C5.setToolTipText("2,0");

        Pe_F0_C5.setToolTipText("0,0");

        Pe_F4_C5.setToolTipText("4,0");

        Pe_F5_C5.setToolTipText("5,0");

        Pe_F3_C5.setToolTipText("3,0");

        Pe_F1_C5.setToolTipText("1,0");

        Pe_F6_C6.setToolTipText("6,0");

        Pe_F0_C6.setToolTipText("0,0");

        Pe_F3_C6.setToolTipText("3,0");

        Pe_F2_C6.setToolTipText("2,0");

        Pe_F4_C6.setToolTipText("4,0");

        Pe_F1_C6.setToolTipText("1,0");

        Pe_F5_C6.setToolTipText("5,0");

        javax.swing.GroupLayout P_Container_Patron1Layout = new javax.swing.GroupLayout(P_Container_Patron1);
        P_Container_Patron1.setLayout(P_Container_Patron1Layout);
        P_Container_Patron1Layout.setHorizontalGroup(
            P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pe_F0_C0)
                    .addComponent(Pe_F1_C0)
                    .addComponent(Pe_F2_C0)
                    .addComponent(Pe_F3_C0)
                    .addComponent(Pe_F4_C0)
                    .addComponent(Pe_F5_C0)
                    .addComponent(Pe_F6_C0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pe_F0_C1)
                    .addComponent(Pe_F1_C1)
                    .addComponent(Pe_F2_C1)
                    .addComponent(Pe_F3_C1)
                    .addComponent(Pe_F4_C1)
                    .addComponent(Pe_F5_C1)
                    .addComponent(Pe_F6_C1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pe_F0_C2)
                    .addComponent(Pe_F1_C2)
                    .addComponent(Pe_F2_C2)
                    .addComponent(Pe_F3_C2)
                    .addComponent(Pe_F4_C2)
                    .addComponent(Pe_F5_C2)
                    .addComponent(Pe_F6_C2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pe_F0_C3)
                    .addComponent(Pe_F1_C3)
                    .addComponent(Pe_F2_C3)
                    .addComponent(Pe_F3_C3)
                    .addComponent(Pe_F4_C3)
                    .addComponent(Pe_F5_C3)
                    .addComponent(Pe_F6_C3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pe_F0_C4)
                    .addComponent(Pe_F1_C4)
                    .addComponent(Pe_F2_C4)
                    .addComponent(Pe_F3_C4)
                    .addComponent(Pe_F4_C4)
                    .addComponent(Pe_F5_C4)
                    .addComponent(Pe_F6_C4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pe_F0_C5)
                    .addComponent(Pe_F1_C5)
                    .addComponent(Pe_F2_C5)
                    .addComponent(Pe_F3_C5)
                    .addComponent(Pe_F4_C5)
                    .addComponent(Pe_F5_C5)
                    .addComponent(Pe_F6_C5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pe_F0_C6)
                    .addComponent(Pe_F1_C6)
                    .addComponent(Pe_F2_C6)
                    .addComponent(Pe_F3_C6)
                    .addComponent(Pe_F4_C6)
                    .addComponent(Pe_F5_C6)
                    .addComponent(Pe_F6_C6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        P_Container_Patron1Layout.setVerticalGroup(
            P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_Container_Patron1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                        .addComponent(Pe_F0_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F1_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F2_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F3_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F4_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F5_C6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F6_C6))
                    .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                        .addComponent(Pe_F0_C5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F1_C5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F2_C5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F3_C5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F4_C5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F5_C5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F6_C5))
                    .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                        .addComponent(Pe_F0_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F1_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F2_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F3_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F4_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F5_C4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F6_C4))
                    .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                        .addComponent(Pe_F0_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F1_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F2_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F3_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F4_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F5_C3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F6_C3))
                    .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                        .addComponent(Pe_F0_C2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F1_C2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F2_C2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F3_C2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F4_C2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F5_C2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F6_C2))
                    .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                        .addComponent(Pe_F0_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F1_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F2_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F3_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F4_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F5_C1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F6_C1))
                    .addGroup(P_Container_Patron1Layout.createSequentialGroup()
                        .addComponent(Pe_F0_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F1_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F2_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F3_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F4_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F5_C0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pe_F6_C0)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Algorimo"));
        jPanel1.setToolTipText("Seleccione tipo de Algoritmo a utilizar");

        GrpRbtn_TypeAlgorithm.add(rBtn_NNH);
        rBtn_NNH.setSelected(true);
        rBtn_NNH.setText("Hopfield");

        GrpRbtn_TypeAlgorithm.add(rBtn_NNHGA);
        rBtn_NNHGA.setText("NNH-GA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rBtn_NNH)
                    .addComponent(rBtn_NNHGA))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rBtn_NNH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rBtn_NNHGA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Aciones"));
        jPanel3.setToolTipText("Acciones posibles");

        Btn_Start.setText("Empezar");
        Btn_Start.setToolTipText("Inicia proceso");
        Btn_Start.setEnabled(false);
        Btn_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_StartActionPerformed(evt);
            }
        });

        Btn_Entrenar.setText("Entrenar");
        Btn_Entrenar.setToolTipText("Crea la matriz de entrenamiento");
        Btn_Entrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EntrenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btn_Entrenar)
                .addGap(18, 18, 18)
                .addComponent(Btn_Start)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Start)
                    .addComponent(Btn_Entrenar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Patron de salida"));
        jPanel4.setToolTipText("Patron de Salida");

        TxtA_Ps.setColumns(20);
        TxtA_Ps.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        TxtA_Ps.setRows(5);
        TxtA_Ps.setToolTipText("Patron al cual se asemenja el Pantron de entrada");
        jScrollPane4.setViewportView(TxtA_Ps);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Matriz de pesos"));
        jPanel2.setToolTipText("Acciones sobre la interfaz Matriz");

        Btn_ShowMatriz.setText("Mostrar");
        Btn_ShowMatriz.setToolTipText("Muestra/Oculta Matriz");
        Btn_ShowMatriz.setActionCommand("");
        Btn_ShowMatriz.setEnabled(false);
        Btn_ShowMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ShowMatrizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btn_ShowMatriz)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btn_ShowMatriz)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout P_MainLayout = new javax.swing.GroupLayout(P_Main);
        P_Main.setLayout(P_MainLayout);
        P_MainLayout.setHorizontalGroup(
            P_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P_Container_Patron1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(P_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_MainLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        P_MainLayout.setVerticalGroup(
            P_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_MainLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(P_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(P_Container_Patron1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TPT.addTab("Main", P_Main);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TPT)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TPT, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_EntrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EntrenarActionPerformed
        this.getPatronE();
        this.showPatronE();
        this.Btn_Entrenar.setEnabled(false);
        this.Btn_ShowMatriz.setEnabled(true);
        this.Btn_Start.setEnabled(true);
    }//GEN-LAST:event_Btn_EntrenarActionPerformed

    private void Btn_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_StartActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Empieza el Algoritmo", "Confirmacion", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_Btn_StartActionPerformed

    private void Btn_LimpiarPatronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LimpiarPatronActionPerformed
        this.clearPatron();
    }//GEN-LAST:event_Btn_LimpiarPatronActionPerformed

    private void Btn_ReadPatronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ReadPatronActionPerformed
        if (!TxF_Descripcion.getText().isEmpty())
        {
            this.getPatron();
            this.showPatron();
            this.addPatronTable();
            JOptionPane.showMessageDialog(rootPane, "Patron Agragdo", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Falta Agregar una descripcion", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Btn_ReadPatronActionPerformed

    i_MP iMP = new i_MP();
    private void Btn_ShowMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ShowMatrizActionPerformed
        iMP.setMatriz("Hola");
        if(!iMP.isVisible())
        {
            iMP.setVisible(true);
            Btn_ShowMatriz.setText("Ocultar");
        }
        else
        {
            iMP.setVisible(false);
            Btn_ShowMatriz.setText("Mostrar");
        }
        
    }//GEN-LAST:event_Btn_ShowMatrizActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_DeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_Entrenar;
    private javax.swing.JButton Btn_LimpiarPatron;
    private javax.swing.JButton Btn_ReadPatron;
    private javax.swing.JButton Btn_ShowMatriz;
    private javax.swing.JButton Btn_Start;
    private javax.swing.JComboBox<String> Cbx_Delete;
    private javax.swing.ButtonGroup GrpRbtn_TypeAlgorithm;
    private javax.swing.JPanel P_Container_Acciones_Desc;
    private javax.swing.JPanel P_Container_Acciones_Leer;
    private javax.swing.JPanel P_Container_Patron;
    private javax.swing.JPanel P_Container_Patron1;
    private javax.swing.JPanel P_Delete;
    private javax.swing.JPanel P_Escribir;
    private javax.swing.JPanel P_Leer;
    private javax.swing.JPanel P_Main;
    private javax.swing.JRadioButton Pe_F0_C0;
    private javax.swing.JRadioButton Pe_F0_C1;
    private javax.swing.JRadioButton Pe_F0_C2;
    private javax.swing.JRadioButton Pe_F0_C3;
    private javax.swing.JRadioButton Pe_F0_C4;
    private javax.swing.JRadioButton Pe_F0_C5;
    private javax.swing.JRadioButton Pe_F0_C6;
    private javax.swing.JRadioButton Pe_F1_C0;
    private javax.swing.JRadioButton Pe_F1_C1;
    private javax.swing.JRadioButton Pe_F1_C2;
    private javax.swing.JRadioButton Pe_F1_C3;
    private javax.swing.JRadioButton Pe_F1_C4;
    private javax.swing.JRadioButton Pe_F1_C5;
    private javax.swing.JRadioButton Pe_F1_C6;
    private javax.swing.JRadioButton Pe_F2_C0;
    private javax.swing.JRadioButton Pe_F2_C1;
    private javax.swing.JRadioButton Pe_F2_C2;
    private javax.swing.JRadioButton Pe_F2_C3;
    private javax.swing.JRadioButton Pe_F2_C4;
    private javax.swing.JRadioButton Pe_F2_C5;
    private javax.swing.JRadioButton Pe_F2_C6;
    private javax.swing.JRadioButton Pe_F3_C0;
    private javax.swing.JRadioButton Pe_F3_C1;
    private javax.swing.JRadioButton Pe_F3_C2;
    private javax.swing.JRadioButton Pe_F3_C3;
    private javax.swing.JRadioButton Pe_F3_C4;
    private javax.swing.JRadioButton Pe_F3_C5;
    private javax.swing.JRadioButton Pe_F3_C6;
    private javax.swing.JRadioButton Pe_F4_C0;
    private javax.swing.JRadioButton Pe_F4_C1;
    private javax.swing.JRadioButton Pe_F4_C2;
    private javax.swing.JRadioButton Pe_F4_C3;
    private javax.swing.JRadioButton Pe_F4_C4;
    private javax.swing.JRadioButton Pe_F4_C5;
    private javax.swing.JRadioButton Pe_F4_C6;
    private javax.swing.JRadioButton Pe_F5_C0;
    private javax.swing.JRadioButton Pe_F5_C1;
    private javax.swing.JRadioButton Pe_F5_C2;
    private javax.swing.JRadioButton Pe_F5_C3;
    private javax.swing.JRadioButton Pe_F5_C4;
    private javax.swing.JRadioButton Pe_F5_C5;
    private javax.swing.JRadioButton Pe_F5_C6;
    private javax.swing.JRadioButton Pe_F6_C0;
    private javax.swing.JRadioButton Pe_F6_C1;
    private javax.swing.JRadioButton Pe_F6_C2;
    private javax.swing.JRadioButton Pe_F6_C3;
    private javax.swing.JRadioButton Pe_F6_C4;
    private javax.swing.JRadioButton Pe_F6_C5;
    private javax.swing.JRadioButton Pe_F6_C6;
    private javax.swing.JRadioButton Pen_F0_C0;
    private javax.swing.JRadioButton Pen_F0_C1;
    private javax.swing.JRadioButton Pen_F0_C2;
    private javax.swing.JRadioButton Pen_F0_C3;
    private javax.swing.JRadioButton Pen_F0_C4;
    private javax.swing.JRadioButton Pen_F0_C5;
    private javax.swing.JRadioButton Pen_F0_C6;
    private javax.swing.JRadioButton Pen_F1_C0;
    private javax.swing.JRadioButton Pen_F1_C1;
    private javax.swing.JRadioButton Pen_F1_C2;
    private javax.swing.JRadioButton Pen_F1_C3;
    private javax.swing.JRadioButton Pen_F1_C4;
    private javax.swing.JRadioButton Pen_F1_C5;
    private javax.swing.JRadioButton Pen_F1_C6;
    private javax.swing.JRadioButton Pen_F2_C0;
    private javax.swing.JRadioButton Pen_F2_C1;
    private javax.swing.JRadioButton Pen_F2_C2;
    private javax.swing.JRadioButton Pen_F2_C3;
    private javax.swing.JRadioButton Pen_F2_C4;
    private javax.swing.JRadioButton Pen_F2_C5;
    private javax.swing.JRadioButton Pen_F2_C6;
    private javax.swing.JRadioButton Pen_F3_C0;
    private javax.swing.JRadioButton Pen_F3_C1;
    private javax.swing.JRadioButton Pen_F3_C2;
    private javax.swing.JRadioButton Pen_F3_C3;
    private javax.swing.JRadioButton Pen_F3_C4;
    private javax.swing.JRadioButton Pen_F3_C5;
    private javax.swing.JRadioButton Pen_F3_C6;
    private javax.swing.JRadioButton Pen_F4_C0;
    private javax.swing.JRadioButton Pen_F4_C1;
    private javax.swing.JRadioButton Pen_F4_C2;
    private javax.swing.JRadioButton Pen_F4_C3;
    private javax.swing.JRadioButton Pen_F4_C4;
    private javax.swing.JRadioButton Pen_F4_C5;
    private javax.swing.JRadioButton Pen_F4_C6;
    private javax.swing.JRadioButton Pen_F5_C0;
    private javax.swing.JRadioButton Pen_F5_C1;
    private javax.swing.JRadioButton Pen_F5_C2;
    private javax.swing.JRadioButton Pen_F5_C3;
    private javax.swing.JRadioButton Pen_F5_C4;
    private javax.swing.JRadioButton Pen_F5_C5;
    private javax.swing.JRadioButton Pen_F5_C6;
    private javax.swing.JRadioButton Pen_F6_C0;
    private javax.swing.JRadioButton Pen_F6_C1;
    private javax.swing.JRadioButton Pen_F6_C2;
    private javax.swing.JRadioButton Pen_F6_C3;
    private javax.swing.JRadioButton Pen_F6_C4;
    private javax.swing.JRadioButton Pen_F6_C5;
    private javax.swing.JRadioButton Pen_F6_C6;
    private javax.swing.JTabbedPane TPT;
    private javax.swing.JTable Table_Leer;
    private javax.swing.JTextField TxF_Descripcion;
    private javax.swing.JTextArea TxtA_Ps;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rBtn_NNH;
    private javax.swing.JRadioButton rBtn_NNHGA;
    // End of variables declaration//GEN-END:variables

    

}
