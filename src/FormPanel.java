import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener listener;
	
	public FormPanel() {
		Dimension dimension = getPreferredSize();
		dimension.width= 250;
		setPreferredSize(dimension);
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		okBtn= new JButton("OK");
		
		okBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				FormEvent ev= new FormEvent(this, name,occupation); 
				if (listener!=null) {
					listener.formEventOccurred(ev);	
				}
				
			}
		});
		
		Border innBorder = BorderFactory.createTitledBorder("Add a Person");
		Border outterBorder =BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder,innBorder));
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		
		///////first row //////////////////////////	
		gc.gridx = 0;
		gc.gridy= 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(nameLabel, gc);
		
		gc.gridx = 1; 
		gc.gridy = 0; 
		gc.anchor= GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(nameField,gc);
		
		////////second row //////////////////////
		gc.weightx=1;
		gc.weighty =0.1;
		gc.gridx=0;
		gc.gridy = 1;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel,gc);
		
		gc.gridy=1; 
		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField,gc);
		
		///////third row ///////////////////////////
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridy=2;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn,gc);
		
		
		
	}
	
	public void setFormEventListener(FormListener formListener) {
		this.listener= formListener;
		
	}

}