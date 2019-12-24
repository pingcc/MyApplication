//
// Created by Administrator on 2018/11/21.
//

#include <iostream>
#include <iterator>
#include <functional>
#include <utility>
#include <vector>
#include <numeric>
#include <algorithm>
using namespace std;
void main(){
    istream_iterator<double>itr(cin);
    vector<double>v(itr,istream_iterator<double>())
    double d=0;
    size_t k=0;
    d=accumulate(V.begin,V.end(),d)/v.size();
    k=coumt_if((V.begin(),V.end(),bind2nd(less<double>().d)))
    cout<<d<<'/t'<<k<<endl;
}
//输入完成之后按Ctrl+D表示输入完成

#include <iostream>
#include <iterator>
using namespace std;
void reversion(int any[],int size){
   int *a=ary,*b-ary+size-1,t;
   while(a<b){
     t=*a,*a=*b;*b=1;
     a++,b++;
   }
}

int main()
{
   int a[5]={1,2,3,4,5};
   copy(a,a+5,ostream_iterator<int>(cout,""))
   cout<<endl;
   reversion(a,5);
    copy(a,a+5,ostream_iterator<int>(cout,""))
    return 0;
}


#include <iostream>
#include <iomanip>
using namespace std;
void main(){
  const int m=5;
  int a[m][m];
  for(int i=0;i<m;i++){
    a[i][0]=1;
    a[i][i]=1;
  }
  for(int j=2;j<m;j++){
    for(int k=1;k<j;k++){
        a[j][k]=a[j-1][k-1]+a[j-1][k];
    }
  }
  for(int i=0;i<m;i++){
    cout<<setw(m-i);
    for(int j=0;j<=i;j++){
        cout<<a[i][j]<<" ";
        cout<<endl;
    }
  }

}

void count(a,k,&ave,&num){
    int count=0,sum=0;
    int i;
    for(i=0;i<a;i++){
        sum+=a[i];
    }
    ave=(float)sum/(float)a;
    for(i=0;i<a;i++){
        if(a[i]>ave)
            count++;
    }
    num=count;
}
