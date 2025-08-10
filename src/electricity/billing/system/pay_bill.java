package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class pay_bill extends JFrame implements ActionListener {
    String meter;
    Choice searchMonthCho;
    JButton pay,back;
    pay_bill(String meter){
        this.meter=meter;
        setSize(900,600);
        setLocation(300,150);
        setLayout(null);

        JLabel heading=new JLabel("Pay Bill");
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        heading.setBounds(120,5,400,30);
        add(heading);

        JLabel meterNumber=new JLabel("Meter Number");
        meterNumber.setBounds(35,80,200,20);
        add(meterNumber);

        JLabel meterNumberT=new JLabel("");
        meterNumberT.setBounds(300,80,200,20);
        add(meterNumberT);

        JLabel name=new JLabel("Name");
        name.setBounds(35,140,200,20);
        add(name);

        JLabel nameT=new JLabel("");
        nameT.setBounds(300,140,200,20);
        add(nameT);

        JLabel month=new JLabel("Month");
        month.setBounds(35,200,200,20);
        add(month);

        searchMonthCho=new Choice();
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");
        searchMonthCho.setBounds(300,200,150,20);
        add(searchMonthCho);

        JLabel unit=new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        add(unit);

        JLabel unitT=new JLabel("");
        unitT.setBounds(300,260,200,20);
        add(unitT);

        JLabel totalBill=new JLabel("Total Bill");
        totalBill.setBounds(35,320,200,20);
        add(totalBill);

        JLabel totalBillT=new JLabel("");
        totalBillT.setBounds(300,320,200,20);
        add(totalBillT);

        JLabel status=new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);

        JLabel statusT=new JLabel("");
        statusT.setBounds(300,380,200,20);
        statusT.setForeground(Color.RED);
        add(statusT);

        try{
            database c=new database();
            ResultSet resultSet=c.statement.executeQuery("select * from new_customer where meter_no='"+meter+"'");
            while(resultSet.next()){
                meterNumberT.setText(meter);
                nameT.setText(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        searchMonthCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                database c=new database();
                try{
                    ResultSet resultSet=c.statement.executeQuery("select * from bill where meter_no='"+meter+"' and month='"+searchMonthCho.getSelectedItem()+"'");
                    while(resultSet.next()){
                        unitT.setText(resultSet.getString("unit"));
                        totalBillT.setText(resultSet.getString("total_bill"));
                        statusT.setText(resultSet.getString("status"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pay=new JButton("Pay");
        pay.setBounds(100,460,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        back=new JButton("Back");
        back.setBounds(230,460,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pay){
            try{
                database c=new database();
                c.statement.executeUpdate("update bill set status='Paid' where meter_no='"+meter+"' and month='"+searchMonthCho.getSelectedItem()+"'");
            }catch (Exception ex){
                ex.printStackTrace();
            }
            setVisible(false);
            new payment_bill(meter);
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new pay_bill("");
    }
}
