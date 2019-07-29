import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.event.*;
import javax.swing.ImageIcon;

public class MainWindow extends Template implements ActionListener
{
    public JButton Pack_Btn,UnPack_Btn;

    public MainWindow(String Uname)
    {
        _TopLabel.setText("Welcome:"+Uname);

        Pack_Btn=new JButton(new ImageIcon("Pack1.jpg"));
        Pack_Btn.setBounds(50, 100, 100, 75);
        Pack_Btn.setBackground(Color.WHITE);
        Pack_Btn.setToolTipText("Pack Button");
        Pack_Btn.setVisible(true);
        Pack_Btn.addActionListener(this);
        Pack_Btn.setEnabled(true);
        _UIPanel.add(Pack_Btn);
    
        UnPack_Btn=new JButton(new ImageIcon("UnPack.png"));
        UnPack_Btn.setBounds(250, 100, 100, 75);
        UnPack_Btn.setBackground(Color.WHITE);
        UnPack_Btn.setToolTipText("UnPack Button");
        UnPack_Btn.addActionListener(this);
        UnPack_Btn.setVisible(true);
        UnPack_Btn.setEnabled(true);
        _UIPanel.add(UnPack_Btn);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==Pack_Btn)
        {
            this.dispose();
            PackWindow pobj=new PackWindow();
        }
        if(ae.getSource()==UnPack_Btn)
        {
            this.dispose();
            UnPackWindow upobj=new UnPackWindow();
        }
    }
}