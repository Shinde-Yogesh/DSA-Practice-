package com.stack_program;
import java.util.Stack;
public class Delete_Middle_Element {


	
	 // Deletes middle of stack of size
    // n. Curr is current item number
    static void deleteMid(Stack<Integer> st,
                              int size, int curr)
    {
         
        // If stack is empty or all items
        // are traversed
        if (st.empty() || curr == size)
            return;
         
        // Remove current item
        int x = st.pop();
         
        // Remove other items
        deleteMid(st, size, curr+1);
         
        // Put all items back except middle
        if (curr != size/2)
            st.push(x);
    }
     
    // Driver function to test above functions
    public static void main(String args[]) 
    {
    	Stack<Integer> st = new Stack<Integer>();
		st.push(22);
		st.push(44);
		st.push(66);
		st.push(88);
		st.push(100);
		
        deleteMid(st, st.size(), 0);
     
        // Printing stack after deletion
        // of middle.
        while (!st.empty())
        {
            int p=st.pop();
            System.out.print(p + " ");
        }
    }
}
