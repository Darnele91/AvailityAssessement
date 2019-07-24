import java.util.Scanner;

public class LispCode {
	
	
	
    static boolean isMatchingPair(char character1, char character2) 
    { 
       if (character1 == '(' && character2 == ')') 
         return true; 
       else
         return false; 
    } 
      
    /* Return true if expression has balanced  
       Parenthesis */
    static boolean areParenthesisBalanced(String code)
    { 
    	/*convert the string to an array of char*/
    	char[] codeChar = code.toCharArray();
    	
       /* Declare an empty character stack */
       Stack stack = new Stack(); 
       
       /* Traverse the given expression to  
          check matching parenthesis */
       for(int i=0;i<codeChar.length;i++) 
       { 
            
          /*If the exp[i] is a starting  
            parenthesis then push it*/
          if (codeChar[i] == '(') 
        	  stack.push(codeChar[i]); 
       
          /* If exp[i] is an ending parenthesis  
             then pop from stack and check if the  
             popped parenthesis is a matching pair*/
          if (codeChar[i] == ')') 
          { 
                   
              /* If we see an ending parenthesis without  
                 a pair then return false*/
             if (stack.isEmpty()) 
               { 
                   return false; 
               }  
       
             /* Pop the top element from stack, if  
                it is not a pair parenthesis of character  
                then there is a mismatch. This happens for  
                expressions like {(}) */
             else if ( !isMatchingPair(stack.pop(), codeChar[i]) ) 
               { 
                   return false; 
               } 
          } 
            
       } 
          
       /* If there is something left in expression  
          then there is a starting parenthesis without  
          a closing parenthesis */
        
       if (stack.isEmpty()) 
         return true;/*balanced*/
       else
         {   /*not balanced*/
             return false; 
         }  
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please enter a string to validate de parentheses");
		Scanner keyboard = new Scanner(System.in);
		String validateString = keyboard.next();
		System.out.println(areParenthesisBalanced(validateString));
		keyboard.close();
	} 

}
