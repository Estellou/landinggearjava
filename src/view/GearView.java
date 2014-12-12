package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class GearView {
	public WheelsView wheels = new WheelsView();
	public DoorView door = new DoorView();
	public JPanel gearPanel = new JPanel();
	
	public GearView(){
		this.gearPanel.setLayout(new GridLayout(0,2));
        
        this.gearPanel.add(this.wheels.label);
        this.gearPanel.add(this.door.label);
	}
	
}
