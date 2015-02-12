package xyz.voxio.csc112.caesar;

// ********************************************************************
// Secret.java Java Foundations
//
// Represents a secret message that can be encrypted and decrypted.
// ********************************************************************

import java.util.Random;

public class Secret implements Encryptable
{
	private boolean			encrypted;
	private final Random	generator;
	private String			message;
	private final int		shift;

	// -----------------------------------------------------------------
	// Constructor: Stores the original message and establishes
	// a value for the encryption shift.
	// -----------------------------------------------------------------
	public Secret(String msg)
	{
		this.message = msg;
		this.encrypted = false;
		this.generator = new Random();
		this.shift = this.generator.nextInt(10) + 5;
	}

	// -----------------------------------------------------------------
	// Decrypts and returns this secret. Has no effect if this
	// secret is not currently encrypted.
	// -----------------------------------------------------------------
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

	// -----------------------------------------------------------------
	// Encrypts this secret using a Caesar cipher. Has no effect if
	// this secret is already encrypted.
	// -----------------------------------------------------------------
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

	// -----------------------------------------------------------------
	// Returns true if this secret is currently encrypted.
	// -----------------------------------------------------------------
	public boolean isEncrypted()
	{
		return this.encrypted;
	}

	// -----------------------------------------------------------------
	// Returns this secret (may be encrypted).
	// -----------------------------------------------------------------
	@Override
	public String toString()
	{
		return this.message;
	}
}
