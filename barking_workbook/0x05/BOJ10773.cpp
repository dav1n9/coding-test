#include <bits/stdc++.h>
using namespace std;

int K, i;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> K;

    stack<int> s;

    while (K-- > 0) {
        cin >> i;
        if(i == 0) {
            s.pop();
        } else {
            s.push(i);
        }
    }

    int result = 0;
    while(!s.empty()) {
        result += s.top();
        s.pop();
    }

    cout << result;
}