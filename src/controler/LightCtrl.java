package controler;

import java.util.ArrayList;
import java.util.Observable;

import model.Captor;
import model.Lights;
import view.LightsView;

/**
 * LightCtrl controle les lumières en fonction du comportement des différents systèmes (roue/porte). C'est class est un observateur. Il Observe chaque roues et portes du system
 * @author Estelle
 *
 */
public class LightCtrl extends AnalyserCaptor{
	public Lights lights;
	public ArrayList<SystemComputer> gears = new ArrayList<SystemComputer>();
	public boolean command;
	public boolean error = false;
	
	/**
	 * public constructor. L'état initiale étant Up, on l'affiche à l'écran.
	 * @param lightsview
	 */
	public LightCtrl(LightsView lightsview){
		this.lights = new Lights(lightsview);
		this.gearsIsUp();
	}
	/**
	 * public constructor for testing
	 * @param lightsview
	 */
	public LightCtrl(){
		this.lights = new Lights();
		this.gearsIsUp();
	}
	/**
	 * setArrayGears permet d'initialiser l'array contenant les différents system (roue/porte) afin d'accéder à leur état ou à certaine de leur propriété pendant certaine manipe
	 * @param gears1
	 * @param gears2
	 * @param gears3
	 */
	public void setArrayGears(SystemComputer gears1, SystemComputer gears2, SystemComputer gears3 ){
		this.gears.add(gears1);
		this.gears.add(gears2);
		this.gears.add(gears3);
	}
	/**
	 * set the command 
	 * @param command
	 */
	public void launchCommand(boolean command){
		this.command = command;
	}
	/**
	 * Change les lumières du tableau de bord: allume la lumière Orange
	 */
	public void gearOnProgress(){
		this.lights.setLightOrange(true);
		this.lights.setLightGreen(false);
		this.lights.setLightRed(false);
	}
	/**
	 * Change les lumières du tableau de bord: allume la lumière Rouge
	 */
	public void gearsError(){
		this.lights.setLightOrange(false);
		this.lights.setLightRed(true);
	}
	/**
	 * Change les lumières du tableau de bord: allume la lumière Vert
	 */
	public void gearsIsDown(){
		this.lights.setLightOrange(false);
		this.lights.setLightGreen(true);
	}
	/**
	 * Change les lumières du tableau de bord: eteint toutes les lumières
	 */
	public void gearsIsUp(){
		this.lights.setLightGreen(false);
		this.lights.setLightRed(false);
		this.lights.setLightOrange(false);
	}
	/**
	 * Observe les états des capteurs des roues pour activer les prochaines étapes 
	 */
	@Override
	public void update(Observable o, Object arg) {
		Captor captor = (Captor) o;
		if(captor.state) {
			switch(captor.name){
			case "open": 
				//quand une porte est ouverte on commande le mouvement de la roue
				if(this.gears.get(0).dc.door.open.state & this.gears.get(1).dc.door.open.state & this.gears.get(2).dc.door.open.state) {
					this.gears.get(0).wc.updateWheel(this.command);
					this.gears.get(1).wc.updateWheel(this.command);
					this.gears.get(2).wc.updateWheel(this.command);
				}
				break;
			case "wheeldown":
			case "wheelup":
				//quand une roue est dans la position finale attendue (sans erreur), on ferme la porte correspondante
				if(captor.gear == "gear1" & !this.gears.get(0).wc.signalError.state) this.gears.get(0).dc.closeTheDoor();
				if(captor.gear == "gear2" & !this.gears.get(1).wc.signalError.state) this.gears.get(1).dc.closeTheDoor();
				if(captor.gear == "gear3" & !this.gears.get(2).wc.signalError.state) this.gears.get(2).dc.closeTheDoor();
				break;
			case "wheelError":
				//S'il y a eu une erreur sur une des roues, alors on le signal à l'intégralité du system
				//de plus, on allume la lumière rouge sur le tableau de bord
				this.gearsError();
				this.error = true;
				break;
			case "close":
				//Quand les portes ont toutes étaient fermées (pas d'erreur détecté), alors on allume la lumière correspondante à l'action terminée
				if(!this.error){
					//tous a vrai
					if(!this.gears.get(0).wc.signalError.state & !this.gears.get(1).wc.signalError.state & !this.gears.get(2).wc.signalError.state) {
						if(this.command) {
							this.gearsIsUp();
						}
						else {
							this.gearsIsDown();
						}
					}	
				}
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
