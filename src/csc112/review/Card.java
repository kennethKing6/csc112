package csc112.review;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * Card.java
 * 
 * Class for an object representation of a standard playing Card, with a face and suit
 * 
 * @author Tim Miller
 * 
 */
public class Card
{
	public static Collection<Card> getFullDeck()
	{
		Collection<Card> d = new HashSet<>();
		for(int suit = 1;suit <= NUM_SUITS;suit++)
		{
			for(int face = 1;face <= NUM_FACES;face++)
			{
				d.add(new Card(face, suit));
			}
		}
		return d;
	}
	
	/**
	 * Number of suits (this should be an enum)
	 */
	private static final int	NUM_SUITS	= 4;

	/**
	 * Number of faces (this should probably be an enum too)
	 */
	private static final int	NUM_FACES	= 13;
	
	/**
	 * The face
	 */
	private final int			face;

	/**
	 * The face represented by a string
	 */
	private String				faceName;

	/**
	 * The suit
	 */
	private final int			suit;

	/**
	 * The suit represented by a string
	 */
	private String				suitName;

	/**
	 * Default constructor, returning an object with a random face and suit
	 */
	public Card()
	{
		this(new Random().nextInt(Card.NUM_FACES - 1) + 1, new Random()
				.nextInt(Card.NUM_SUITS - 1) + 1);
	}

	/**
	 * Constructor returning an object with a specified face and suit
	 * 
	 * @param face the face
	 * @param suit the suit
	 */
	private Card(final int face, final int suit)
	{
		this.face = face;
		this.suit = suit;
		this.setFaceName();
		this.setSuitName();
	}

	/**
	 * @return the name of the card image 
	 */
	public String getCardName()
	{
		return "";	//TODO
	}

	/**
	 * @return the face, represented by an integer
	 */
	public int getFace()
	{
		return this.face;

	}

	/**
	 * @return the suit, represented by an integer
	 */
	public int getSuit()
	{
		return this.suit;

	}

	private void setFaceName()
	{
		switch (this.face)
		{
			case 1:
				this.faceName = "Ace";
				break;
			case 11:
				this.faceName = "Jack";
				break;
			case 12:
				this.faceName = "Queen";
				break;
			case 13:
				this.faceName = "King";
				break;
			default:
				this.faceName = "" + this.face;
		}
	}

	private void setSuitName()
	{
		switch (this.suit)
		{
			case 1:
				this.suitName = "Clubs";
				break;
			case 2:
				this.suitName = "Diamonds";
				break;
			case 3:
				this.suitName = "Hearts";
				break;
			case 4:
				this.suitName = "Spades";
				break;
		}
	}

	/**
	 * Returns a string representation of the object, in the format {@link faceName} + " of " + {@link suitName}
	 */
	@Override
	public String toString()
	{
		return this.faceName + " of " + this.suitName;
	}
}
