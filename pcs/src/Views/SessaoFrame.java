/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import BDConexao.criaConexao;
import java.util.List;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pcs.Questao;

/**
 *
 * @author aline
 */
public class SessaoFrame extends javax.swing.JFrame {
    Connection conn = new criaConexao().connect();
    /**
     * Creates new form SessaoFrame
     */
    int idaluno;
    public void getid (int id){
        idaluno = id;
    }
    
    public SessaoFrame() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        comboQuantidade = new javax.swing.JComboBox();
        comboNivel = new javax.swing.JComboBox();
        BotaoIniciar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo de Questao");

        jLabel2.setText("Quantidade");

        jLabel3.setText("Nível");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Potenciação", "Radiciação" }));

        comboQuantidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20" }));

        comboNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fácil", "Médio", "Difícil" }));

        BotaoIniciar.setText("Iniciar");
        BotaoIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoIniciarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboTipo, 0, 143, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoIniciar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboNivel, 0, 143, Short.MAX_VALUE)
                            .addComponent(comboQuantidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoIniciar)
                    .addComponent(botaoVoltar))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
            AlunoFrame mm = new AlunoFrame();
                mm.show();
                mm.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void BotaoIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoIniciarActionPerformed
    String sql = "select * from questao where tipoquestao=? and nivel=? order by rand() limit ?";
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setInt(1, comboTipo.getSelectedIndex());
            ps.setInt(2, comboNivel.getSelectedIndex());
            ps.setInt(3, Integer.parseInt((String)comboQuantidade.getSelectedItem()));
            ResultSet rs = ps.executeQuery();
            List<Questao> questoes = new ArrayList<Questao>();
            
            while (rs.next()){
                Questao questao = new Questao(rs.getInt("idquestao"),rs.getInt("tipoquestao"),rs.getInt("nivel"),rs.getInt("indiceresposta"),rs.getString("pergunta"),rs.getString("resposta1"),rs.getString("resposta2"),rs.getString("resposta3"),rs.getString("resposta4"),rs.getString("resolucao"));
                questoes.add(questao);
                
            }
            
            String sqlinsertesessao = "insert into sessao (id_pessoa, data_inicio, tipoquestao, nivel)"
                + "values(?,?,?,?)";
            
                Date hoje = new Date(); 
                java.sql.Date hojesql = new java.sql.Date(hoje.getTime());
                ps = conn.prepareStatement(sqlinsertesessao, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, idaluno);
                ps.setDate(2, hojesql);
                ps.setInt(3, comboTipo.getSelectedIndex());
                ps.setInt(4, comboNivel.getSelectedIndex());
                ps.executeUpdate();
                rs =  ps.getGeneratedKeys();
                rs.next();
                int idsessao = rs.getInt(1);
                
                System.out.println("idsessao: " + idsessao);
                   
            this.setVisible(false);
            Sessao2Frame mm = new Sessao2Frame();
            mm.iniciajanela(0, questoes.size(), idsessao, idaluno, questoes,0);
            mm.setLocationRelativeTo(null);
        }
            
        
        catch (Exception e){
        System.out.println(e.getMessage());
        
        }       
    }//GEN-LAST:event_BotaoIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(SessaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SessaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SessaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SessaoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SessaoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoIniciar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox comboNivel;
    private javax.swing.JComboBox comboQuantidade;
    public static javax.swing.JComboBox comboTipo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
