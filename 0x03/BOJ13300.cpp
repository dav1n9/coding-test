#include <bits/stdc++.h>
using namespace std;

int n, k;
int s, g;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> k;

    int girls[7] = {};
    int boys[7] = {};
    for(int i = 0; i < n; i++) {
        cin >> s >> g;
        if(s == 0) {
            girls[g-1]++;
        } else {
            boys[g-1]++;
        }
    }

    int room = 0;
    for(int i = 0; i < 7; i++) {
        room += (girls[i]+(k-1)) / k;
        room += (boys[i]+(k-1)) / k;
    }

    cout << room;
}