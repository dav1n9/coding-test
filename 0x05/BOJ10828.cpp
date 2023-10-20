#include <bits/stdc++.h>
using namespace std;

int N;
string c;
int i;

const int MX = 1000005;
int dat[MX];
int idx = 0;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    while (N > 0) {
        cin >> c;
        if (c == "push") {
            cin >> i;
            dat[idx++] = i;
        } else if (c == "top") {
            if(idx == 0) {
                cout << -1 << "\n";
            } else {
                cout << dat[idx-1] << "\n";
            }
        } else if(c == "size") {
            cout << idx << "\n";
        } else if (c == "empty") {
            if(idx == 0) {
                cout << 1 << "\n";
            } else {
                cout << 0 << "\n";
            }
        } else { // pop
            if(idx == 0) {
                cout << -1 << "\n";
            } else {
                cout << dat[idx-1] << "\n";
                idx--;
            }
        }

        N--;
    }

}