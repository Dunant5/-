/*
 * Created by JFormDesigner on Sun Apr 12 11:45:38 CST 2020
 */

package view;

import dao.UserDao;
import model.User;
import util.Connect;
import util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author dunant
 */
public class LogOnFrm extends JFrame {

    public LogOnFrm() {
        initComponents();
    }

    /**
     * 重置操作
     * @param e
     */
        private void button2ActionPerformed (ActionEvent e){
        resetValueActionPerformed(e);
    }

        private void resetValueActionPerformed (ActionEvent evt){
        this.nameTxt.setText("");
        this.passwordTxt.setText("");
    }

    /**
     * 登录操作
     * @param e
     */
        private void button1ActionPerformed (ActionEvent e){
        loginActionPerformed(e);
    }

        private void loginActionPerformed (ActionEvent evt){
        String userName = this.nameTxt.getText();
        char[] password = this.passwordTxt.getPassword();
        if (StringUtil.isEmpty(userName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (StringUtil.isEmmpty(password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        User user=new User(userName,password);
            Connection con=null;
            try {
                con=connect.getCon();
                User currentUser=dao.login(con,user);
                if(currentUser!=null){
                    JOptionPane.showMessageDialog(null, "登陆成功");
                }else{
                    JOptionPane.showMessageDialog(null, "用户名或者密码错误");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void initComponents () {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - dunant
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        nameTxt = new JTextField();
        passwordTxt = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("WE\u5e7f\u5de5\u996d\u5802\u5916\u5356");
        label1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 25));
        label1.setForeground(Color.red);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));

        //---- label3 ----
        label3.setText("\u5bc6  \u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(118, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                    .addGap(39, 39, 39)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                            .addGap(106, 106, 106))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - dunant
        private JLabel label1;
        private JLabel label2;
        private JLabel label3;
        private JTextField nameTxt;
        private JPasswordField passwordTxt;
        private JButton button1;
        private JButton button2;

        private Connect connect=new Connect();
        private UserDao dao=new UserDao();
        // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new LogOnFrm().setVisible(true);
    }

}
