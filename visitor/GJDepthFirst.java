//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;
import java.io.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() )
         return n.node.accept(this,argu);
      else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }
   String token = "NUll";
   public R visit(NodeToken n, A argu) { 
      token = n.tokenImage;
      return null; 
   }

   //
   // User-generated visitor methods below
   //

   char id = 'a';
   StringBuffer decl =new StringBuffer();
   StringBuffer sb = new StringBuffer();
   StringBuffer temp = new StringBuffer();
   String datatype;
   String explist = "";
   String expression="";
   //Hashtable hash= new Hashtable<String,String> ();
   int random = 1;
   
   public String key(){
      String s = "var"+(random++);
      
      return s; 
   }

   /**
    * f0 -> MainClass()
    * f1 -> ( TypeDeclaration() )*
    * f2 -> <EOF>
    */
   public R visit(Goal n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> "public"
    * f4 -> "static"
    * f5 -> "void"
    * f6 -> "main"
    * f7 -> "("
    * f8 -> "String"
    * f9 -> "["
    * f10 -> "]"
    * f11 -> Identifier()
    * f12 -> ")"
    * f13 -> "{"
    * f14 -> PrintStatement()
    * f15 -> "}"
    * f16 -> "}"
    */
   public R visit(MainClass n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String var = token;
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      String var2 = token;
      n.f12.accept(this, argu);
      n.f13.accept(this, argu);
      //StringBuffer sb = new StringBuffer();      

      //*System.out.println("class "+ var +"{\npublic static void main(String[] "+ var2 +"){");
      sb.append("class "+ var +"{\npublic static void main(String[] "+ var2 +"){");                    //appending
      int len = sb.length();
      n.f14.accept(this, argu);  
      n.f15.accept(this, argu);
      n.f16.accept(this, argu);

      //*System.out.println("}\n}");
      sb.append("}\n}");                                        //appending

      sb.insert(len,decl.toString());
      
      System.out.print("\n\n"+sb+"\n\n");
      decl = new StringBuffer();

      return _ret;
   }

   /**
    * f0 -> ClassDeclaration()
    *       | ClassExtendsDeclaration()
    */
   public R visit(TypeDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( VarDeclaration() )*
    * f4 -> ( MethodDeclaration() )*
    * f5 -> "}"
    */
   public R visit(ClassDeclaration n, A argu) {
      sb.delete(0, sb.length());
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String var = token;
      n.f2.accept(this, argu);
      
      //*System.out.println("class "+var+"{");
      sb.append("class "+var+"{");              //append
      n.f3.accept(this, argu);
      int len = sb.length();
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      
      //*System.out.println("}");
      sb.append("}");                           //append
      sb.insert(len,decl.toString());
      System.out.print("\n\n"+sb+"\n\n");

      decl.delete(0, decl.length());
      return _ret;
   }

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "extends"
    * f3 -> Identifier()
    * f4 -> "{"
    * f5 -> ( VarDeclaration() )*
    * f6 -> ( MethodDeclaration() )*
    * f7 -> "}"
    */
   public R visit(ClassExtendsDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String var = token;
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      String var2 = token;
      n.f4.accept(this, argu);
      //System.out.println("class "+var+"extends "+var2+"{");
      sb.append("class "+var+"extends "+var2+"{");            //appending 
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      //System.out.println("}");
      
      sb.append("}");
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public R visit(VarDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String type = token;
      n.f1.accept(this, argu);
      String var = token;
      n.f2.accept(this, argu);
      
      if(type=="]")
         type="int[]";
      //System.out.println(type+" "+ var + ";");
      sb.append(type+" "+ var + ";\n");                     //appending
      return _ret;
   }

   /**
    * f0 -> "public"
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> "{"
    * f7 -> ( VarDeclaration() )*
    * f8 -> ( Statement() )*
    * f9 -> "return"
    * f10 -> Expression()
    * f11 -> ";"
    * f12 -> "}"
    */
   public R visit(MethodDeclaration n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String type = token; 
      n.f2.accept(this, argu);
      String var = token;
      n.f3.accept(this, argu);
      
      //System.out.print("public "+ type + " " + var +"( ");
      sb.append("public "+ type + " " + var +"( ");            //appending
      n.f4.accept(this, argu);

      sb.append("){");                                         //appending
      //*System.out.println("){");
      
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);
      n.f9.accept(this, argu);
      R s = n.f10.accept(this,argu);
      //*System.out.println("return "+s+";\n}");
      sb.append("return "+s+";\n}");                           //appending
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public R visit(FormalParameterList n, A argu) {
      R _ret=null;
      n.f0.accept(this, (A)"");
      n.f1.accept(this, (A)",");
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public R visit(FormalParameter n, A argu) {
      R _ret = null;
      n.f0.accept(this, argu);
      String type = token; 
      n.f1.accept(this, argu);
      String var = token;
      //*System.out.print(argu+""+type+" "+var);
      
      sb.append(argu+""+type+" "+var);
      return _ret; 
   }

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public R visit(FormalParameterRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> ArrayType()
    *       | BooleanType()
    *       | IntegerType()
    *       | Identifier()
    */
   public R visit(Type n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "int"
    * f1 -> "["
    * f2 -> "]"
    */
   public R visit(ArrayType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "boolean"
    */
   public R visit(BooleanType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "int"
    */
   public R visit(IntegerType n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Block()
    *       | AssignmentStatement()
    *       | ArrayAssignmentStatement()
    *       | FieldAssignmentStatement()
    *       | IfStatement()
    *       | WhileStatement()
    *       | ForStatement()
    *       | PrintStatement()
    */
   public R visit(Statement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( Statement() )*
    * f2 -> "}"
    */
   public R visit(Block n, A argu) {
      R _ret=null;
      //*System.out.println("{");
      sb.append("{");
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      //*System.out.println("}");
      sb.append("}");
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public R visit(AssignmentStatement n, A argu) {
      //System.out.println("assignment********");
      R _ret=null;
      n.f0.accept(this, argu);
      String var = token;
      n.f1.accept(this, argu);
      R s = n.f2.accept(this, argu);
      n.f3.accept(this, argu);

      //*System.out.println(var+"="+s+";");
      sb.append(var+"="+s+";");                           //appending
      
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> "["
    * f2 -> Expression()
    * f3 -> "]"
    * f4 -> "="
    * f5 -> Expression()
    * f6 -> ";"
    */
   public R visit(ArrayAssignmentStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String var = token;
      n.f1.accept(this, argu);
      
      R s1 = n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      R s2 = n.f5.accept(this, argu);
      n.f6.accept(this, argu);

      //*System.out.println(var+"["+s1+"] = "+s2+";");
      sb.append(var+"["+s1+"] = "+s2+";");                       //appending
      return _ret;
   }

   /**
    * f0 -> Expression()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "="
    * f4 -> Expression()
    * f5 -> ";"
    */
   public R visit(FieldAssignmentStatement n, A argu) {
      R _ret=null;

      R s1 = n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      String var = token;
      n.f3.accept(this, argu);
      R s2 = n.f4.accept(this, argu);
      n.f5.accept(this, argu);

      //*System.out.println(s1+"."+var+"="+s2+";");
      sb.append(s1+"."+var+"="+s2+";");                        //appending

      return _ret;
   }

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> "else"
    * f6 -> Statement()
    */
   public R visit(IfStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      R s = n.f2.accept(this, (A)"1");
      n.f3.accept(this, argu);
      
      //*System.out.print("if("+s+"){\n\t");
      sb.append("if("+s+"){\n\t");                              //appending
      
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      
      //*System.out.print("}else{\n\t");
      sb.append("}else{\n\t");

      n.f6.accept(this, argu);
      
      //*System.out.print("}");
      sb.append("}");
      return _ret;
   }

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public R visit(WhileStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);

      //*System.out.print("while("+s1+"){"+expression);
      sb.append("while(");
      int len=sb.length();
      sb.append("){");
      R s1 = n.f2.accept(this, argu);
      sb.insert(len, s1);
      sb.append(expression);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      //*System.out.println("}");
      sb.append("}");
      return _ret;
   }

   /**
    * f0 -> "for"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> "="
    * f4 -> Expression()
    * f5 -> ";"
    * f6 -> Expression()
    * f7 -> ";"
    * f8 -> Identifier()
    * f9 -> "="
    * f10 -> Expression()
    * f11 -> ")"
    * f12 -> Statement()
    */

   public R visit(ForStatement n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      String var = token;             //Identifier
      n.f3.accept(this, argu);
      R s1 = n.f4.accept(this, argu); //EXP
      n.f5.accept(this, argu);
      R s2 = n.f6.accept(this, argu); //EXP
      n.f7.accept(this, argu);
      n.f8.accept(this, argu);        //Identifier
      String var2 =token;
      n.f9.accept(this, argu);
      R s4 = n.f10.accept(this, argu); //EXP
      n.f11.accept(this, argu);
      System.out.println("for("+var+"="+s1+";"+s2+";"+var2+"="+s4+"){");
      n.f12.accept(this, argu);
      System.out.println("}");
      
      return _ret;
   }

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> ";"
    */
   public R visit(PrintStatement n, A argu) {
      R _ret= null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      R s = n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      //*System.out.println("System.out.println("+s+");");
      sb.append("System.out.println("+s+");");
      return _ret;
   }

   /**
    * f0 -> AndExpression()
    *       | CompareExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | ArrayLookup()
    *       | ArrayLength()
    *       | MessageSend()
    *       | PrimaryExpression()
    */
   public R visit(Expression n, A argu) {
      //System.out.println("**********exp*********");
      R _ret=null;
      R s1 = n.f0.accept(this, argu);
      return s1;                                //returning the variable
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "&"
    * f2 -> PrimaryExpression()
    */
   public R visit(AndExpression n, A argu) {     
      R _ret=null;
      R a,b;
      a = n.f0.accept(this, argu);
      
      datatype = "int";                             //variable declaration
      ++id;
      String s = key();
      //*System.out.println(datatype+" "+s+";");
      decl.append(datatype+" "+s+";");             //var dec push to SB

      n.f1.accept(this, argu);
      b = n.f2.accept(this, argu);
      //*System.out.println(s + "=" + a + "&" + b+";");
      sb.append(s + "=" + a + "&" + b+";");        //appending
      expression = s + "=" + a + "&" + b+";";
      return (R)s;                                 //returning the variable
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "<"
    * f2 -> PrimaryExpression()
    */
   public R visit(CompareExpression n, A argu) {
      R _ret=null;
      R a,b;
      a = n.f0.accept(this, argu);
      
      datatype = "boolean";
      //++id;
      String s = key();
      //*System.out.println(datatype+" "+s+";");
      decl.append(datatype+" "+s+";");             //var dec push to SB

      n.f1.accept(this, argu);
      b = n.f2.accept(this, argu);
      //*System.out.println(s + "=" + a + "<" + b+";");
      sb.append(s + "=" + a + "<" + b+";");        //appending
      expression = s + "=" + a + "<" + b+";";
      return (R)s;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> PrimaryExpression()
    */
   public R visit(PlusExpression n, A argu) {
      R _ret=null;
      R a,b;
      a = n.f0.accept(this, argu);
      
      datatype = "int";
      String s = key();
      //*System.out.println(datatype+" "+s+";");
      decl.append(datatype+" "+s+";");             //var dec push to SB
      
      n.f1.accept(this, argu);
      b = n.f2.accept(this, argu);
      //*System.out.println(s + "=" + a + "+" + b+";");
      sb.append(s + "=" + a + "+" + b+";");

      expression = s + "=" + a + "<" + b+";";
      
      return (R)s;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> PrimaryExpression()
    */
   public R visit(MinusExpression n, A argu) {
      R _ret=null;
      R a,b;
      a = n.f0.accept(this, argu);
      
      datatype = "int";

      String s = key();
      //*System.out.println(datatype+" "+s+";");
      decl.append(datatype+" "+s+";");             //var dec push to SB      
      
      n.f1.accept(this, argu);
      b = n.f2.accept(this, argu);
      //*System.out.println(s + "=" + a + "-" + b+";");
      sb.append(s + "=" + a + "-" + b+";");        //appending

      expression = s + "=" + a + "-" + b+";";

      return (R)s;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> PrimaryExpression()
    */
   public R visit(TimesExpression n, A argu) {

      //System.out.println("*******times exp*************");
      R a,b;
      R _ret=null;
      a = n.f0.accept(this, argu);
      
      datatype = "int";
      ++id;
      String s = key();
      //*System.out.println(datatype+" "+s+";");
      decl.append(datatype+" "+s+";");             //var dec push to SB
      
      n.f1.accept(this, argu);
      b = n.f2.accept(this, argu);
      //*System.out.println(s + "=" + a + "*" + b+";");
      sb.append(s + "=" + a + "*" + b+";");        //appending

      expression = s + "=" + a + "*" + b+";";

      return (R)s;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> PrimaryExpression()
    * f3 -> "]"
    */
   public R visit(ArrayLookup n, A argu) {
      R _ret=null;
      R s1 = n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      R s2 = n.f2.accept(this, argu);
      n.f3.accept(this, argu);

      datatype = "int";

      String s = key();
      //*System.out.println(datatype+" "+s+";");
      decl.append(datatype+" "+s+";");             //var dec push to SB

      //*System.out.println(s +" = "+s1+"["+s2+"];");
      sb.append(s +" = "+s1+"["+s2+"];");         //appending

      expression = s +" = "+s1+"["+s2+"];";

      return (R)s;
   }

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> "length"
    */
   public R visit(ArrayLength n, A argu) {
      R _ret=null;
      R s1 = n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);

      datatype = "int";
      
      String s = key();
      //*System.out.println(datatype+" "+s+";");
      decl.append(datatype+" "+s+";");             //var dec push to SB

      //*System.out.println(s+" = "+s1+".length;");
      sb.append(s+" = "+s1+".length;");            //appending
      expression = s+" = "+s1+".length;";

      return (R)s;
   }
//doubt
   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( ExpressionList() )?
    * f5 -> ")"
    */

   public R visit(MessageSend n, A argu) {
      R _ret=null;

      R s1 = n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      String var = token;

      n.f3.accept(this, argu);

      datatype = "int";
      ++id;
      String s = key();
      //*System.out.println(datatype+" "+s+";");
      decl.append(datatype+" "+s+";");                          //var dec push to SB
      explist="";
      n.f4.accept(this, argu);
      //*System.out.println   (s+" = "+s1+"."+var+"("+explist+");");
      sb.append(s+" = "+s1+"."+var+"("+explist+");");           //appending
      n.f5.accept(this, argu);

      expression = s+" = "+s1+"."+var+"("+explist+");";

      return (R)s;
   }

   /**
    * f0 -> Expression()
    * f1 -> ( ExpressionRest() )*
    */
   public R visit(ExpressionList n, A argu) {
      R _ret=null;
      explist="     ";
      R s1 = n.f0.accept(this, argu);
      if(s1!=null)
      {
         //System.out.print(s1);
         explist=explist+s1;
      }
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public R visit(ExpressionRest n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      R s1 = n.f1.accept(this, argu);
      //System.out.print(","+s1);
      explist=explist+","+s1;
      return _ret;
   }

   /**
    * f0 -> IntegerLiteral()
    *       | TrueLiteral()
    *       | FalseLiteral()
    *       | Identifier()
    *       | ThisExpression()
    *       | ArrayAllocationExpression()
    *       | AllocationExpression()
    *       | NotExpression()
    *       | BracketExpression()
    */
   public R visit(PrimaryExpression n, A argu) {
      R _ret=null;
      _ret = n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      
      String s = key();
      //*System.out.println("int "+s+";");
      decl.append("int "+s+";");                  //appending
      //*System.out.println(s+" = "+token+";");
      sb.append(s+" = "+token+";");               //appending
      return (R)s;
   }

   /**
    * f0 -> "true"
    */
   public R visit(TrueLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      
      String s = key();
      //*System.out.println("int "+s+";");
      decl.append("int "+s+";");                   //appending
      //*System.out.println(s+" = true;");
      sb.append(s+" = true;");                      //appending
      return (R)s;
   }

   /**
    * f0 -> "false"
    */
   public R visit(FalseLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      
      String s = key();
      //*System.out.println("int "+s+";");
      decl.append("int "+s+";");                  //appending
      //*System.out.println(s+" = false;");
      sb.append(s+" = false;");                    //appending
      return (R)s;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)token;
   }

   /**
    * f0 -> "this"
    */
   public R visit(ThisExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)token;
   }

   /**
    * f0 -> "new"
    * f1 -> "int"
    * f2 -> "["
    * f3 -> Expression()
    * f4 -> "]"
    */
   public R visit(ArrayAllocationExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);

      String a = key();
      //*System.out.println("int "+a+";");
      decl.append("int[] "+a+";");               //var dec push to SB

      R s1 = n.f3.accept(this, argu);
      //*System.out.println(a+" = new int["+s1+"];");
      sb.append(a+" = new int["+s1+"];");
      n.f4.accept(this, argu);                  //appending
      
      return (R)a;
   }

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> ")"
    */
   public R visit(AllocationExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String type=token;
      ++id;
      String a = key();
      //*System.out.println(type+" "+a+";");
      decl.append(type+" "+a+";");                 //var dec push to SB

      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      //*System.out.println(a+" = new "+type+"();");
      sb.append(a+" = new "+type+"();");           //appending
      return (R)a;
   }

   /**
    * f0 -> "!"
    * f1 -> ( MessageSend() | PrimaryExpression() )
    */
   public R visit(NotExpression n, A argu) {
      R _ret=null;
      R s;
      
      ++id;
      String a = key();
      String type ;
      if(argu=="1")
         type="boolean";
      else
         type="int";

      //*System.out.println("boolean "+a+";");
      decl.append(type+" "+a+";");                 //var dec push to SB

      s = n.f0.accept(this, argu);
      s = n.f1.accept(this, argu);

      //*System.out.println(s+" = !"+s);
      sb.append(s+" = !"+s+";");                        //appending

      return (R)s;
   }

   /**
    * f0 -> "("
    * f1 -> Expression()
    * f2 -> ")"
    */
   public R visit(BracketExpression n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      R s =n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      
      return (R)s;
   }

}