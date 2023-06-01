/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dashboard;

import classes.Main;
import classes.Configuracion;
import static classes.Main.RollsPlant;
import classes.VehiclePlant;

/**
 *
 * @author mannith
 */
public class Dashboard extends javax.swing.JFrame {
    /**
     * Creates new form Dashboard
     */
    int[] valoresIniciales =  Configuracion.leerDatosIniciales();
    Configuracion configLambo = new Configuracion();
    public Dashboard() {
        initComponents();
        configLambo.leerConfiguracion("src//classes//configuracionLambo.txt");
        RollsPlant = new VehiclePlant("RollsRoyce", 19, valoresIniciales[0], valoresIniciales[1], false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        qtyWChasis = new javax.swing.JSpinner();
        workerChasis = new javax.swing.JLabel();
        workerCarroceria = new javax.swing.JLabel();
        workerMotor = new javax.swing.JLabel();
        workerRuedas = new javax.swing.JLabel();
        workerAcc = new javax.swing.JLabel();
        workerEnsamblador = new javax.swing.JLabel();
        startPlant = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        qtyAcc = new javax.swing.JTextField();
        qtyChasis = new javax.swing.JTextField();
        qtyCarroceria = new javax.swing.JTextField();
        qtyMotores = new javax.swing.JTextField();
        qtyCarrosProducidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        qtyRuedas1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        qtyCarrosProducidos1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        qtyCarrosProducidos2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        diasTotales = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        sueldoMensual = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        directorAccion = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        gerenteAccion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        ensambladoresWorkers = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        gananciaNeta = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        qtyCarrosProducidos3 = new javax.swing.JTextField();
        restarWChasis = new javax.swing.JButton();
        sumarWChasis = new javax.swing.JButton();
        sumarWCarroceria = new javax.swing.JButton();
        restarWCarroceria = new javax.swing.JButton();
        restarWMotor = new javax.swing.JButton();
        sumarWMotor = new javax.swing.JButton();
        SumarWRuedas = new javax.swing.JButton();
        restarWRuedas = new javax.swing.JButton();
        restarWAcce = new javax.swing.JButton();
        sumarWAcce = new javax.swing.JButton();
        restarWEnsamblador = new javax.swing.JButton();
        sumarWEnsamblador = new javax.swing.JButton();
        empleadosDispo1 = new javax.swing.JTextField();
        chasisWorkers = new javax.swing.JTextField();
        carroceriasWorkers = new javax.swing.JTextField();
        motorWorkers = new javax.swing.JTextField();
        ruedasWorkers = new javax.swing.JTextField();
        accesoriosWorkers = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.JSpinner.DefaultEditor spinnerEditor = (javax.swing.JSpinner.DefaultEditor) qtyWChasis.getEditor();
        spinnerEditor.getTextField().setEditable(false);
        qtyWChasis.setModel(new javax.swing.SpinnerNumberModel(1, null, 14, 1));
        qtyWChasis.setFocusable(false);
        getContentPane().add(qtyWChasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, -1));

        workerChasis.setText("Trabajadores de Chasis:");
        getContentPane().add(workerChasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        workerCarroceria.setText("Trabajadores de Carroceria:");
        getContentPane().add(workerCarroceria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        workerMotor.setText("Trabajadores de Motor:");
        getContentPane().add(workerMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        workerRuedas.setText("Trabajadores de Ruedas:");
        getContentPane().add(workerRuedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        workerAcc.setText("Trabajadores de Accesorios:");
        getContentPane().add(workerAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        workerEnsamblador.setText("Ensambladores:");
        getContentPane().add(workerEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        startPlant.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        startPlant.setText("Iniciar Simulacion");
        startPlant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPlantActionPerformed(evt);
            }
        });
        getContentPane().add(startPlant, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 27, 270, 59));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        jLabel7.setText("Almacen");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 60));

        qtyAcc.setEditable(false);
        qtyAcc.setText("0");
        getContentPane().add(qtyAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 30, -1));

