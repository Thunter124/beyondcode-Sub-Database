#include "Magazine.h"

#include<string>
#include<vector>
#include<iostream>


bool Magazine::removeAuthor(Subscriber author){

    for(unsigned int i = 0; i < authors.size(); ++i){
        Subscriber temp = authors.at(i);
        if(temp.getBillingAddress() == author.getBillingAddress() && temp.getBillingName() == author.getBillingName()){
            authors.erase(authors.begin() + i);
            return true;
        }
    }
    return false;

}

bool Magazine::removeAd(Subscriber ad){

    for(unsigned int i = 0; i < adCompanies.size(); ++i){
        Subscriber temp = adCompanies.at(i);
        if(temp.getBillingAddress() == ad.getBillingAddress() && temp.getBillingName() == ad.getBillingName()){
            adCompanies.erase(adCompanies.begin() + i);
            return true;
        }
    }
    return false;

}




