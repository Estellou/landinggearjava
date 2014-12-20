package model;

import java.util.Observable;

import view.WheelsView;
import controler.LightCtrl;

public class Wheels extends Observable {

	public Captor wheelUp;
	public Captor wheelDown;
	public Captor wheelProgress;
	public String name;
	
	/**
	 * Wheels public constructor: ajout des observers aux capteurs
	 * @param name
	 * @param observer
	 * @param lc
	 */
	public Wheels(String name, WheelsView observer, LightCtrl lc) {
		this.name = name;
		// initiale state
		this.wheelUp = new Captor("wheelup", true, name);
		this.wheelDown = new Captor("wheeldown", false, name);
		this.wheelProgress = new Captor("wheelprg", false, name);

		this.wheelUp.addObserver(observer);
		this.wheelUp.addObserver(lc);
		
		this.wheelDown.addObserver(observer);
		this.wheelDown.addObserver(lc);
		
		this.wheelProgress.addObserver(observer);
		this.wheelProgress.addObserver(lc);
	}
	/**
	 * wheels public constructor: sans le set des observers pour les tests
	 * @param name
	 */
	public Wheels(String name) {
		this.wheelUp = new Captor("wheelup", true, name);
		this.wheelDown = new Captor("wheeldown", false, name);
		this.wheelProgress = new Captor("wheelprg", false, name);
	}
	
	/**
	 * afterHandle simule de "bouger" les roue en fonction de la commander entrée.
	 * Cette methode génère aléatoirement une erreur. Elle retourne vrai quand la roue est dans la position souhaité et faux quand ce n'est pas le cas
	 * @param command
	 * @param randomError : probabilité d'erreur si égal à 0 alors jamais d'erreur généré
	 * @return
	 */
	public boolean afterHandle(boolean command, int randomError) {
		//command = false => down
		//command = true => up
		double random = Math.random()* 100;
		if (random >=  randomError) {
			// not error
			this.wheelProgress.setState(false);
			this.wheelDown.setState(!command);
			this.wheelUp.setState(command);
			return true;
		}
		//erreur
		return false;
	}
	
	/**
	 * progressWheel: change l'état du capteur de la roue en mouvement
	 * @param state
	 */
	public void progressWheel(boolean state) {
		this.wheelProgress.setState(state);
	}

}
