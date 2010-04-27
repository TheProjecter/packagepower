/* 
 * File:   main.cpp
 * Author: andrewwolff
 *
 * Created on 27 de abril de 2010, 0:40
 */

#include <stdlib.h>
#include <iostream>
#include <sstream>
#include <stack>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv)
{
    stack<double> oprnd;
    string input;
    bool quit = false;
    double x,y;

    while(!quit)
    {
        cout << "RPN> ";//Prompt del usuario
        cin >> input;
        switch(input[0])
        {
            case 'Q': case 'q':
                quit = true;
                break;
            case '+':
                y=oprnd.top();
                oprnd.pop();
                x=oprnd.top();
                oprnd.pop();
                cout<< "\t" << x << "+" << y << " = " << x+y << "\n";
                oprnd.push(x+y);
                break;
            case '-':
                y=oprnd.top();
                oprnd.pop();
                x=oprnd.top();
                oprnd.pop();
                cout<< "\t" << x << "-" << y << " = " << x-y << "\n";
                oprnd.push(x-y);
                break;
            case '*':
                y=oprnd.top();
                oprnd.pop();
                x=oprnd.top();
                oprnd.pop();
                cout<< "\t" << x << "*" << y << " = " << x*y << "\n";
                oprnd.push(x*y);
                break;
            case '/':
                y=oprnd.top();
                oprnd.pop();
                x=oprnd.top();
                oprnd.pop();
                cout<< "\t" << x << "/" << y << " = " << x/y << "\n";
                oprnd.push(x/y);
                break;
            default:
                istringstream in(input);//convierte la entrada input a flujo "stream"
                in >> x;
                oprnd.push(x);
        }
    }
    
}

