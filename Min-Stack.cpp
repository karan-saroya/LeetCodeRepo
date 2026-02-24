1class MinStack {
2public:
3    vector<int> stack_normal, min_stack;
4    MinStack() {
5        
6    }
7    
8    void push(int val) {
9        stack_normal.push_back(val);
10        if(min_stack.size())
11        {
12            if(val<= min_stack[min_stack.size() -1])
13                min_stack.push_back(val);
14        }
15        else
16            min_stack.push_back(val);
17    }
18    
19    void pop() {
20        int val = stack_normal.back();
21        stack_normal.pop_back();
22        if( val == min_stack.back())
23        {
24            min_stack.pop_back();
25        }
26
27    }
28    
29    int top() {
30        return stack_normal.back();
31    }
32    
33    int getMin() {
34        return *(min_stack.rbegin());
35    }
36};
37
38/**
39 * Your MinStack object will be instantiated and called as such:
40 * MinStack* obj = new MinStack();
41 * obj->push(val);
42 * obj->pop();
43 * int param_3 = obj->top();
44 * int param_4 = obj->getMin();
45 */