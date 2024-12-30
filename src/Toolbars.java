import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Toolbars extends JPanel implements ActionListener {
	private JButton helloBtn ;
	private JButton goodByeBtn; 
	private MessageListener messageListener;
	public Toolbars() {
		setBorder(BorderFactory.createEtchedBorder());
		helloBtn = new JButton("Hello");
		goodByeBtn = new JButton("GoodBye Button");
		helloBtn.addActionListener(this);
		goodByeBtn.addActionListener(this);
		setLayout(new FlowLayout());
		add(helloBtn);
		add(goodByeBtn);	
	}
	
	public void setListenerRef(MessageListener messageListener) {
		this.messageListener= messageListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		JButton clickedButton=(JButton) e.getSource();
		if (clickedButton==helloBtn) {
			if (messageListener!= null) {
				messageListener.textEmitted("Hey welcome Andres Tecpile\n");
			}
		}else {
			if (messageListener!=null) {
				messageListener.textEmitted("Goodbye Andres Tecpile\n");
			}
		}
	}
	
	
	

}
