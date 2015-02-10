package xyz.voxio.csc112.shapes;
//******************************************************************************
//  Pentahedron.java       Java Foundations
//
//  Solution to Programming Project 8.6
//******************************************************************************

public class Pentahedron extends Rectangle
{
   private double height;

   //---------------------------------------------------------------------------
   //  Sets up the pyramid by entering its width, height and length.
   //---------------------------------------------------------------------------
   public Pentahedron(double wid, double len, double hei)
   {
      super(wid, len);
      height = hei;
   }

   //---------------------------------------------------------------------------
   //  Returns the double value of the height.
   //---------------------------------------------------------------------------
   public double getHeight() 
   {
      return height;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the long face height.
   //---------------------------------------------------------------------------
   public double lengthFaceHeight() 
   {
      return Math.sqrt(Math.pow(height, 2) + Math.pow(width / 2, 2));
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the wide face height.
   //---------------------------------------------------------------------------
   public double widthFaceHeight() 
   {
      return Math.sqrt(Math.pow(height, 2) + Math.pow(length / 2, 2));
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the long face area.
   //---------------------------------------------------------------------------
   public double lengthFaceArea() 
   {
      return lengthFaceHeight() * length / 2;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the wide face area.
   //---------------------------------------------------------------------------
   public double widthFaceArea() 
   {
      return widthFaceHeight() * width / 2;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the surface area.
   //---------------------------------------------------------------------------
   public double computeArea() 
   {
      return 2 * lengthFaceArea() + 2 * widthFaceArea() + super.computeArea();
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the volume.
   //---------------------------------------------------------------------------
   public double computeVolume() 
   {
      return super.computeArea() * height / 3;
   }

   //---------------------------------------------------------------------------
   //  Returns pertinent information about the pyramid.
   //---------------------------------------------------------------------------
   public String toString() 
   {
      return "Square Pyramid: width is " + form.format(width) + 
             ", length is " + form.format(length) + ", height is " + 
             form.format(height) + "\nperimeter of base is " + 
             form.format(computePerimeter()) + ", area is " + 
             form.format(computeArea()) +
             "\nvolume is " + form.format(computeVolume()) + "\n";
   }
}