#include <bits/stdc++.h>
using namespace std;

const int MX = 1000005;
// 코딩테스트에서만 사용할 목적으로
// 만드는 야매 연결 리스트임.
int dat[MX], pre[MX], nxt[MX];
int unused = 1;

void insert(int addr, int num){
    dat[unused] = num;
    pre[unused] = addr;
    nxt[unused] = nxt[addr];

    // 맨 마지막 원소의 뒤에 새 원소를 추가하는 상황에서 pre[-1]에 접근하지 못하도록.
    if (nxt[addr] != -1 ) pre[nxt[addr]] = unused;
    nxt[addr] = unused;

    unused++;
}

void erase(int addr){
    
    // dummy node의 존재로 인해 그 어떤 원소를 지우더라도 pre[addr]은 -1이 아님이 보장됨.
    nxt[pre[addr]] = nxt[addr];
    
    if (nxt[addr] != -1 ) pre[nxt[addr]] = pre[addr];

}

void traverse(){
  int cur = nxt[0];
  while(cur != -1){
    cout << dat[cur] << ' ';
    cur = nxt[cur];
  }
  cout << "\n\n";
}

void insert_test(){
  cout << "****** insert_test *****\n";
  insert(0, 10); // 10(address=1)
  traverse();
  insert(0, 30); // 30(address=2) 10
  traverse();
  insert(2, 40); // 30 40(address=3) 10
  traverse();
  insert(1, 20); // 30 40 10 20(address=4)
  traverse();
  insert(4, 70); // 30 40 10 20 70(address=5)
  traverse();
}

void erase_test(){
  cout << "****** erase_test *****\n";
  erase(1); // 30 40 20 70
  traverse();
  erase(2); // 40 20 70
  traverse();
  erase(4); // 40 70
  traverse();
  erase(5); // 40
  traverse();
}

int main(void) {
  fill(pre, pre+MX, -1);
  fill(nxt, nxt+MX, -1);
  insert_test();
  erase_test();
}