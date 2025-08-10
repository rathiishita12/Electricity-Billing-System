package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {
    Choice meterLocCho,meterTypeCho,phaseCodeCho,billTypeCho;
    JButton submit;
    String meternumber;
    meterInfo(String meternumber){
        this.meternumber=meternumber;
        System.out.println("Meter Number in meterInfo constructor: " + this.meternumber);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meterNumber=new JLabel("Meter Number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        JLabel meterNumberText=new JLabel(meternumber);
        meterNumberText.setBounds(180,80,150,20);
        panel.add(meterNumberText);

        JLabel meterLoc=new JLabel("Meter Location");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterLocCho=new Choice();
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,150,20);
        panel.add(meterLocCho);

        JLabel meterType=new JLabel("Meter Type");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        meterTypeCho=new Choice();
        meterTypeCho.add("Electric Meter");
        meterTypeCho.add("Solar Meter");
        meterTypeCho.add("Smart Meter");
        meterTypeCho.setBounds(180,160,150,20);
        panel.add(meterTypeCho);

        JLabel phaseCode=new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeCho=new Choice();
        phaseCodeCho.add("011");
        phaseCodeCho.add("022");
        phaseCodeCho.add("033");
        phaseCodeCho.add("044");
        phaseCodeCho.add("055");
        phaseCodeCho.add("066");
        phaseCodeCho.add("077");
        phaseCodeCho.add("088");
        phaseCodeCho.add("099");
        phaseCodeCho.setBounds(180,200,150,20);
        panel.add(phaseCodeCho);

        JLabel billType=new JLabel("Bill Type");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        billTypeCho=new Choice();
        billTypeCho.add("Normal");
        billTypeCho.add("Industrial");
        billTypeCho.setBounds(180,240,150,20);
        panel.add(billTypeCho);

        JLabel l1=new JLabel("30 Days Billing Time...");
        l1.setBounds(50,280,200,20);
        panel.add(l1);

        JLabel note=new JLabel("Note:-");
        note.setBounds(50,320,200,20);
        panel.add(note);

        JLabel stat=new JLabel("By default bill is calculated for 30 days only");
        stat.setBounds(50,340,300,20);
        panel.add(stat);

        submit=new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        setSize(700,500);
        setLocation(400,200);
        setLayout(new BorderLayout());
        add(panel,BorderLayout.CENTER);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image i2=i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l2=new JLabel(i3);
        add(l2,BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String smeter=meternumber;
            String smeterLoc=meterLocCho.getSelectedItem();
            String smeterType=meterTypeCho.getSelectedItem();
            String sphaseCode=phaseCodeCho.getSelectedItem();
            String sbillType=billTypeCho.getSelectedItem();
            String sday="30";
            String query_meterInfo="insert into meterInfo values('"+smeter+"','"+smeterLoc+"','"+smeterType+"','"+sphaseCode+"','"+sbillType+"','"+sday+"')";
            try{
                database c=new database();
                c.statement.executeUpdate(query_meterInfo);
                JOptionPane.showMessageDialog(null,"Meter Information Submitted Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
