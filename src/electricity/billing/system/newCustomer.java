package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener {
    JLabel customerName,heading,meterNumber,Address,City,State,Email,Phone;
    JTextField meterText;
    TextField nameText,addressText,cityText,stateText,emailText,phoneText;
    JButton next,cancel;
    newCustomer() {
        super("New Customer");
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        heading=new JLabel("New Customer");
        heading.setBounds(180,10,200, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(heading);

        customerName=new JLabel("New Customer");
        customerName.setBounds(50,80,100, 20);
        panel.add(customerName);

        nameText=new TextField();
        nameText.setBounds(150,80,150,20);
        panel.add(nameText);

        meterNumber=new JLabel("Meter Number");
        meterNumber.setBounds(50,120,100, 20);
        panel.add(meterNumber);

        meterText=new JTextField();
        meterText.setBounds(150,120,150,20);
        panel.add(meterText);


        Random ran=new Random();
        long number=ran.nextLong()%1000000;
        meterText.setText(""+Math.abs(number));

        Address=new JLabel("Address");
        Address.setBounds(50,160,100, 20);
        panel.add(Address);

        addressText=new TextField();
        addressText.setBounds(150,160,150,20);
        panel.add(addressText);

        City=new JLabel("City");
        City.setBounds(50,200,100, 20);
        panel.add(City);

        cityText=new TextField();
        cityText.setBounds(150,200,150,20);
        panel.add(cityText);

        State=new JLabel("State");
        State.setBounds(50,240,100, 20);
        panel.add(State);

        stateText=new TextField();
        stateText.setBounds(150,240,150,20);
        panel.add(stateText);

        Email=new JLabel("Email");
        Email.setBounds(50,280,100, 20);
        panel.add(Email);

        emailText=new TextField();
        emailText.setBounds(150,280,150,20);
        panel.add(emailText);

        Phone=new JLabel("Phone");
        Phone.setBounds(50,320,100, 20);
        panel.add(Phone);

        phoneText=new TextField();
        phoneText.setBounds(150,320,150,20);
        panel.add(phoneText);

        next = new JButton("Next");
        next.setBounds(120,390,100, 25);
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.addActionListener(this);
        panel.add(next);

        cancel=new JButton("Cancel");
        cancel.setBounds(230,390,100, 25);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.addActionListener(this);
        panel.add(cancel);

        setSize(700,500);
        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image i2=i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        add(l1,"West");
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            String sname=nameText.getText();
            String smeter=meterText.getText();
            String saddress=addressText.getText();
            String scity=cityText.getText();
            String sstate=stateText.getText();
            String semail=emailText.getText();
            String sphone=phoneText.getText();

            String query_customer="insert into new_Customer values('"+sname+"','"+smeter+"','"+saddress+"','"+scity+"','"+sstate+"','"+semail+"','"+sphone+"')";
            String query_signup="insert into signup values('"+smeter+"','','"+sname+"','','')";
            try{
                database c=new database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);
                JOptionPane.showMessageDialog(null,"Customer details added successfully");
                setVisible(false);
                new meterInfo(smeter);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCustomer();
    }
}
