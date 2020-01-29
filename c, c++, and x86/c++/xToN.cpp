#include <iostream>
using namespace std;

int xton(int base, int exp);
int main()
{
    int base, exp;
    cout << "Please enter base number: ";
    cin >> base;
    cout << "Please enter exponent number: ";
    cin >> exp;
    int result = xton(base, exp);
    cout << "Calulated result: " << result << endl;
    return 0;
}

int xton(int base, int exp)
{
    if (exp == 0)
        return 1;
    else
        return base * xton(base, exp-1);
}
