#include <bits/stdc++.h>
using namespace std;

const int MX = 1000005;
int d[MX*2 + 1];
int head = MX, tail = MX;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    while(N--) {
        string s;
        cin >> s;

        if(s == "push_back") {
            int i;
            cin >> i;
            d[tail++] = i;
        } else if(s=="push_front") {
            int i;
            cin >> i;
            d[--head] = i;
        } else if(s=="pop_front") {
            if(head == tail) {
                cout << -1 << '\n';
            } else {
                cout << d[head] << '\n';
                head++;
            }
        } else if(s=="pop_back") {
            if(head == tail) {
                cout << -1 << '\n';
            } else {
                cout << d[tail-1] << '\n';
                tail--;
            }
        } else if(s=="size") {
            cout << tail - head << '\n';
        } else if(s=="empty") {
            if(head == tail) cout << 1 << '\n';
            else cout << 0 << '\n';
        } else if(s=="front") {
            if(head == tail)  cout << -1 << '\n';
            else cout << d[head] << '\n';
        } else {    // back
            if(head == tail)  cout << -1 << '\n';
            else cout << d[tail-1] << '\n';
        }
    }
}