        qtyChasis.setEditable(false);
        qtyChasis.setText("0");
        getContentPane().add(qtyChasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 30, -1));

        qtyCarroceria.setEditable(false);
        qtyCarroceria.setText("0");
        qtyCarroceria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyCarroceriaActionPerformed(evt);
            }
        });
        getContentPane().add(qtyCarroceria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 30, -1));

        qtyMotores.setEditable(false);
        qtyMotores.setText("0");
        getContentPane().add(qtyMotores, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 30, -1));

        qtyCarrosProducidos.setEditable(false);
        qtyCarrosProducidos.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        qtyCarrosProducidos.setText("0");
        getContentPane().add(qtyCarrosProducidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 50, 40));

        jLabel8.setText("Set Accesorios");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, -1, -1));

        jLabel9.setText("Chasis");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel10.setText("Carroceria");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, -1, -1));

        jLabel11.setText("Motores");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        jLabel12.setText("Ruedas");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel13.setText("Carros Vendidos:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        qtyRuedas1.setEditable(false);
        qtyRuedas1.setText("0");
        getContentPane().add(qtyRuedas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 30, -1));

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel14.setText("Dias para la entrega:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, -1));

        qtyCarrosProducidos1.setEditable(false);
        qtyCarrosProducidos1.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        qtyCarrosProducidos1.setText("7");
        qtyCarrosProducidos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyCarrosProducidos1ActionPerformed(evt);
            }
        });
        getContentPane().add(qtyCarrosProducidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 50, 40));

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel15.setText("Carros Producidos:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, -1, -1));

        qtyCarrosProducidos2.setEditable(false);
        qtyCarrosProducidos2.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        qtyCarrosProducidos2.setText("0");
        getContentPane().add(qtyCarrosProducidos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 50, 40));

        jLabel16.setText("Dias Totales:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        diasTotales.setEditable(false);
        diasTotales.setText("0");
        diasTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diasTotalesActionPerformed(evt);
            }
        });
        getContentPane().add(diasTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 30, -1));

        jLabel17.setText("Sueldo Mensual:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        sueldoMensual.setEditable(false);
        sueldoMensual.setText("0");
        sueldoMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sueldoMensualActionPerformed(evt);
            }
        });
        getContentPane().add(sueldoMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 60, -1));

        jLabel18.setFont(new java.awt.Font("Liberation Sans", 2, 30)); // NOI18N
        jLabel18.setText("Planta ###");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jLabel19.setText("Director de la planta esta actualmente:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        directorAccion.setEditable(false);
        directorAccion.setText("Accion");
        directorAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directorAccionActionPerformed(evt);
            }
        });
        getContentPane().add(directorAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 160, -1));

        jLabel20.setText("Gerente de la planta esta actualmente:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, 40));

        gerenteAccion.setEditable(false);
        gerenteAccion.setText("Accion");
        gerenteAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenteAccionActionPerformed(evt);
            }
        });
        getContentPane().add(gerenteAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 160, -1));

        jLabel21.setText("Empleados disponibles");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        ensambladoresWorkers.setEditable(false);
        ensambladoresWorkers.setText("1");
        ensambladoresWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensambladoresWorkersActionPerformed(evt);
            }
        });
        getContentPane().add(ensambladoresWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 30, -1));

        jLabel22.setText("Ganancia neta:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        gananciaNeta.setEditable(false);
        gananciaNeta.setText("0");
        gananciaNeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gananciaNetaActionPerformed(evt);
            }
        });
        getContentPane().add(gananciaNeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 60, -1));

        jLabel23.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel23.setText("Ganancia Total:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        qtyCarrosProducidos3.setEditable(false);
        qtyCarrosProducidos3.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        qtyCarrosProducidos3.setText("0");
        getContentPane().add(qtyCarrosProducidos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 110, 40));

        restarWChasis.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        restarWChasis.setText("↓");
        restarWChasis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restarWChasisActionPerformed(evt);
            }
        });
        getContentPane().add(restarWChasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 40, 10));

        sumarWChasis.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        sumarWChasis.setText("↑");
        sumarWChasis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumarWChasisActionPerformed(evt);
            }
        });
        getContentPane().add(sumarWChasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 40, 10));

        sumarWCarroceria.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        sumarWCarroceria.setText("↑");
        sumarWCarroceria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumarWCarroceriaActionPerformed(evt);
            }
        });
        getContentPane().add(sumarWCarroceria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 40, 10));

        restarWCarroceria.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        restarWCarroceria.setText("↓");
        restarWCarroceria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restarWCarroceriaActionPerformed(evt);
            }
        });
        getContentPane().add(restarWCarroceria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 40, 10));

        restarWMotor.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        restarWMotor.setText("↓");
        restarWMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restarWMotorActionPerformed(evt);
            }
        });
        getContentPane().add(restarWMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 40, 10));

        sumarWMotor.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        sumarWMotor.setText("↑");
        sumarWMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumarWMotorActionPerformed(evt);
            }
        });
        getContentPane().add(sumarWMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 40, 10));

        SumarWRuedas.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        SumarWRuedas.setText("↑");
        SumarWRuedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SumarWRuedasActionPerformed(evt);
            }
        });
        getContentPane().add(SumarWRuedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 40, 10));

        restarWRuedas.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        restarWRuedas.setText("↓");
        restarWRuedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restarWRuedasActionPerformed(evt);
            }
        });
        getContentPane().add(restarWRuedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 40, 10));

        restarWAcce.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        restarWAcce.setText("↓");
        restarWAcce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restarWAcceActionPerformed(evt);
            }
        });
        getContentPane().add(restarWAcce, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 40, 10));

        sumarWAcce.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        sumarWAcce.setText("↑");
        sumarWAcce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumarWAcceActionPerformed(evt);
            }
        });
        getContentPane().add(sumarWAcce, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 40, 10));

        restarWEnsamblador.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        restarWEnsamblador.setText("↓");
        restarWEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restarWEnsambladorActionPerformed(evt);
            }
        });
        getContentPane().add(restarWEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 40, 10));

        sumarWEnsamblador.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        sumarWEnsamblador.setText("↑");
        sumarWEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumarWEnsambladorActionPerformed(evt);
            }
        });
        getContentPane().add(sumarWEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 40, 10));

        empleadosDispo1.setEditable(false);
        empleadosDispo1.setText("0");
        empleadosDispo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadosDispo1ActionPerformed(evt);
            }
        });
        getContentPane().add(empleadosDispo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 30, -1));

        chasisWorkers.setEditable(false);
        chasisWorkers.setText("1");
        chasisWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chasisWorkersActionPerformed(evt);
            }
        });
        getContentPane().add(chasisWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 30, -1));

        carroceriasWorkers.setEditable(false);
        carroceriasWorkers.setText("1");
        carroceriasWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carroceriasWorkersActionPerformed(evt);
            }
        });
        getContentPane().add(carroceriasWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 30, -1));

        motorWorkers.setEditable(false);
        motorWorkers.setText("1");
        motorWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorWorkersActionPerformed(evt);
            }
        });
        getContentPane().add(motorWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 30, -1));

        ruedasWorkers.setEditable(false);
        ruedasWorkers.setText("1");
        ruedasWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruedasWorkersActionPerformed(evt);
            }
        });
        getContentPane().add(ruedasWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 30, -1));

        accesoriosWorkers.setEditable(false);
        accesoriosWorkers.setText("1");
        accesoriosWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accesoriosWorkersActionPerformed(evt);
            }
        });
        getContentPane().add(accesoriosWorkers, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 30, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startPlantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPlantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startPlantActionPerformed

    private void qtyCarroceriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyCarroceriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyCarroceriaActionPerformed

    private void qtyCarrosProducidos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyCarrosProducidos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyCarrosProducidos1ActionPerformed

    private void diasTotalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasTotalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diasTotalesActionPerformed

    private void sueldoMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sueldoMensualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sueldoMensualActionPerformed

    private void directorAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directorAccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_directorAccionActionPerformed

    private void gerenteAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenteAccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gerenteAccionActionPerformed

    private void ensambladoresWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ensambladoresWorkersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ensambladoresWorkersActionPerformed

    private void gananciaNetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gananciaNetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gananciaNetaActionPerformed

    private void restarWChasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restarWChasisActionPerformed
        // TODO add your handling code here:
        configLambo.restarParametro("chasis", 1);
        chasisWorkers.setText(String.valueOf(configLambo.obtenerParametro("chasis")));
//        int [] empleados = configLambo.leerConfiguracion("src//classes//configuracionLambo.txt");
//        RollsPlant.crearWorkers(empleados);
    }//GEN-LAST:event_restarWChasisActionPerformed

    private void sumarWChasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumarWChasisActionPerformed
        // TODO add your handling code here:
        configLambo.sumarParametro("chasis", 1);
