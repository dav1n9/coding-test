#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    int result = 0;

    while(N--) {
        stack<char> st;

        string s;
        cin >> s;

        for(auto a : s) {
            if(st.empty() || st.top() != a) {
                st.push(a);
            } else if (st.top() == a){
                st.pop();
            }
        }

        if(st.empty()) {
            result++;
        }
    }

    cout << result;
}