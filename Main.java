import syntaxtree.*;
import visitor.*;

public class P2 {
   public static void main(String [] args) {
      try {
         Node root = new BuritoJavaParser(System.in).Goal();
	 GJDepthFirst<String,String> obj = new GJDepthFirst<String,String>();
//         System.out.println("Program parsed successfully");
         root.accept(obj,"s"); // Your assignment part is invoked here.
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 

