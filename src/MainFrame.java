import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	private TextPanel textPanel; 
	private JButton btn; 
	private Toolbars toolbars;
	private FormPanel formPanel;
	
	public MainFrame(String label) {
		super(label);
		setLayout(new BorderLayout());
		textPanel = new TextPanel();
		toolbars = new Toolbars();
		formPanel = new FormPanel();
		toolbars.setListenerRef(new MessageListener() {
				@Override
			public void textEmitted(String text) {
					textPanel.appendText(text);
			}
		});
		formPanel.setFormEventListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String nameString =e.getName();
				String occupationString= e.getOccupation();
				textPanel.appendText(nameString +" : " + occupationString+ "\n");
				
			}
		});
		add(toolbars,BorderLayout.NORTH);
		add(formPanel,BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		setSize(600,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
}