//        configLambo.imprimirConfiguracion();
//        configLambo.actualizarConfiguracion("src//classes//configuracionLambo.txt");
        chasisWorkers.setText(String.valueOf(configLambo.obtenerParametro("chasis")));
//        RollsPlant.crearWorkers();
        
//        System.out.println(configLambo.obtenerParametro("chasis"));
        
    }//GEN-LAST:event_sumarWChasisActionPerformed

    private void sumarWCarroceriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumarWCarroceriaActionPerformed
        // TODO add your handling code here:
        configLambo.sumarParametro("carroceria", 1);
        carroceriasWorkers.setText(String.valueOf(configLambo.obtenerParametro("carroceria")));
    }//GEN-LAST:event_sumarWCarroceriaActionPerformed

    private void restarWCarroceriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restarWCarroceriaActionPerformed
        // TODO add your handling code here:
        configLambo.restarParametro("carroceria", 1);
        carroceriasWorkers.setText(String.valueOf(configLambo.obtenerParametro("carroceria")));
    }//GEN-LAST:event_restarWCarroceriaActionPerformed

    private void restarWMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restarWMotorActionPerformed
        // TODO add your handling code here:
        configLambo.restarParametro("motor", 1);
        motorWorkers.setText(String.valueOf(configLambo.obtenerParametro("motor")));
    }//GEN-LAST:event_restarWMotorActionPerformed

    private void sumarWMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumarWMotorActionPerformed
        // TODO add your handling code here:
        configLambo.sumarParametro("motor", 1);
        motorWorkers.setText(String.valueOf(configLambo.obtenerParametro("motor")));
