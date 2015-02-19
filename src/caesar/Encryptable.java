package caesar;

/**
 * @author Tim Miller - Feb 12, 2015
 *         interface representing an encryptable object
 */
public interface Encryptable
{
	/**
	 * @return the decrypted string
	 */
	public String decrypt();

	/**
	 * Encrypt the string
	 */
	public void encrypt();
}
