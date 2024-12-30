import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.TextSyntax;
import javax.sound.midi.Soundbank;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import classutilities.AgeCategory;

public class FormPanel extends JPanel {
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener listener;
	private JList ageList;	
	private JComboBox occupationType; 
	private JCheckBox citizenCheckBox;
	private JTextField taxField; 
	private JLabel taxtLabel;
	private boolean isTicked;
	private JRadioButton maleJRadioButton;
	private JRadioButton femaleJRadioButton; 
	private ButtonGroup genderGroup;
	
	public FormPanel() {
		Dimension dimension = getPreferredSize();
		dimension.width= 250;
		setPreferredSize(dimension);
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		okBtn= new JButton("OK");
		ageList = new JList();
		occupationType = new JComboBox();
		citizenCheckBox = new JCheckBox();
		taxField = new JTextField(10);
		taxtLabel = new JLabel("Tax ID: ");
		maleJRadioButton = new JRadioButton("Male");
		femaleJRadioButton = new JRadioButton("Female");
		genderGroup= new ButtonGroup();
		maleJRadioButton.setSelected(true);
		maleJRadioButton.setActionCommand("male");
		femaleJRadioButton.setActionCommand("Female");
		//////set up gender group radios 
		genderGroup.add(maleJRadioButton);
		genderGroup.add(femaleJRadioButton);
		
		////// set up tax ID 
		taxtLabel.setEnabled(false);
		taxField.setEnabled(false);
		
		citizenCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isTicked = citizenCheckBox.isSelected();
				taxtLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);
			}
		});
		
		//////set up JList for ageList //////
		DefaultListModel<AgeCategory> ageModel = new DefaultListModel<>();
		ageModel.addElement(new AgeCategory(0,"Under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "Over 65"));
		
		//////set up combo box occupation type //////
		DefaultComboBoxModel occupationCmbModel= new DefaultComboBoxModel();
		occupationCmbModel.addElement("Employed");
		occupationCmbModel.addElement("Self-Employed");
		occupationCmbModel.addElement("Unemployed");
		occupationType.setModel(occupationCmbModel);
		occupationType.setEditable(true);
		ageList.setModel(ageModel);
		ageList.setPreferredSize(new Dimension(110,71));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(0);
		okBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
				String occupationTypeStr =(String) occupationType.getSelectedItem();
				String taxId = taxField.getText().trim();
				String gender = genderGroup.getSelection().getActionCommand();
				FormEvent ev= new FormEvent(this, name,occupation,ageCat.getAgeIdx()
						,occupationTypeStr,taxId,isTicked,gender); 
				System.out.println(occupationTypeStr);
				System.out.println(ageCat);
				System.out.println(taxField.getText());
				if (listener!=null) {
					listener.formEventOccurred(ev);	
				}
				
			}
		});
		
		SetUpStyle();
	}
	
	public void setFormEventListener(FormListener formListener) {
		this.listener= formListener;
		
	}

	private void SetUpStyle(){
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
		
		////////next row //////////////////////
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
		
		///////next row ///////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy=2;
		gc.gridx=0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Age: "),gc);
		
		///////next row ///////////////////////////
		gc.gridy=2;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList,gc);
	
		
		
		///////Next row ///////////////////////////
		gc.weightx = 1;
		gc.weighty = .2;
		gc.gridy=3;
		gc.gridx=0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Employment: "),gc);
		
		gc.weightx = 1;
		gc.weighty = .2;
		gc.gridy=3;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(occupationType,gc);
		
		
		///////Next row ///////////////////////////
		gc.weightx = 1;
		gc.weighty = .2;
		gc.gridy=4;
		gc.gridx=0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("USA Citizen: "),gc);
		
		gc.weightx = 1;
		gc.weighty = .2;
		gc.gridy=4;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(citizenCheckBox,gc);
		
		
		///////Next row ///////////////////////////
		gc.weightx = 1;
		gc.weighty = .2;
		gc.gridy=5;
		gc.gridx=0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(taxtLabel,gc);
		
		gc.weightx = 1;
		gc.weighty = .2;
		gc.gridy=5;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(taxField,gc);
		
		
		///////Next row ///////////////////////////
		gc.weightx = 1;
		gc.weighty = .005;
		gc.gridy=6;
		gc.gridx=0;
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Gender: "),gc);
		gc.gridy=6;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(maleJRadioButton,gc);
		
		//////next row //////
		gc.weighty = .2;
		gc.gridy=7;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(femaleJRadioButton,gc);
	
	
		
		///////Last row ///////////////////////////
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridy+=1;
		gc.gridx=1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn,gc);
	}
}