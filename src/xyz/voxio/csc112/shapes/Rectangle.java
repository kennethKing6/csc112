package xyz.voxio.csc112.shapes;
//******************************************************************************
//  Rectangle.java       Java Foundations
//
//  Solution to Programming Project 8.6
//******************************************************************************

import java.text.*;

public class Rectangle extends Shape
{
   protected double width;
   protected double length;
   protected static DecimalFormat form = new DecimalFormat("0.##");

   //---------------------------------------------------------------------------
   //  Sets up the rectangle by entering its width and length.
   //---------------------------------------------------------------------------
   public Rectangle(double wid, double len) 
   {
      width = wid;
      length = len;
   }

   //---------------------------------------------------------------------------
   //  Returns the double value of the width.
   //---------------------------------------------------------------------------
   public double getWidth() 
   {
      return width;
   }
  
   //---------------------------------------------------------------------------
   //  Returns the double value of the length.
   //---------------------------------------------------------------------------
   public double getLength() 
   {
      return length;
   }
   
   //---------------------------------------------------------------------------
   //  Returns the calculated value of the area.
   //---------------------------------------------------------------------------
   public double computeArea() 
   {
      return length * width;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the perimeter.
   //---------------------------------------------------------------------------
   public double computePerimeter() 
   {
      return 2 * (length + width);
   }

   //---------------------------------------------------------------------------
   //  Returns pertinent information about the rectangle.
   //---------------------------------------------------------------------------
   public String toString() 
   {
      return "Rectangle: width is " + form.format(width) + 
             ", length is " + form.format(length) +
             "\nperimeter is " + form.format(computePerimeter()) +
             ", area is " + form.format(computeArea());
   }
}
