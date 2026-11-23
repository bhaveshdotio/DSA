//using:SC:O(n)
class MinStack {
    Stack<int[]> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new int[]{value,value});
        }else{
            int min=Math.min(value,st.peek()[1]);
            st.push(new int[]{value,min});
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */