#ifndef MAGAZINEDATABASE_H
#define MAGAZINEDATABASE_H

#include "Magazine.h"
#include <vector>
#include <cstring>
#include <sstream>
#include <stdlib.h>

using namespace std;

class MagazineDatabase
{
    public:
       MagazineDatabase(){

        }

        void addMagazine(Magazine &mag){
            magazineList.push_back(mag);
        }

        vector<Magazine> getMagazines() const{
            return magazineList;
        }

        //PROTOTYPES
        bool removeMagazine(Magazine &mag);

        Magazine getMagazineByTitle(string title);


    private:
        vector<Magazine> magazineList;


    friend ostream &operator<<(ostream &out, const MagazineDatabase &mdb){
        ostringstream convert;

        //write the size of the magazine list to the file
        int numMagazines = mdb.getMagazines().size();
        convert << numMagazines;
        out << convert.str() + "\n";

        //write new line, for reading clarification
        out << "\n";

        //iterate through each magazine, printing it to the file
        vector<Magazine> temp = mdb.getMagazines();
        for(unsigned int i = 0; i < temp.size(); ++i){
            out << temp.at(i);
        }
        return out;
    }
};

#endif // MAGAZINEDATABASE_H
