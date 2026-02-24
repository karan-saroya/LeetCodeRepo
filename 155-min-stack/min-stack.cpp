class MinStack {
public:
    vector<int> stack_normal, min_stack;
    MinStack() {
        
    }
    
    void push(int val) {
        stack_normal.push_back(val);
        if(min_stack.size())
        {
            if(val<= min_stack[min_stack.size() -1])
                min_stack.push_back(val);
        }
        else
            min_stack.push_back(val);
    }
    
    void pop() {
        int val = stack_normal.back();
        stack_normal.pop_back();
        if( val == min_stack.back())
        {
            min_stack.pop_back();
        }

    }
    
    int top() {
        return stack_normal.back();
    }
    
    int getMin() {
        return *(min_stack.rbegin());
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */