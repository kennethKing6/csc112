package firm;

/**
 * The UML diagram is located in uml_diagram.bmp, and the program logic is in
 * logic.md
 * A firm, with employees and a payroll
 *
 * @author Tim Miller - Feb 12, 2015
 */
public class Firm
{
	public static void main(String[] args)
	{
		final Staff personnel = new Staff();

		personnel.payday();
	}
}
