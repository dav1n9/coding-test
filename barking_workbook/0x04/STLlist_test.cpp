#include <bits/stdc++.h>
using namespace std;

int main() {

    list<int> L = {1, 2};
    
    // auto t = L.begin();
    list<int>::iterator t = L.begin(); 
    *t = 100;

    list<int>::iterator e = L.end();

    L.push_front(10);

    // end()가 가리키고 있는 것은 맨 마지막 원소의 바로 다음번 원소임
    cout << *e << '\n';
    e--;
    cout << *e << '\n';
    
    for(auto a : L)
        cout << a << ' ';

    // 위의 출력문과 동일
    for(list<int>::iterator i = L.begin(); i != L.end(); i++) {
        cout << *i << ' ';
    }
 }