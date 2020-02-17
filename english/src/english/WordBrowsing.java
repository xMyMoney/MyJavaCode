package english;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordBrowsing {
	JFrame f = new JFrame();
	JTextArea t;

	public void Browsing() {

		f.setBounds(600, 300, 400, 700);
		f.setLayout(null);

		JTextArea t = new JTextArea();
		t.setFont(new Font("Dialog", 2, 28));
		t.setEditable(false);
		File file = new File("D:\\Message2.txt");
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			while ((text = input.readLine()) != null)
				t.setText(t.getText() + text + "\n");
		} catch (IOException ioException) {
			System.err.println("File Error!");
		}

		t.setCaretPosition(0);
		JScrollPane sp = new JScrollPane(t);
		f.setContentPane(sp);

		f.setVisible(true);

	}
}
