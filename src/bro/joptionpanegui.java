package bro;

import javax.swing.*;

public class joptionpanegui {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What is your name?");
        System.out.println(name);
        JOptionPane.showMessageDialog(null," "+name);
        int age=Integer.parseInt(JOptionPane.showInputDialog("What is your age?"));
        JOptionPane.showMessageDialog(null,"wtf you're "+age+" ?!?!");
    }
}
