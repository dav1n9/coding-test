#include <bits/stdc++.h>
using namespace std;


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    
    while(true) {
        bool output = false;
        stack<char> st;
        getline(cin , s);

        if(s==".") {
            break;
        }

        for(char a : s) {
            if(a == '(' || a == '[') {
                st.push(a);
            } else if(a == ')') {
                if(!st.empty() && st.top() == '(') {
                    st.pop();
                } else {
                    output = true;
                    cout << "no" << '\n';
                    break;
                }
            } else if (a == ']') {
                if(!st.empty() && st.top() == '[') {
                    st.pop();
                } else {
                    output = true;
                    cout << "no" << '\n';
                    break;
                }
            }
        }
        if(!output) {
            if(st.empty()) {
                cout << "yes" << '\n';
            } else {
                cout << "no" << '\n';
            }
        }
        
    }
}