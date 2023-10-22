#include <bits/stdc++.h>
using namespace std;

int N, M;
int a;
int popCheck[51] = {};

int popCount(int from, int to) {
    int result = 0;
    for(int i = from; i <= to; i++) {
        if(popCheck[i]==0) result++;
    }
    return result;
}

// 왼쪽으로 이동 길이
int leftLength(int from, int to) {
    if (from >= to) {
        return from - to - (popCount(to, from));
    } else {
        return from - (popCount(1, from))+ (N - to) - (popCount(to, N));
    }
}
// 오른쪽으로 이동 길이
int rightLength(int from, int to)  {
    if (from <= to) {
        return to - from - (popCount(from, to));
    } else {
        return (N- from) - (popCount(from, N)) + to - (popCount(1, to));
    }
}


int main() {

    ios::sync_with_stdio(0);
    cin.tie(0);

    deque<int> dq;
    int result = 0;
    
    cin >> N >> M;
    for(int i = 1; i <= N; i++) {
        dq.push_back(i);
        popCheck[i] = i;
    }

    
    // 뽑아내려고 하는 수의 위치 입력받고 찾기
    for(int i = 0; i < M; i++) {
        cin >> a;

        while(dq.front() != a) {
            int r = 0, l = 0;
            if (!dq.empty()) {
                // 오른쪽이 가까운지 왼쪽이 가까운지 판별.
                r = rightLength(dq.front(), a);
                l = leftLength(dq.front(), a);
            }

            if(r > l) { // to left
                dq.push_front(dq.back());
                dq.pop_back();
            } else {    // to right
                dq.push_back(dq.front());
                dq.pop_front();
            }
            result++;
        }

        if(dq.front() == a) {
            popCheck[dq.front()] = 0;
            dq.pop_front();
        } 
    }

    cout << result;
}