package controler;
import java.util.Observer;

/***
 * AnalyserCaptor est une interface � impl�menter pour toutes les classes qui jouent le r�le d'observer
 * @author Estelle
 *
 */

public abstract class AnalyserCaptor implements Observer{
	
	public abstract void update();
	
}
