package movies;

import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;


public class DVDCollection
{
   private DVD[] collection;
   private int count;
   private double totalCost;
   public int currentSize()
   {
	   return collection.length;
   }

   public DVDCollection ()
   {
      collection = new DVD[100];
      count = 0;
      totalCost = 0.0;
   }

   public void addDVD (String title, String director, int year,
      double cost, boolean bluRay)
   {
      if (count == collection.length)
         increaseSize();

      collection[count] = new DVD (title, director, year, cost, bluRay);
      totalCost += cost;
      count++;
   }
   
   public void subDVD(String title)
   {
      int j = 0;
      int i;
      
      DVD [] temp = new DVD[currentSize()];
       
      for(i=0; i<count; i++)
      {
         if(title.equalsIgnoreCase(collection[i].getTitle()))
         {
             totalCost -= collection[i].getCost();
         }
         else
         {  
            temp[j] = collection[i];
            j++;
         }
      }
     
      if (i != j) 
      {
          count--;
          System.out.println("\nDVD deleted\n");
          collection = temp;
      }
      else
          System.out.println("\nDVD not found\n");
      
   }
   
   public void updDVD(String title, String director, int year, double cost, boolean bluRay)
   {
      int i;
      int flag = 0;  
      DVD [] temp = new DVD[currentSize()];
       
      for(i=0; i<count; i++)
      {
         if(title.equalsIgnoreCase(collection[i].getTitle()))
         {
             temp[i] = new DVD (title, director, year, cost, bluRay);
             totalCost -= collection[i].getCost();
             totalCost += cost;
             flag = 1;
            
         }
         else
         {
            
            temp[i] = collection[i];
         }
      }
      
      if (flag == 1)
      {
          System.out.println("\nCollection Updated\n");  
          collection = temp;
      }
      else
          System.out.println("\nDVD not found\n");
      
   }
   public void writeToFile()
   {
       try 
       {
          FileWriter fw = new FileWriter("DVDCollection.txt", false);
          
          BufferedWriter bw = new BufferedWriter (fw);
          
          String s;
          
          for(int i=0; i<count; i++)
          {
	          s = "";
              s += collection[i].getTitle() + "/";
              s += collection[i].getDirector() + "/";
              s += collection[i].getYear() + "/";
              s += collection[i].getCost() + "/";
              s += collection[i].isBluRay() + "\r\n";
              bw.write (s);
          }
          
          bw.flush();
          bw.close();
          System.out.println("\nWrite to file is complete\n");
       }
       
       catch(IOException e)
       {
          e.printStackTrace();
       }
   }
   public void scannerReadFile()
   {
       try 
       {
          Scanner fileScan, recordScan;
          
          String title, director, record;
          double cost;
          int year;
          boolean bluRay;
          
          count = 0;
          totalCost = 0.0;
          
          fileScan = new Scanner(new File("DVDCollection.txt"));
          
          while((fileScan.hasNext()))
          {
             if (collection.length == 0) 
             {
            	 collection = new DVD[1];
             }
             if (count >= collection.length)
                 increaseSize(); 
    

             record = fileScan.nextLine();
             recordScan = new Scanner(record);
             recordScan.useDelimiter("/");
             
             title = recordScan.next();
             director = recordScan.next();
             year = recordScan.nextInt();
             cost = recordScan.nextDouble();
             bluRay = recordScan.nextBoolean();
             collection[count] = new DVD (title, director, year, cost, bluRay);
             totalCost += cost;
             count++;
    
          }
          fileScan.close();
       }
       catch(IOException e)
       {
          e.printStackTrace();
       }
   } 
   
   public void selectionSortByTitle()
   {
      int min;
      
      DVD temp;
      
      for (int index = 0; index < count-1; index++)
      {
         min = index;
         
         for (int scan = index+1; scan < count; scan++)
         
            if (collection[scan].getTitle().compareTo(collection[min].getTitle()) < 0)
            
               min = scan;

         temp = collection[min];
         collection[min] = collection[index];
         collection[index] = temp;
      }
   }
   public void selectionSortByDirector()
   {
      int min;
      
      DVD temp;
      
      for (int index = 0; index < count-1; index++)
      {
         min = index;
         
         for (int scan = index+1; scan < count; scan++)
         
            if (collection[scan].getDirector().compareTo(collection[min].getDirector()) < 0)
            
               min = scan;

         temp = collection[min];
         collection[min] = collection[index];
         collection[index] = temp;
      }
   }
   
   
    public DVD binarySearch(String targetTitle)
    {
        int min=0;                          
        int max=count;                     
        int mid=0;                             
        boolean found = false;             
        
        while (!found && min <= max)
        {
            mid = (min+max)/2;
            if(collection[mid].getTitle().compareTo(targetTitle) == 0)
                found = true;               
            else if (collection[mid].getTitle().compareTo(targetTitle) > 0)
                max = mid-1;                
            else 
                min = mid+1;                
        }
        
        if (found) return collection[mid];  
        else return null;                 
   }


   
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
      report += "My DVD Collection\n\n";

      report += "Number of DVDs: " + count + "\n";
      report += "Total cost: " + fmt.format(totalCost) + "\n";
      report += "Average cost: " + fmt.format(totalCost/count);

      report += "\n\nDVD List:\n\n";

      for (int dvd = 0; dvd < count; dvd++)
         report += collection[dvd].toString() + "\n";

      return report;
   }

   private void increaseSize ()
   {
      DVD[] temp = new DVD[collection.length * 2];

      for (int dvd = 0; dvd < collection.length; dvd++)
         temp[dvd] = collection[dvd];

      collection = temp;
   }
}
