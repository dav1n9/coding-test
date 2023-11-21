#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    bool wasPoped = false;  // 이전에 레이저였는지
    stack<char> st;
    int result = 0;

    for(auto a : s) {
        if(a=='(') {
            st.push(a);
            wasPoped = false;
        } else {  //  ')' 인 경우
            if(!st.empty()) {
                if(!wasPoped && st.top()=='(') {  // 레이저인 경우
                   st.pop();
                   result += st.size();
                   wasPoped = true;
                } else if (wasPoped) {  // 짝 찾은 경우
                   st.pop();
                   result++;
                   wasPoped = true; 
                }
            }
        }
    }

    cout << result;
}