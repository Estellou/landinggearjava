package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controler.HandleUpListener;
import controler.SystemComputer;

//commmande interface de pilotage
public class Command extends JFrame{

	// coder design interface
	public static String name = "Landing Gear"; 
	public LightsView lights = new LightsView();
	public WheelsView wheels = new WheelsView();
	public DoorView door = new DoorView();
	public JPanel panellights =  new JPanel();
	
	GridLayout screenLayout = new GridLayout(0,2);
	public JPanel screen = new JPanel();
	/*public JPanel panelwheels =  new JPanel();
	public JPanel paneldoor =  new JPanel();*/
	
	public Command(){
		SystemComputer dashboard = new SystemComputer(lights, wheels);
		HandleUpListener gear = new HandleUpListener(dashboard, door);
		
		this.setSize(new Dimension(250,250));
		this.setTitle(name);
		this.setLayout(new BorderLayout());
		
		JSlider handle = new JSlider(JSlider.VERTICAL, 0, 1, 1);
		handle.setPaintTicks(true);
		handle.setPaintLabels(true);
		handle.addChangeListener(gear);
		Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>() {
			{ 
				put(0, new JLabel("DOWN")); 
				put(1, new JLabel("UP")); }
			};
        handle.setLabelTable(labels);
        handle.setPaintLabels(true);
        
        this.panellights.setLayout(new BoxLayout(this.panellights, BoxLayout.PAGE_AXIS));
        this.panellights.add(this.lights.label1);
        this.panellights.add(this.lights.label2);
        this.panellights.add(this.lights.label3);
        
        this.screen.setLayout(new GridLayout(0,2));
        
        //this.panelwheels.setLayout(new BoxLayout(this.panelwheels, BoxLayout.PAGE_AXIS));
        //this.panelwheels.add(this.wheels.label);
        
        //this.paneldoor.setLayout(new BoxLayout(this.paneldoor, BoxLayout.PAGE_AXIS));
        //this.paneldoor.add(this.door.label);
        
        this.screen.add(this.wheels.label);
        this.screen.add(this.door.label);
        
        this.add(handle, BorderLayout.WEST);
        this.add(this.panellights, BorderLayout.EAST);
        this.add(this.screen, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		
	}
	
	

}
