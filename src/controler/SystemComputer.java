package controler;

import java.util.Observable;

import model.Captor;
import view.DoorView;
import view.WheelsView;

public class SystemComputer extends AnalyserCaptor{
	public WheelCtrl wc;
	public DoorCtrl dc;
	public LightCtrl lc;
	public boolean gearState = true;
	
	public SystemComputer(String name, LightCtrl lc, WheelsView wv, DoorView dv){
		this.lc = lc;
		this.wc = new WheelCtrl(name, wv, this, lc);
		this.dc = new DoorCtrl(dv, this, lc);
	}
	
	public void launchCommand(boolean handle){
		this.gearState = handle;
		//this.lc.gearOnProgress();
		this.dc.openTheDoor();
		this.wc.progress(handle);
		
		/*if(!general.state) {
			if(this.gearState) {
				System.out.println("(this.gearState) lc.gearIsUp \n");
				this.lc.gearIsUp();
			}
			else {
				System.out.println("(!this.gearState) lc.gearIsDown \n");
				this.lc.gearIsDown();
			}
		}*/
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		Captor captor = (Captor) o;
		/*System.out.println("\t\t\t SIGNAL: CAPTOR :" + captor.name);
		System.out.println("\t\t\t SIGNAL: State :" + captor.state);*/
		/*if(captor.state) {
			switch(captor.name){
				case "open":
					//si la door est ouverte 
					// alors on peut déclencher le mouvement de la roue
					System.out.println("=>door is opened => move wheel \n");
					//this.wc.update();
					break;
				case "close":
					//si la porte est fermée
					//on indique que la procédure est compléte sur la vue
					System.out.println("=>door is closed");
					System.out.println("=>handle = " + this.gearState);
					
					break;
				case "progress":
					System.out.println("=>doorprg \n");
					break;
				case "wheelprg":
					System.out.println("=>wheelprg \n");
					break;
				case "wheeldown":
				case "wheelup":
					System.out.println("=>close door \n");
					//move the wheel;
					//this.dc.closeTheDoor();
					break;	
				case "gearError":
					//this.lc.gearError();
					System.out.println("ERROR : On gear" + captor.gear);
					break;
				case "errorSystem":
					System.out.println("\n\n[ERROR : SYSTEM ]");
					break;
			}	
		}*/	
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
