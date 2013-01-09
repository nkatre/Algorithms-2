/*
 * =====================================================================================
 *
 *       Filename:  substitute_key.cpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  12/18/2012 10:11:04 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */

#include <string>
#include <iostream>
#include <assert.h>

using namespace std;

struct Substitute {

    int getValue(string key, string code) const {
        int letters[26];
            
        for (int i = 0; i < 26; i ++) {
            letters[i] = -1;
        }   
                
        int multiplier = 1, output = 0;
                                 
        for (int i = 0; i < key.size() - 1; i++) {
            int index = (int)(key[i]) - 65;
            letters[index] = i+1;
        }
                        
        letters[(int)(key[9]) - 65] = 0;
                            
        for (int i = code.size() - 1; i >= 0; i--) {
            int val = letters[(int)(code[i]) - 65];
            if (val >= 0) {
                output += multiplier * val;
                multiplier*=10;
            }
        }
                                
        return output;
    }
};

int main() {
    Substitute *sub = new Substitute();
    assert (sub->getValue("TRADINGFEW","LGXWEV") == 709);
    assert (sub->getValue("ABCDEFGHIJ","XJ") == 0);
    assert (sub->getValue("CRYSTALBUM", "MMA") == 6);
    cout << "Passing All Tests" << endl;
}
