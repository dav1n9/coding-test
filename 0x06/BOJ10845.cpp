#include <bits/stdc++.h>
using namespace std;

int q[1000005];
int head, tail = 0;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    string result = "";

    while(N-- > 0) {
        string s;
        cin >> s;

        if(s == "push") {
            int a;
            cin >> a;
            q[tail++] = a;
        } else if (s == "pop") {
            if(tail-head == 0) cout <<  -1 << "\n";
            else  {
                cout << q[head] << "\n";
                head++;
            }
        } else if( s == "size") {
            cout << (tail-head) << "\n";
        } else if( s == "empty") {
            if(tail-head == 0) cout <<  1 << "\n";
            else cout <<  0 << "\n";
        } else if (s == "front") {
            if(tail-head == 0) cout <<  -1 << "\n";
            else cout <<  q[head] << "\n";
        } else {    // back
            if(tail-head == 0) cout <<  "-1\n";
            else cout <<  q[tail-1] << "\n";
        }
    }

    cout << result;
}