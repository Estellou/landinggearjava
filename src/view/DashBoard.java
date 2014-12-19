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

public class DashBoard {
	// coder design interface
	public JFrame dashboard = new JFrame();
	public static String name = "Landing Gear"; 
	public LightsView lights = new LightsView();
	public GearView gearView1 = new GearView();
	public GearView gearView2 = new GearView();
	public GearView gearView3 = new GearView();
	public JPanel panellights =  new JPanel();
	public JSlider handle;
	public JPanel screen = new JPanel(new GridLayout(2,1));
	
	public DashBoard(){
		
		this.dashboard.setSize(new Dimension(250,250));
		this.dashboard.setTitle(name);
		this.dashboard.setLayout(new BorderLayout());
		
		this.handle = new JSlider(JSlider.VERTICAL, 0, 1, 1);
		this.handle.setPaintTicks(true);
		this.handle.setPaintLabels(true);
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
        
        this.dashboard.add(handle, BorderLayout.WEST);
        this.dashboard.add(this.panellights, BorderLayout.EAST);
        
        this.screen.add(this.gearView1.gearPanel);
        this.screen.add(this.gearView2.gearPanel);
        this.screen.add(this.gearView3.gearPanel);
        
        this.dashboard.add(this.screen, BorderLayout.SOUTH);
		this.dashboard.pack();
		this.dashboard.setVisible(true);
		
	}
}
