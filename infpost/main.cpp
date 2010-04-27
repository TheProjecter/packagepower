/* 
 * File:   main.cpp
 * Author: andrewwolff
 *
 * Created on 27 de abril de 2010, 0:58
 */
#include <iostream>
#include <stdlib.h>
#include <sstream>
#include <stack>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv)
{

    stack<char> op;
    string s;
    cout << "Escribe la expresion: ";
    getline(cin,s);
    istringstream in(s);
    char c;
    while (in >> c)
    {
        if (c == '+' || c == '-' || c== '*' || c == '/')
            op.push(c);
        else if (c== ')')
        {
            cout << op.top() << " ";
            op.pop();
        }
        else if(c >= '0' && c <= '9')
        {
            in.putback(c);
            int n;
            in >> n;
            cout << n << " ";
        }
    }

    cout << op.top() << endl;
    
}

