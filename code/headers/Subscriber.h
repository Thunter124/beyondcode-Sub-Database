#ifndef SUBSCIBER_H
#define SUBSCIBER_H

#include "ShippingAddress.h"
#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <sstream>
#include <stdlib.h>


using namespace std;

class Subscriber
{
    public:
        Subscriber(ShippingAddress address, string billingName, string billingAddress, int startingCopies);

        vector<ShippingAddress> getAddresses() const;

        void addAddress(ShippingAddress address);

        int getCopiesRemaining() const {
            return copiesRemaining;
        }

        void setCopiesRemaining(int val){
            this->copiesRemaining = val;
        }

        void incCopiesRemaining(){
            copiesRemaining++;
        }

        void decCopiesRemaining(){
            copiesRemaining--;
        }

        void setBillingAddress(string billingAddress){
            this->billingAddress = billingAddress;
        }

        string getBillingAddress() const {
            return billingAddress;
        }

        void setBillingName(string billingName){
            this->billingName = billingName;
        }

        string getBillingName() const {
            return billingName;
        }

        vector<string> getShippingLables();

    private:
        vector<ShippingAddress> addresses;
        int copiesRemaining;
        string billingAddress;
        string billingName;

    friend ostream &operator<<(ostream &out, const Subscriber &sub){
        ostringstream convert;

        out << sub.getBillingName() + "\n";
        out << sub.getBillingAddress() + "\n";

        convert << sub.getCopiesRemaining();
        out << convert.str() + "\n";
        convert.str("");

        //write size of addresses list
        int addressesSize = sub.getAddresses().size();
        convert << addressesSize;
        out << convert.str() + "\n";

        vector<ShippingAddress> addressList = sub.getAddresses();
        for(int i = 0; i < addressesSize; ++i){
            out << addressList.at(i);

        }

        return out;

    }
};

#endif // SUBSCIBER_H
