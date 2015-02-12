package xyz.voxio.csc112.caesar;

import java.util.Random;

/**
 * Class for secrets, encryptable and decryptable, using a caesar cypher
 *
 * @author Tim Miller - Feb 12, 2015
 */
public class Secret implements Encryptable
{
	private boolean			encrypted;
	private final Random	generator;
	private String			message;
	private final int		shift;

	/**
	 * @param msg
	 *            the message to encrypt
	 */
	public Secret(String msg)
	{
		this.message = msg;
		this.encrypted = false;
		this.generator = new Random();
		this.shift = this.generator.nextInt(10) + 5;
	}

	/*
	 * (non-Javadoc)
	 * @see xyz.voxio.csc112.caesar.Encryptable#decrypt()
	 */
	@Override
	public String decrypt()
	{
		if (this.encrypted)
		{
			String unmasked = "";
			for (int index = 0; index < this.message.length(); index++)
			{
				unmasked = unmasked
						+ (char) (this.message.charAt(index) - this.shift);
			}
			this.message = unmasked;
			this.encrypted = false;
		}

		return this.message;
	}

	/*
	 * (non-Javadoc)
	 * @see xyz.voxio.csc112.caesar.Encryptable#encrypt()
	 */
	@Override
	public void encrypt()
	{
		if (!this.encrypted)
		{
			String masked = "";
			for (int index = 0; index < this.message.length(); index++)
			{
				masked = masked
						+ (char) (this.message.charAt(index) + this.shift);
			}
			this.message = masked;
			this.encrypted = true;
		}
	}

	/**
	 * @return whether or not the message is encrypted
	 */
	public boolean isEncrypted()
	{
		return this.encrypted;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return this.message;
	}
}
