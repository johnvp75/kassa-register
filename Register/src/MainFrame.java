import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import kassa.Fprn;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Евгений
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        payment = new javax.swing.JButton();
        openSession = new javax.swing.JButton();
        closeSession = new javax.swing.JButton();
        cashIncome = new javax.swing.JButton();
        cashOutcome = new javax.swing.JButton();
        reportWithoutClosing = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        summInCase = new javax.swing.JLabel();
        settings = new javax.swing.JButton();
        testBox = new javax.swing.JCheckBox();
        OpenBox = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        title.setFont(new java.awt.Font("Tahoma", 1, 14));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("jLabel1");

        payment.setText("Оплата");
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        openSession.setText("Открыть смену");
        openSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSessionActionPerformed(evt);
            }
        });

        closeSession.setText("Закрыть смену (Z)");
        closeSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeSessionActionPerformed(evt);
            }
        });

        cashIncome.setText("Ввод денег");
        cashIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashIncomeActionPerformed(evt);
            }
        });

        cashOutcome.setText("Вывод денег");
        cashOutcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashOutcomeActionPerformed(evt);
            }
        });

        reportWithoutClosing.setText("Отчет без закрытия");
        reportWithoutClosing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportWithoutClosingActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Сумма в кассе");

        summInCase.setFont(new java.awt.Font("Tahoma", 1, 12));
        summInCase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        summInCase.setText("jLabel3");

        settings.setText("Настройки ККМ");
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        testBox.setText("Тестирование");
        testBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testBoxActionPerformed(evt);
            }
        });

        OpenBox.setText("Открыть ящик");
        OpenBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(settings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OpenBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cashOutcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cashIncome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeSession, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openSession, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(payment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportWithoutClosing, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(summInCase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)))
                .addGap(48, 48, 48)
                .addComponent(testBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payment)
                    .addComponent(testBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openSession)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closeSession)
                .addGap(11, 11, 11)
                .addComponent(cashIncome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cashOutcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportWithoutClosing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OpenBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(settings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(summInCase)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSessionActionPerformed
        if (fprn.openDay(isTest())){
            openSession.setEnabled(false);
            payment.setEnabled(true);
            closeSession.setEnabled(!isTest());
            cashIncome.setEnabled(true);
            cashOutcome.setEnabled(true);
            reportWithoutClosing.setEnabled(true);
        }
    }//GEN-LAST:event_openSessionActionPerformed

    private void reportWithoutClosingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportWithoutClosingActionPerformed
        fprn.printReportWithoutClosing();
    }//GEN-LAST:event_reportWithoutClosingActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        fprn=new Fprn();
        setSumm();
        title.setText(String.format("%1$td.%1$tm.%1$tY", new GregorianCalendar()));
        boolean opened=fprn.isSessionOpened();
        openSession.setEnabled(!opened);
        payment.setEnabled(opened);
        closeSession.setEnabled(opened);
        cashIncome.setEnabled(opened);
        cashOutcome.setEnabled(opened);
        reportWithoutClosing.setEnabled(opened);
    }//GEN-LAST:event_formWindowOpened

    private void closeSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeSessionActionPerformed
        if (fprn.closeDay()){
            openSession.setEnabled(true);
            payment.setEnabled(false);
            closeSession.setEnabled(false);
            cashIncome.setEnabled(false);
            cashOutcome.setEnabled(false);
            reportWithoutClosing.setEnabled(false);
        }
    }//GEN-LAST:event_closeSessionActionPerformed

    private void testBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testBoxActionPerformed
        setTest(testBox.isSelected());
        if (isTest()){
            closeSession.setEnabled(false);
            reportWithoutClosing.setEnabled(false);
        }else{
            boolean opened=fprn.isSessionOpened();
            openSession.setEnabled(!opened);
            payment.setEnabled(opened);
            closeSession.setEnabled(opened);
            cashIncome.setEnabled(opened);
            cashOutcome.setEnabled(opened);
            reportWithoutClosing.setEnabled(opened);
        }
    }//GEN-LAST:event_testBoxActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        if (form==null)
            form=new PrintCheck(null,true,fprn);
        form.setTest(isTest());
        form.setVisible(true);
        setSumm();
    }//GEN-LAST:event_paymentActionPerformed

    private void cashIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashIncomeActionPerformed
        String inSumm="";
        Double incomeCash=-1.00;
        while (inSumm!=null&&incomeCash<0){
            inSumm=JOptionPane.showInputDialog(null, "Введите вносимую сумму в рублях", "0.00");
            try{
                incomeCash=new Double(inSumm.replace(',', '.'));
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Необходимо ввести число в формате 99999.99", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
 //           catch(NullPointerException ex1){
                
 //           }
            //
        }
        if (incomeCash<=0)
            return;
        fprn.cashIncome(incomeCash, isTest());
        setSumm();
    }//GEN-LAST:event_cashIncomeActionPerformed

    private void cashOutcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashOutcomeActionPerformed
        String outSumm="";
        Double outcomeCash=-1.00;
        while (outSumm!=null&&outcomeCash<0){
            outSumm=JOptionPane.showInputDialog(null, "Введите выводимую сумму в рублях", "0.00");
            try{
                outcomeCash=new Double(outSumm.replace(',', '.'));
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Необходимо ввести число в формате 99999.99", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (outcomeCash<=0)
            return;
        fprn.cashIncome(outcomeCash, isTest());
        setSumm();
    }//GEN-LAST:event_cashOutcomeActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        fprn.showProperties();
    }//GEN-LAST:event_settingsActionPerformed

    private void OpenBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenBoxActionPerformed
        fprn.openCashBox();
    }//GEN-LAST:event_OpenBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OpenBox;
    private javax.swing.JButton cashIncome;
    private javax.swing.JButton cashOutcome;
    private javax.swing.JButton closeSession;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton openSession;
    private javax.swing.JButton payment;
    private javax.swing.JButton reportWithoutClosing;
    private javax.swing.JButton settings;
    private javax.swing.JLabel summInCase;
    private javax.swing.JCheckBox testBox;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    private boolean test=false;
    private Fprn fprn;
    private PrintCheck form;


    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
    private void setSumm(){
        fprn.getSumm();
        summInCase.setText(String.format("%.2f руб.", fprn.getCurrentSumm()));
    }
}

