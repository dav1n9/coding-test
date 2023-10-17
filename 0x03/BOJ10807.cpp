#include <bits/stdc++.h>
using namespace std;

int n, x, v;

int main() {

    cin >> n;
    int arr[202] = {};
    for(int i = 0; i < n; i++) {
        cin >> x;
        arr[x + 100]++;
    }
    cin >> v;

    cout << arr[v + 100];

}