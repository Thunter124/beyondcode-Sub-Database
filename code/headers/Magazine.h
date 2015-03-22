#ifndef MAGAZINE_H
#define MAGAZINE_H

#include "Subscriber.h"
#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <sstream>
#include <stdlib.h>

using namespace std;

class Magazine
{
    public:
        Magazine(string title){
            this->title = title;
        }

        void changeTitle(string newTitle){
            title = newTitle;
        }

        string getTitle() const {
            return title;
        }

        void addAuthor(Subscriber author){
            authors.push_back(author);
        }

        vector<Subscriber> getAuthors() const {
            return authors;
        }
        vector<Subscriber> getAdCompanies() const {
            return adCompanies;
        }

        void addAdCompany(Subscriber adCompany){
            adCompanies.push_back(adCompany);
        }

        bool removeAuthor(Subscriber author);
        bool removeAd(Subscriber adCompany);

    private:
        string title;
        vector<Subscriber> authors;
        vector<Subscriber> adCompanies;

     friend ostream &operator<<(ostream &out, const Magazine &mag){
        ostringstream convert;

        out << mag.getTitle() + "\n";
        int authorsSize = mag.getAuthors().size();
        convert << authorsSize;
        out << convert.str() + "\n";

        vector<Subscriber> auth = mag.getAuthors();
        for(int i = 0; i < authorsSize; ++i){
            out << auth.at(i);
        }

        int adCompanySize = mag.getAdCompanies().size();
        convert << adCompanySize;
        out << adCompanySize;
        out << "\n";

        vector<Subscriber> ad = mag.getAdCompanies();
        for(int i = 0; i < adCompanySize; ++i){
            out << ad.at(i);
            out << "\n";
        }

        return out;

    }
};

#endif // MAGAZINE_H
