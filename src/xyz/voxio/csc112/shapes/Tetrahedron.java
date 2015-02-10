package xyz.voxio.csc112.shapes;
//******************************************************************************
//  Tetrahedron.java       Java Foundations
//
//  Solution to Programming Project 8.6
//******************************************************************************

public class Tetrahedron extends Triangle
{
   private double height;

   //---------------------------------------------------------------------------
   //  Sets up the pyramid by entering its base side length and height.
   //---------------------------------------------------------------------------
   public Tetrahedron (double sid, double hei)
   {
      super(sid);
      height = hei;
   }

   //---------------------------------------------------------------------------
   //  Returns the double value of the height.
   //---------------------------------------------------------------------------
   public double getPyramidHeight() 
   {
      return height;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of a face height.
   //---------------------------------------------------------------------------
   public double faceHeight() 
   {
      return Math.sqrt(Math.pow(height, 2) + Math.pow(getHeight() / 2, 2));
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of a face area.
   //---------------------------------------------------------------------------
   public double faceArea() 
   {
      return faceHeight() * side / 2;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the surface area.
   //---------------------------------------------------------------------------
   public double computeArea() 
   {
      return 3 * faceArea() + super.computeArea();
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
      return "Triangle Pyramid: Height is " + form.format(height) +
             "\nperimeter of base is " + form.format(computePerimeter()) +
             ", area is " + form.format(computeArea()) +
             "\nvolume is " + form.format(computeVolume()) + "\n";
   }
}