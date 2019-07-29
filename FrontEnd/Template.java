import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JLabel;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

  
public class Template extends JFrame 
{
    public JPanel _UIPanel,_HeaderPanel,_Footer;
    public JLabel _Label1; 
    public JLabel _TopLabel;
    public JLabel _DateLabel;
    public Date date1;
    public String date;
    protected final int iWidth=400;
    protected final int iHeight=400;
    public static final String USR_NAME="Marvellous";
    public static final String Password="12345";
 
    public Template()
    {
        date1=java.util.Calendar.getInstance().getTime();
        date=date1.toString();

        this.setTitle("Marvellous Packer-UnPacker");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(iWidth,iHeight);
        this.setBounds((dim.width/2)-(this.iWidth/2), (dim.height/2)-(this.iHeight/2), this.getWidth(), this.getHeight());
        this.setResizable(false);

        _HeaderPanel=new JPanel();
        _HeaderPanel.setLayout(null);
        _HeaderPanel.setBounds(0, 0, iWidth, 100);

        _TopLabel=new JLabel("Some_Text_Will_Appear_Here:");
        _TopLabel.setBounds(20, 50, 200, 20);
        _TopLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
        _HeaderPanel.add(_TopLabel);

        _DateLabel=new JLabel(date);
        _HeaderPanel.setBackground(Color.gray);
        _DateLabel.setBounds(180, 70, 190, 20);
        _DateLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
        _HeaderPanel.add(_DateLabel);
        _HeaderPanel.setVisible(true);
        this.add(_HeaderPanel);
            
        _UIPanel=new JPanel();
        _UIPanel.setLayout(null);
        _UIPanel.setBounds(0, 100, iWidth, 300);
        _UIPanel.setBackground(new Color(112,138,144));
        _UIPanel.setVisible(true);
        this.add(_UIPanel);
     
        
        this.setBackground(Color.WHITE);
        this.setVisible(true);
    }
    
}