//        int [] empleados = configLambo.leerConfiguracion("src//classes//configuracionLambo.txt");
//        RollsPlant.crearWorkers(empleados);
    }//GEN-LAST:event_sumarWMotorActionPerformed

    private void SumarWRuedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SumarWRuedasActionPerformed
        // TODO add your handling code here:
        configLambo.sumarParametro("ruedas", 1);
        ruedasWorkers.setText(String.valueOf(configLambo.obtenerParametro("ruedas")));
    }//GEN-LAST:event_SumarWRuedasActionPerformed

    private void restarWRuedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restarWRuedasActionPerformed
        // TODO add your handling code here:
        configLambo.restarParametro("ruedas", 1);
        ruedasWorkers.setText(String.valueOf(configLambo.obtenerParametro("ruedas")));
    }//GEN-LAST:event_restarWRuedasActionPerformed

    private void restarWAcceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restarWAcceActionPerformed
        // TODO add your handling code here:
        configLambo.restarParametro("accesorios", 1);
        accesoriosWorkers.setText(String.valueOf(configLambo.obtenerParametro("accesorios")));
    }//GEN-LAST:event_restarWAcceActionPerformed

    private void sumarWAcceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumarWAcceActionPerformed
        // TODO add your handling code here:
        configLambo.sumarParametro("accesorios", 1);
        accesoriosWorkers.setText(String.valueOf(configLambo.obtenerParametro("accesorios")));
    }//GEN-LAST:event_sumarWAcceActionPerformed

    private void restarWEnsambladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restarWEnsambladorActionPerformed
        // TODO add your handling code here:
        configLambo.restarParametro("ensamblador", 1);
        ensambladoresWorkers.setText(String.valueOf(configLambo.obtenerParametro("ensamblador")));
    }//GEN-LAST:event_restarWEnsambladorActionPerformed

    private void sumarWEnsambladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumarWEnsambladorActionPerformed
        // TODO add your handling code here:
        configLambo.sumarParametro("ensamblador", 1);
        ensambladoresWorkers.setText(String.valueOf(configLambo.obtenerParametro("ensamblador")));
    }//GEN-LAST:event_sumarWEnsambladorActionPerformed

    private void empleadosDispo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadosDispo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empleadosDispo1ActionPerformed

    private void chasisWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chasisWorkersActionPerformed
        // TODO add your handling code here:
