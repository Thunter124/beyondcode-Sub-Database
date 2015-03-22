#include "Subscriber.h"
#include <string>
#include <vector>

using namespace std;

Subscriber::Subscriber(ShippingAddress address, string billingName, string billingAddress, int startingCopies)
{
    addresses.push_back(address);
    this->billingName = billingName;
    this->billingAddress = billingAddress;
    copiesRemaining = startingCopies;

}

void Subscriber::addAddress(ShippingAddress address)
{
    addresses.push_back(address);
}

vector<ShippingAddress> Subscriber::getAddresses() const
{
    return addresses;
}

vector<string> Subscriber::getShippingLables()
{
    vector<string> labels;
    for(int i = 0; i < addresses.size(); ++i)
    {
        labels.push_back(addresses.at(i).getName() + "\n" + addresses.at(i).getAddress());
    }
    return labels;
}




