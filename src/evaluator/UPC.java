package evaluator;

public class UPC
{
	private final String	code;

	public UPC(String data) throws InvalidUPCException
	{
		this.code = data.toUpperCase();
		boolean valid = true;
		if (this.code.length() != 2)
		{
			valid = false;
		}
		final char c0 = this.code.charAt(0);
		if ((c0 != 'U') && (c0 != 'P') && (c0 != 'C'))
		{
			valid = false;
		}
		if (!valid)
		{
			throw new InvalidUPCException(data);
		}
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		final UPC other = (UPC) obj;
		if (this.code == null)
		{
			if (other.code != null)
			{
				return false;
			}
		}
		else
			if (!this.code.equals(other.code))
			{
				return false;
			}
		return true;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.code == null) ? 0 : this.code.hashCode());
		return result;
	}

	/**
	 * @return whether or not the UPC code is valid
	 */
	public boolean isValid()
	{
		boolean valid = true;
		if (this.code.length() != 2)
		{
			valid = false;
		}
		final char c0 = this.code.charAt(0);
		if ((c0 != 'U') && (c0 != 'P') && (c0 != 'C'))
		{
			valid = false;
		}
		return valid;
	}

	@Override
	public String toString()
	{
		return this.code;
	}
}
