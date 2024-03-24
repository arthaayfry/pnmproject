package bro;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class pwdgenerator extends JFrame {
    public static void main(String[] args) {
        Random random = new Random();
        char[] letters= new char[]{'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};
        char[] numbers= new char[]{'1','2','3','4','5','6','7','8','9','0'};
        char[] special= new char[]{'!','@','#','$','%','&'};

        char[] password = new char[10];
        int abc, num, spc;
        abc=0;
        num=0;

        //all initialization steps completed

        for(int i=0;i<=9;i++)
        {
            if(abc!=4)
            {
                password[i]=letters[random.nextInt(letters.length)];
                abc++;
            }
            else if (num!=3)
            {
                password[i]=numbers[random.nextInt(numbers.length)];
                num++;
            }
            else
            {

                password[i]=special[random.nextInt(special.length)];
            }

        }
        System.out.println(password);
        //final password is obtained



        //shuffling contents of password
        for(int i=0;i<=9;i++)
        {
            int choose= random.nextInt(9);
            char temp;
            temp=password[i];
            password[i]=password[choose];
            password[choose]=temp;
        }
        System.out.println("shuffled Password");
        System.out.println(password);
        String pass = new String(password);
        System.out.println(pass);


        //HYACHYA NANTARCHA CHATGPT NE KELAY LOL


        JTextArea textArea = new JTextArea(pass);
        textArea.selectAll(); // Automatically select the text
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton copyButton = new JButton("Copy");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected text from the JTextArea
                String selectedText = textArea.getSelectedText();
                if (selectedText != null && !selectedText.isEmpty()) {
                    // Copy the selected text to the clipboard
                    StringSelection stringSelection = new StringSelection(selectedText);
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                    System.out.println("Text copied to clipboard: " + selectedText);
                } else {
                    System.out.println("No text selected.");
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(copyButton, BorderLayout.SOUTH);
        panel.setBackground(Color.black);

        int option = JOptionPane.showOptionDialog(
                null,
                panel,
                "Secure Generated Password",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if (option == JOptionPane.OK_OPTION) {
            System.out.println("User clicked OK.");
        } else {
            System.out.println("User canceled the operation.");
        }
    }

}
