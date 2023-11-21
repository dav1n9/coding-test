#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[11] = {};
    int a;
    cin >> a;

    while (a > 0) {
        if(a%10 == 9) {
            arr[6]++;
        } else {        
            arr[a%10]++;
        }
        a = a/10;
    }
    
    arr[6] = (arr[6] + 1) / 2;

    int max = 0;
    for(int i = 0; i < 10; i++) {
        if(arr[i] > max)
            max = arr[i];
    }

    cout << max;
}