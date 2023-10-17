#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[11] = {};
    int a, b, c = 0;
    cin >> a >> b >> c;

    string mul = to_string(a*b*c);
    
    for(auto c : mul) {
        arr[c-'0']++;
    }

    for(int i = 0; i < 10; i++) {
        cout << arr[i] << '\n';
    }

}