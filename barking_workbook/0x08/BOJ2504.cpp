#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    stack<int> st;
    for(auto a : s) {
        if(a == '(' || a == '[') {
            st.push(a);
        } else {
            if(!st.empty() && a == ')') {
                if(!st.empty() && st.top() == '(') {
                    st.pop();
                    st.push('2');
                } else if(!st.empty() && st.top() == '[') { // 올바르지 않은 경우
                    cout << 0;
                    return 0;
                } else { // 숫자가 있는 경우
                    //  '(' 또는 '[' 만날때까지 반복해야 함.
                    int a = (st.top() - '0');
                    st.pop();
                    while (!st.empty() && st.top() != '(' && st.top() != '[') {
                        a += (st.top() - '0');
                        st.pop();
                    }
                    if(!st.empty() && st.top() == '(') {
                        st.pop();
                        st.push(2*a + '0');
                    } else if(st.empty() || st.top() == '[') {
                        cout << 0;
                        return 0;
                    }
                }
            } else if (!st.empty() && a == ']') {
                if(!st.empty() && st.top() == '[') { 
                    st.pop();
                    st.push('3');
                } else if(!st.empty() && st.top() == '(') { // 올바르지 않은 경우
                    cout << 0;
                    return 0;
                } else { // 숫자가 있는 경우
                    //  '(' 또는 '[' 만날때까지 반복해야 함.
                    int a = (st.top() - '0');
                    st.pop();
                    while (!st.empty() && st.top() != '(' && st.top() != '[') {
                        a += (st.top() - '0');
                        st.pop();
                    }
                    if(!st.empty() && st.top() == '[') {
                        st.pop();
                        st.push(3*a + '0');
                    } else if(st.empty() || st.top() == '(') {
                        cout << 0;
                        return 0;
                    }
                }
            } else if ((st.empty() && a == ']') || (st.empty() && a == ')')) {
                cout << 0;
                return 0;
            }
        }

    }

    long result = 0;
    while (!st.empty()) {
        if(st.top() == '(' || st.top() == '[' || st.top() == ']' || st.top() == ')') {
            cout << 0;
            return 0;
        } else {
            result += (st.top() - '0');
            st.pop();
        }
    }
    cout << result;
}