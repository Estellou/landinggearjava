package controler;
import java.util.Observer;

/***
 * AnalyserCaptor est une interface à implémenter pour toutes les classes qui jouent le rôle d'observer
 * @author Estelle
 *
 */

public abstract class AnalyserCaptor implements Observer{
	
	public abstract void update();
	
}
