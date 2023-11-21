#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    queue<int> q;

    while(N--) {
        string s;
        cin >> s;
        if(s=="push") {
            int i;
            cin >> i;
            q.push(i);
        } else if (s=="pop") {
            if(!q.empty()) {
                cout << q.front() << '\n';
                q.pop();
            } else cout << -1 << '\n';
        } else if(s=="size") {
            cout << q.size() << '\n';
        } else if(s=="empty") {
            cout << q.empty() << '\n';
        } else if(s=="front") {
            if(!q.empty()) {
                cout << q.front() << '\n';
            } else cout << -1 << '\n';
        } else {
            if(!q.empty()) {
                cout << q.back() << '\n';
            } else cout << -1 << '\n';
        }
    }
}