package com.github.bgomar.bgconsolelogger.toolwindow.setup;

import com.intellij.ui.components.JBTextField;
import com.github.bgomar.bgconsolelogger.tools.HashTools;
import com.github.bgomar.bgconsolelogger.tools.hash.BCryptVersion;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HashToolSetup extends AbstractToolSetup {

    private final JTextArea hashInputTextArea;
    private final JBTextField hashMD5TextField;
    private final JBTextField hashSHA1TextField;
    private final JBTextField hashSHA256TextField;
    private final JBTextField hashSHA384TextField;
    private final JBTextField hashSHA512TextField;
    private final JBTextField hashBCrypt2ATextField;
    private final JBTextField hashBCrypt2BTextField;
    private final JBTextField hashBCrypt2YTextField;

    public HashToolSetup(JTextArea hashInputTextArea,
                         JBTextField hashMD5TextField,
                         JBTextField hashSHA1TextField,
                         JBTextField hashSHA256TextField,
                         JBTextField hashSHA384TextField,
                         JBTextField hashSHA512TextField,
                         JBTextField hashBCrypt2ATextField,
                         JBTextField hashBCrypt2BTextField,
                         JBTextField hashBCrypt2YTextField) {
        this.hashInputTextArea = hashInputTextArea;
        this.hashMD5TextField = hashMD5TextField;
        this.hashSHA1TextField = hashSHA1TextField;
        this.hashSHA256TextField = hashSHA256TextField;
        this.hashSHA384TextField = hashSHA384TextField;
        this.hashSHA512TextField = hashSHA512TextField;
        this.hashBCrypt2ATextField = hashBCrypt2ATextField;
        this.hashBCrypt2BTextField = hashBCrypt2BTextField;
        this.hashBCrypt2YTextField = hashBCrypt2YTextField;
    }

    public void setup() {
        hashInputTextArea.setToolTipText("Nota: hash outputs type is Hex, not Base64.");
        hashInputTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                update();
            }
        });
    }

    public void update() {
        String input = hashInputTextArea.getText();
        hashMD5TextField.setText(HashTools.generateMD5(input));
        hashSHA1TextField.setText(HashTools.generateSHA1(input));
        hashSHA256TextField.setText(HashTools.generateSHA256(input));
        hashSHA384TextField.setText(HashTools.generateSHA384(input));
        hashSHA512TextField.setText(HashTools.generateSHA512(input));
        hashBCrypt2ATextField.setText(HashTools.generateBCrypt(input, BCryptVersion.BCryptVersion2a));
        hashBCrypt2BTextField.setText(HashTools.generateBCrypt(input, BCryptVersion.BCryptVersion2b));
        hashBCrypt2YTextField.setText(HashTools.generateBCrypt(input, BCryptVersion.BCryptVersion2y));
    }
}