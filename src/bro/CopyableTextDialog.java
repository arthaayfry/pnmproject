package bro;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyableTextDialog {

    public static void main(String[] args) {
        JTextArea textArea = new JTextArea("");
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

        int option = JOptionPane.showOptionDialog(
                null,
                panel,
                "Copyable Text Dialog",
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
