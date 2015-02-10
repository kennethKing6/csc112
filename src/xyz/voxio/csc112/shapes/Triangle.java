package xyz.voxio.csc112.shapes;
//******************************************************************************
//  Triangle.java       Java Foundations
//
//  Solution to Programming Project 8.6
//******************************************************************************

import java.text.*;

public class Triangle extends Shape
{
   protected double side;
   protected static DecimalFormat form = new DecimalFormat("0.##");

   //---------------------------------------------------------------------------
   //  Sets up the triangle by entering the length of a side.
   //---------------------------------------------------------------------------
   public Triangle (double sid) 
   {
      side = sid;
   }

   //---------------------------------------------------------------------------
   //  Returns the double value of the side.
   //---------------------------------------------------------------------------
   public double getSide() 
   {
      return side;
   }
  
   //---------------------------------------------------------------------------
   //  Returns the double value of the height of the triangle.
   //---------------------------------------------------------------------------
   public double getHeight() 
   {
      return Math.sqrt(Math.pow(side, 2) - Math.pow(side / 2, 2));
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the area.
   //---------------------------------------------------------------------------
   public double computeArea() 
   {
      return side * getHeight() / 2;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the perimeter.
   //---------------------------------------------------------------------------
   public double computePerimeter() 
   {
      return side * 3;
   }

   //---------------------------------------------------------------------------
   //  Returns pertinent information about the triangle.
   //---------------------------------------------------------------------------
   public String toString() 
   {
      return "Triangle: side length is " + form.format(side) + 
             "\nperimeter is " + form.format(computePerimeter()) +
             ", area is " + form.format(computeArea());
   }
}
