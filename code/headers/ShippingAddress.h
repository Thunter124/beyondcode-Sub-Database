#ifndef SHIPPINGADDRESS_H
#define SHIPPINGADDRESS_H

#include <string>
#include <cstring>
#include <sstream>
#include <stdlib.h>

using namespace std;


class ShippingAddress
{
    public:
        ShippingAddress(string name, string address, int copiesPerIssue){
            this->name = name;
            this->address = address;
            this->copiesPerIssue = copiesPerIssue;
        }

        string getName() const{
            return name;
        }
        string getAddress() const {
            return address;
        }
        int getCopiesPerIssue() const {
            return copiesPerIssue;
        }
        bool getIsInternational() const {
            return isInternational;
        }

        void setName(string name){
            this->name = name;
        }
        void setAddress(string address){
            this->address = address;
        }
        void setCopies(int copiesPerIssue){
            this->copiesPerIssue = copiesPerIssue;
        }
        void setIsInternational(bool b){
            this->isInternational = b;
        }
    private:
        string name;
        string address;
        int copiesPerIssue;
        bool isInternational;

        friend ostream &operator<<(ostream &out, const ShippingAddress &address){
            ostringstream convert;

            out << address.getName() + "\n";
            out << address.getAddress() + "\n";

            convert << address.getCopiesPerIssue();
            out << convert.str() + "\n";
            convert.str("");

            if(!address.getIsInternational()){
                out << "false\n";
            }else{
                out << "true\n";
            }

            return out;
        }

};

#endif // SHIPPINGADDRESS_H
