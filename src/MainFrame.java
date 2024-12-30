import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		setJMenuBar(createMenuBar());
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
				String ageCategory =String.valueOf(e.getAgeCategory());
				String occupationType =e.getOccupationType();  
				textPanel.appendText(nameString +" : " + occupationString+ " Age range: "+ ageCategory
						+" Status: "+
						occupationType + " Genre: "+e.getGender()+" \n");
				
			}
		});
		add(toolbars,BorderLayout.NORTH);
		add(formPanel,BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);
		setSize(600,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(fileMenu);
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.add(exitItem); 
		
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		showFormItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)e.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}
		});
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		
		return menuBar;
		
	}
	
}
