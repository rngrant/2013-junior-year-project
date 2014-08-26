/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reillycal;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Component;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Reilly Noonan Grant
 */
public class ReillyCal extends Applet implements ActionListener{
    
    private Component[] converterStuff= new Component[8];
    
    private Button baseConvert= new Button("Base Converter");
    private Button convert = new Button("Convert");
    private TextField representation = new TextField(7);
    private JComboBox base;
    private JComboBox fBase;
    private TextArea convertResults = new TextArea(2,20);
    private Label baseLable = new Label("Base");
    private Label repLable = new Label("Number");
    private Label fBaseLable = new Label("Final Base");
    private char[] rep;
    private int b;
    private int bF;
    @Override
    public void init(){
        String[] temp = new String[35];
        for(int i=0; i<temp.length;i++){
            temp[i]=(i+2)+"";
        }
        base = new JComboBox(temp);
        fBase = new JComboBox(temp);
        add(baseConvert);
        add(convert);
        add(convertResults);
        add(representation);
        add(repLable);
        add(base);
        add(baseLable);
        add(fBase);
        add(fBaseLable);
        convert.addActionListener(this);
        baseConvert.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        rep = representation.getText().toCharArray(); 
        b= Integer.parseInt((String)(base.getItemAt(base.getSelectedIndex())));
        bF =Integer.parseInt((String)(fBase.getItemAt(fBase.getSelectedIndex())));
        if (source==baseConvert){
            boolean vis= !convertResults.isVisible();
            convertResults.setVisible(vis);
            convert.setVisible(vis);
            representation.setVisible(vis);
            repLable.setVisible(vis);
            base.setVisible(vis);
            baseLable.setVisible(vis);
            fBase.setVisible(vis);
            fBaseLable.setVisible(vis);
        }
        //else if(source== representation){
            
        //}
        //else if(source==base){
            
        //}
        else if(source== convert){
             if(BaseConverter.convertToTen(rep,b)>=0){
                convertResults.setText("");
                char[] temp = BaseConverter.convertGen(rep, b, bF);
                String theory = "";
                for(char c:temp){
                    theory += c;
                }
                convertResults.append(theory);
            }
            else{convertResults.setText("Your number is not supported"+
                    ". Please enter a valid number");}
        }
        
    }
    
    
}
