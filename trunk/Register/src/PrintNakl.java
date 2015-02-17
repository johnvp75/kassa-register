
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import kassa.Fprn;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PrintNakl.java
 *
 * Created on 19 квіт 2011, 9:46:49
 */

/**
 *
 * @author Admin
 */
public class PrintNakl extends javax.swing.JDialog {

    private Fprn fprinter;
    
    
    /** Creates new form PrintNakl */
    public PrintNakl (java.awt.Frame parent, boolean modal,Fprn afprinter) {
        super(parent, modal);
        fprinter=afprinter;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        docDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientList = new javax.swing.JList();
        docPane = new javax.swing.JScrollPane();
        cancelButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        docDate.setDateFormatString("dd.MM.yyyy");
        docDate.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                docDateInputMethodTextChanged(evt);
            }
        });
        docDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                docDatePropertyChange(evt);
            }
        });

        jLabel1.setText("Дата");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Клиент:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Накладные:");

        clientList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientListMouseClicked(evt);
            }
        });
        clientList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                clientListValueChanged(evt);
            }
        });
        clientList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                clientListPropertyChange(evt);
            }
        });
        clientList.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                clientListVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(clientList);

        cancelButton.setText("Закрыть");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Напечатать чек");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel2)
                        .addGap(269, 269, 269)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(docDate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(docPane, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton1)
                        .addGap(69, 69, 69)
                        .addComponent(cancelButton)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(docDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docPane, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(jButton1))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        docDate.setDate(new GregorianCalendar().getTime());
        AbstractListModel clmodel;
        final Vector<String> clients =new Vector<String>();
        try{
            String Sql=String.format("select distinct trim(c.name) from client c, document d where to_char(d.day,'dd.mm.yyyy')='%1$td.%1$tm.%1$tY' and " +
                    " d.id_type_doc=2 and c.id_client=d.id_client and c.type=1 order by trim(c.name)", docDate.getDate());
            ResultSet rs=DataSet.QueryExec(Sql, false);
            while (rs.next())
                clients.add(rs.getString(1));
            clmodel=new AbstractListModel() {
            public int getSize() { return clients.size(); }
            public Object getElementAt(int i) { return clients.elementAt(i); }
            };
            clientList.setModel(clmodel);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_formComponentShown

    private void clientListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientListMouseClicked
        clientChoose();
    }//GEN-LAST:event_clientListMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void docDateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_docDateInputMethodTextChanged

    }//GEN-LAST:event_docDateInputMethodTextChanged

    private void docDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_docDatePropertyChange
        AbstractListModel clmodel;
        final Vector<String> clients =new Vector<String>();
        try{
            String Sql=String.format("select distinct trim(c.name) from client c, document d where to_char(d.day,'dd.mm.yyyy')='%1$td.%1$tm.%1$tY' and " +
                    " d.id_type_doc=2 and c.id_client=d.id_client and c.type=1 order by trim(c.name)", docDate.getDate());
            ResultSet rs=DataSet.QueryExec(Sql, false);
            while (rs.next())
                clients.add(rs.getString(1));
            clmodel=new AbstractListModel() {
            public int getSize() { return clients.size(); }
            public Object getElementAt(int i) { return clients.elementAt(i); }
            };
            clientList.setModel(clmodel);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_docDatePropertyChange

    private void clientListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_clientListPropertyChange
        
    }//GEN-LAST:event_clientListPropertyChange

    private void clientListVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_clientListVetoableChange
        
    }//GEN-LAST:event_clientListVetoableChange

    private void clientListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_clientListValueChanged
        clientChoose();
    }//GEN-LAST:event_clientListValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String numbs="";
        int count=((JPanel)docPane.getViewport().getView()).getComponentCount();
        for (int i=0;i<count;i++){
            JCheckBox check=(JCheckBox)((JPanel)docPane.getViewport().getView()).getComponent(i);
            if (check.isSelected())
                numbs=numbs+check.getText().substring(0, check.getText().indexOf(" "))+", ";
        }
        numbs=numbs.substring(0, numbs.lastIndexOf(", "));
        String Sql=String.format("select trim(t.name), l.kol, l.cost*(1-l.disc/100)*cn.curs,d.disc from document d, lines l, curs_now cn, tovar t " +
                "where d.numb in (%1$s) and to_char(d.day,'dd.mm.yyyy')='%2$td.%2$tm.%2$tY' " +
                    "and d.id_client=(select id_client from client where name='%3$s') and d.id_type_doc=2 and cn.id_val=d.id_val and t.id_tovar=l.id_tovar and d.id_doc=l.id_doc", numbs, docDate.getDate(),getClName());
        try{
            ResultSet rs =DataSet.QueryExec(Sql, false);
            if (fprinter.openCheck(1)){
                while (rs.next()){
                    if (!fprinter.insertLine(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4))){
                        return ;
                    }
                }
                fprinter.closeCheck();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private String Month(int aValue){
	switch (aValue+1){
	case 1:return "января";
	case 2:return "февраля";
	case 3:return "марта";
	case 4:return "апреля";
	case 5:return "мая";
	case 6:return "июня";
	case 7:return "июля";
	case 8:return "августа";
	case 9:return "сентября";
	case 10:return "октября";
	case 11:return "ноября";
	case 12:return "декабря";
	default: return "";
	}
    }

    private void clientChoose(){
        if (clientList.getSelectedIndex()==-1)
            return;
        try {
            setClName((String)clientList.getSelectedValue());
            String Sql=String.format("select d.numb, d.sum from document d where to_char(d.day,'dd.mm.yyyy')='%1$td.%1$tm.%1$tY' " +
                    "and d.id_client=(select id_client from client where name='%2$s') and d.id_type_doc=2 order by d.numb", docDate.getDate(),getClName());
            ResultSet rs=DataSet.QueryExec(Sql, false);
            JPanel p =new JPanel();
            int i=0;
            while (rs.next()){
                p.add(new JCheckBox(rs.getString(1)+" на сумму: "+rs.getString(2)));
                i++;
            }
            p.setLayout(new GridLayout(i>9?i:9, 1));
            docPane.setViewportView(p);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JList clientList;
    private com.toedter.calendar.JDateChooser docDate;
    private javax.swing.JScrollPane docPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    protected String clName;

    public String getClName() {
        return clName;
    }

    public void setClName(String clName) {
        this.clName = clName;
    }

}