//        configLambo.imprimirConfiguracion();
//        String chasis = "chasis";
//
//        // Obtener el valor correspondiente utilizando el método obtenerParametro()
//        int valor = configLambo.obtenerParametro(chasis);
//
//        // Establecer el valor en el JTextField
//        chasisWorkers.setText(String.valueOf(configLambo.obtenerParametro("chasis")));
    }//GEN-LAST:event_chasisWorkersActionPerformed

    private void carroceriasWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carroceriasWorkersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carroceriasWorkersActionPerformed

    private void motorWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorWorkersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motorWorkersActionPerformed

    private void ruedasWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruedasWorkersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruedasWorkersActionPerformed

    private void accesoriosWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accesoriosWorkersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accesoriosWorkersActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SumarWRuedas;
    private javax.swing.JTextField accesoriosWorkers;
    private javax.swing.JTextField carroceriasWorkers;
    private javax.swing.JTextField chasisWorkers;
    private javax.swing.JTextField diasTotales;
    private javax.swing.JTextField directorAccion;
    private javax.swing.JTextField empleadosDispo1;
    private javax.swing.JTextField ensambladoresWorkers;
    private javax.swing.JTextField gananciaNeta;
    private javax.swing.JTextField gerenteAccion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField motorWorkers;
    private javax.swing.JTextField qtyAcc;
    private javax.swing.JTextField qtyCarroceria;
    private javax.swing.JTextField qtyCarrosProducidos;
    private javax.swing.JTextField qtyCarrosProducidos1;
    private javax.swing.JTextField qtyCarrosProducidos2;
    private javax.swing.JTextField qtyCarrosProducidos3;
    private javax.swing.JTextField qtyChasis;
    private javax.swing.JTextField qtyMotores;
    private javax.swing.JTextField qtyRuedas1;
    public javax.swing.JSpinner qtyWChasis;
    private javax.swing.JButton restarWAcce;
    private javax.swing.JButton restarWCarroceria;
    private javax.swing.JButton restarWChasis;
    private javax.swing.JButton restarWEnsamblador;
    private javax.swing.JButton restarWMotor;
    private javax.swing.JButton restarWRuedas;
    private javax.swing.JTextField ruedasWorkers;
    private javax.swing.JToggleButton startPlant;
    private javax.swing.JTextField sueldoMensual;
    private javax.swing.JButton sumarWAcce;
    private javax.swing.JButton sumarWCarroceria;
    private javax.swing.JButton sumarWChasis;
    private javax.swing.JButton sumarWEnsamblador;
    private javax.swing.JButton sumarWMotor;
    private javax.swing.JLabel workerAcc;
    private javax.swing.JLabel workerCarroceria;
    private javax.swing.JLabel workerChasis;
    private javax.swing.JLabel workerEnsamblador;
    private javax.swing.JLabel workerMotor;
    private javax.swing.JLabel workerRuedas;
    // End of variables declaration//GEN-END:variables
}
