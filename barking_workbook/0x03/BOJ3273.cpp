#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, x = 0;

    cin >> n;

    int arr[n+1] = {};
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cin >> x;


    int count[2000001] = {};
    int result = 0;
    for(int i = 0; i < n; i++) {
        if(x - arr[i] > 0 && count[x - arr[i]] > 0) {
            result++;
        }
        count[arr[i]]++;
    }

    cout << result;
}